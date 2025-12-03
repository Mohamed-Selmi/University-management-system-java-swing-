package controllers;

import java.time.LocalDate;

public class DateConversion implements IDateConversion{

	@Override
	public LocalDate convertDate(int year, int month, int day) {
		String yearS=String.valueOf(year);
		String monthS=String.valueOf(month);
		String dayS=String.valueOf(day);
		String seperator="-";
		StringBuilder dateS=new StringBuilder();
		dateS.append(yearS).append(seperator).append(monthS).append(seperator).append(dayS);
		LocalDate date=LocalDate.parse(dateS);
		return date;
	}//stream maybe?

}
