package com.kitri.hello3;

import java.util.Calendar;

public class HelloDao {

	Calendar calendar;
	
	public HelloDao() {
		calendar = Calendar.getInstance();
	}
	
	public String getGreeting() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour > 7 && hour < 12) {
			return "good morning";
		} else if (hour >= 12 && hour < 18) {
			return "good afternoon";
		} else {
			return "good evening";
		}
	}
}
