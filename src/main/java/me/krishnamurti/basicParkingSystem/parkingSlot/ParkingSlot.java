package me.krishnamurti.basicParkingSystem.parkingSlot;

public class ParkingSlot {

	private ParkingSlotType slotType;
	private ParkingVehicle parkedVehicle;

	public ParkingSlot(ParkingSlotType slotType, ParkingVehicle parkingVehicle)
	{
		this.slotType = slotType;
		this.parkedVehicle = parkingVehicle;
	}

	public ParkingSlotType getSlotType()
	{
		return slotType;
	}

	public void setSlotType(ParkingSlotType slotType)
	{
		this.slotType = slotType;
	}

	public ParkingVehicle getParkedVehicle()
	{
		return parkedVehicle;
	}

	public void setParkedVehicle(ParkingVehicle parkedVehicle)
	{
		this.parkedVehicle = parkedVehicle;
	}

}
