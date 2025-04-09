package me.krishnamurti.basicParkingSystem.parkingSlot;

public class ParkingVehicle implements IParkingVehicle
{
	private String vehicleId;
	private ParkingSlotType slotType;
	private String entryTime;

	public ParkingVehicle(String vehicleId, ParkingSlotType slotType, String entryTime)
	{
		this.vehicleId = vehicleId;
		this.slotType = slotType;
		this.entryTime = entryTime;
	}

	public String getVehicleId()
	{
		return vehicleId;
	}

	public void setVehicleId(String vehicleId)
	{
		this.vehicleId = vehicleId;
	}

	public ParkingSlotType getSlotType()
	{
		return slotType;
	}

	public void setSlotType(ParkingSlotType slotType)
	{
		this.slotType = slotType;
	}

	public String getEntryTime()
	{
		return entryTime;
	}

	public void setEntryTime(String entryTime)
	{
		this.entryTime = entryTime;
	}
}
