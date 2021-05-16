package com.csagroup.Utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SubscritptionTime {

	public static String getSubscriptionDays() {
		Calendar subscriptionDay = new GregorianCalendar(2019, Calendar.DECEMBER, 16);
		Calendar today = new GregorianCalendar();
		today.setTime(new Date());
		long daysDiff = today.get(Calendar.DAY_OF_MONTH) - subscriptionDay.get(Calendar.DAY_OF_MONTH);
		long subscriptionDaysLeft = 364 - daysDiff;
		System.out.println("Subscription Days Left :" + subscriptionDaysLeft);
		return Long.toString(subscriptionDaysLeft);
	}
}
