package com.andrerip.javaref.java8;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeTests {

	public static void main(String[] args) {

		LocalDate andre = LocalDate.of(1981, Month.SEPTEMBER, 15);
		LocalDate now = LocalDate.now();

		Period idade = Period.between(andre, now);
		System.out.println(idade.getYears() + " anos " + idade.getMonths() + " meses e " + idade.getDays() + " dias");

		Long untilNow = andre.until(now, ChronoUnit.MONTHS);
		System.out.println(untilNow + " meses de vida");

		Long daysUntilNow = andre.until(now, ChronoUnit.DAYS);
		System.out.println(daysUntilNow + " dias de vida");

		String format = DateTimeFormatter.ISO_DATE.format(andre);
		System.out.println(format);

	}

}
