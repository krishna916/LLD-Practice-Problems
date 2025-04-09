package me.krishnamurti.basicParkingSystem.parkingSlot;

public interface IParkingVehicle
{
	String getVehicleId();
	void setVehicleId(String vehicleId);
	ParkingSlotType getSlotType();
	void setSlotType(ParkingSlotType slotType);
	String getEntryTime();
	void setEntryTime(String entryTime);

}
