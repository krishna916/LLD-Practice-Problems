package me.krishnamurti.basicParkingSystem;

import me.krishnamurti.basicParkingSystem.parkingLot.ParkingLot;
import me.krishnamurti.basicParkingSystem.parkingSlot.ParkingVehicle;

public class ParkingSystem
{
	private final ParkingLot parkingLot;

	public ParkingSystem(ParkingLot parkingLot)
	{
		this.parkingLot = parkingLot;
	}

	public boolean entry(ParkingVehicle vehicle) {
		return parkingLot.entry(vehicle);
	}

	public int exit(String vehicleId, String exitTime) {
		return parkingLot.exit(vehicleId, exitTime);
	}

	public void listAllOccupiedSlot() {
		parkingLot.listAllOccupiedSlots();
	}

	public int getTotalSlots() {
		return parkingLot.getTotalSlots();
	}

	public int getAllOccupiedCount() {
		return parkingLot.getAllOccupiedCount();
	}

	public int getAllAvailableSlots() {
		return parkingLot.getAllAvailableSlots();
	}


}
