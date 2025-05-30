package me.krishnamurti.basicParkingSystem.parkingLot;

import me.krishnamurti.basicParkingSystem.parkingSlot.ParkingVehicle;



public interface ParkingLot
{
	int getTotalSlots();
	int getAllOccupiedCount();
	int getAllAvailableSlots();

	void listAllOccupiedSlots();

	boolean entry(ParkingVehicle vehicle);
	int exit(String vehicleId, String exitTime);

}
