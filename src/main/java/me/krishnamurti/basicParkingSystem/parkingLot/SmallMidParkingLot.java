package me.krishnamurti.basicParkingSystem.parkingLot;

import me.krishnamurti.basicParkingSystem.Util;
import me.krishnamurti.basicParkingSystem.parkingSlot.ParkingSlotType;
import me.krishnamurti.basicParkingSystem.parkingSlot.ParkingSlot;
import me.krishnamurti.basicParkingSystem.parkingSlot.ParkingVehicle;

import java.util.HashMap;
import java.util.Map;

public class SmallMidParkingLot implements ParkingLot
{
	private int totalParkingLot;
	private int maxSmallParkingLot;
	private int maxMidParkingLot;
	private Map<String, ParkingSlot> occupiedParkingLotCarMap;
	private int occupiedSmallParkingLot;
	private int occupiedMidParkingLot;

	public SmallMidParkingLot() {

	}

	public SmallMidParkingLot(int maxSmallParkingLot, int maxMidParkingLot) {
		this.totalParkingLot = maxMidParkingLot + maxSmallParkingLot;
		this.maxSmallParkingLot = maxSmallParkingLot;
		this.maxMidParkingLot = maxMidParkingLot;

		this.occupiedParkingLotCarMap = new HashMap<>();
	}

	@Override
	public int getTotalSlots()
	{
		return this.totalParkingLot;
	}

	@Override
	public int getAllOccupiedCount()
	{
		return this.occupiedParkingLotCarMap.size();
	}

	@Override
	public int getAllAvailableSlots()
	{
		return this.totalParkingLot - (occupiedMidParkingLot + occupiedSmallParkingLot);
	}

	public void listAllOccupiedSlots() {
		if (!this.occupiedParkingLotCarMap.isEmpty())  {
			this.occupiedParkingLotCarMap.forEach((id,ps) -> {
				System.out.printf("Card Id: %s, car type: %s, slot type: %s, car parked time: %s%n",
						ps.getParkedVehicle().getVehicleId(), ps.getSlotType(), ps.getSlotType().getType(), ps.getParkedVehicle().getEntryTime());
			});
		} else {
			System.out.println("No Parking space is occupied yet!");
		}
	}

	public boolean entry(ParkingVehicle vehicle) {
		if (occupiedParkingLotCarMap.containsKey(vehicle.getVehicleId())) {
			throw new IllegalArgumentException("Duplicate Vehicle Id!!");
		}

		if (isSlotsAvailable(vehicle.getSlotType())) {
			if (vehicle.getSlotType() == ParkingSlotType.SMALL) {
				if (isMidFreeForSmall())
				{
					occupiedMidParkingLot++;
				} else {
					occupiedSmallParkingLot++;
				}
			} else {
				occupiedMidParkingLot++;
			}
			ParkingSlot allocatedSlot = allocateParkingSlot(vehicle);
			occupiedParkingLotCarMap.put(vehicle.getVehicleId(), allocatedSlot);
			return true;
		}

		return false;
	}

	public int exit(String vehicleId, String exitTime) {
		if (!occupiedParkingLotCarMap.containsKey(vehicleId)) {
			throw new IllegalArgumentException("No vehicle with that Id is parked");
		}
		ParkingSlot occupiedSlot = occupiedParkingLotCarMap.get(vehicleId);
		ParkingVehicle parkedVehicle = occupiedSlot.getParkedVehicle();
		long hoursParked = Util.getDeltaHours(parkedVehicle.getEntryTime(), exitTime);
		System.out.println("Total Parked hours: " + hoursParked);
		freeUpAllocatedSlot(occupiedSlot);
		return (int)hoursParked * parkedVehicle.getSlotType().getPrice();
	}


	private boolean isSmallFull() {
		return this.occupiedSmallParkingLot == this.maxSmallParkingLot;
	}

	private boolean isMidFull() {
		return this.maxMidParkingLot == this.occupiedMidParkingLot;
	}

	private boolean isMidFreeForSmall() {
		if (isSmallFull()) {
			return !isMidFull();
		}
		return false;
	}

	private boolean isSlotsAvailable(ParkingSlotType slotType) {
		if (isMidFull() && isSmallFull()) {
			return false;
		}

		if (slotType == ParkingSlotType.MID && isMidFull()) {
			return false;
		}
		return true;
	}

	private ParkingSlot allocateParkingSlot(ParkingVehicle parkingVehicle) {
		ParkingSlot allocatedSlot = null;
		if (parkingVehicle.getSlotType() == ParkingSlotType.SMALL) {
			allocatedSlot = new ParkingSlot(
					isSmallFull() ? ParkingSlotType.MID : ParkingSlotType.SMALL,
					parkingVehicle
			);
		} else {
			allocatedSlot = new ParkingSlot(ParkingSlotType.MID, parkingVehicle);
		}
		return allocatedSlot;
	}

	private void freeUpAllocatedSlot(ParkingSlot slot) {
		ParkingVehicle parkedVehicle = slot.getParkedVehicle();
		if (parkedVehicle.getSlotType() == ParkingSlotType.SMALL) {
			occupiedSmallParkingLot--;
		} else if (parkedVehicle.getSlotType() == ParkingSlotType.MID) {
			occupiedMidParkingLot--;
		}
		occupiedParkingLotCarMap.remove(parkedVehicle.getVehicleId());
	}

}
