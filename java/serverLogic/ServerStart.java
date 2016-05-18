package serverLogic;

import java.util.Calendar;

import project.schedule.calendar.GHSCalendar;

public class ServerStart
{
	public static void main(String[] args)
	{
		GHSCalendar cal = new GHSCalendar(5, 4, 2016, 5, 20, 2016);
		System.out.println(cal);
	}
}
