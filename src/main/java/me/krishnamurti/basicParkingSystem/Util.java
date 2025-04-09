package me.krishnamurti.basicParkingSystem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util
{
	public static long getDeltaHours(String startDate, String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		LocalDateTime dateTime1 = LocalDateTime.parse(startDate, formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse(endDate, formatter);

		long diffMinutes = Duration.between(dateTime1, dateTime2).toMinutes();

		long hours = diffMinutes / 60;
		if (diffMinutes % 60 != 0) {
			hours++;
		}
		return hours;
	}
}
