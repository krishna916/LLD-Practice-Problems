package me.krishnamurti.basicParkingSystem;

import me.krishnamurti.basicParkingSystem.parkingLot.ParkingLot;
import me.krishnamurti.basicParkingSystem.parkingLot.SmallMidParkingLot;
import me.krishnamurti.basicParkingSystem.parkingSlot.ParkingSlotType;
import me.krishnamurti.basicParkingSystem.parkingSlot.ParkingVehicle;

public class Main
{
	public static void main(String[] args)
	{
		ParkingLot parkingLot = new SmallMidParkingLot(0, 12);

		ParkingSystem system = new ParkingSystem(parkingLot);

		System.out.println(system.getAllAvailableSlots());
		System.out.println(system.getAllOccupiedCount());

		boolean success = system.entry(new ParkingVehicle("12", ParkingSlotType.SMALL, "05-04-2025 13:34"));
		if (!success) {
			System.out.println("No Space available!!");
			System.exit(0);
		}

		System.out.println(system.getAllOccupiedCount());



		system.listAllOccupiedSlot();
		int price = system.exit("12", "05-04-2025 14:20");

		System.out.println("price of vehicle-12: " + price);

		system.listAllOccupiedSlot();
	}
}
