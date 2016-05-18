package project.serverLogic;

import java.util.Calendar;
import java.util.GregorianCalendar;

import project.schedule.calendar.GHSCalendar;

public class ServerStart
{
	public static void main(String[] args)
	{
		GHSCalendar cal = new GHSCalendar(11, 30, 2015, 1, 3, 2016);
		Calendar dayOff = new GregorianCalendar(2016, 3, 26);
		cal.addDayOff(dayOff);
		System.out.println(cal);
	}
}
