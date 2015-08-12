package com.app.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rajdeep siddhapura.
 */
public class AppDateUtil
{
	public static Long getCurrentTime()
	{
		Date date = new Date();
		long timeMilli = date.getTime();
		return timeMilli;
	}

	public static String getFormatedDate(Long timeMilli)
	{
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeMilli);
		return formatter.format(calendar.getTime());
	}

	public static String getFormatedDateTime(Long timeMilli)
	{
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeMilli);
		return formatter.format(calendar.getTime());
	}

	public static String getFormatedTime(Long timeMilli)
	{
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeMilli);
		return formatter.format(calendar.getTime());
	}
}
