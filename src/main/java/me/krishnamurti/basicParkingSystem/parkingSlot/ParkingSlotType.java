package me.krishnamurti.basicParkingSystem.parkingSlot;

public enum ParkingSlotType
{
	SMALL("small", 10),
	MID("mid", 20),
	LARGE("large", 30);

	private final String type;
	private final int price;

	private ParkingSlotType(String type, int price)
	{
		this.type = type;
		this.price = price;
	}

	public String getType()
	{
		return type;
	}

	public int getPrice()
	{
		return price;
	}
}
