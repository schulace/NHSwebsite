package project.serverLogic;

import java.util.Calendar;
import java.util.GregorianCalendar;

import project.schedule.calendar.GHSCalendar;
import project.schedule.classes.StudentSchedule;
import test_data.test_schedules;

public class ServerStart
{
	
	public static void main(String[] args)
	{
//		GHSCalendar cal = new GHSCalendar(4, 21, 2016, 5, 20, 2016, test_schedules.getStudent1Schedule() /*student test schedule*/);
//		Calendar dayOff = new GregorianCalendar(2016, 3, 26);
//		cal.addDayOff(dayOff);
//		System.out.println(cal);
		
//		testing out schedule printing.
		System.out.println(test_schedules.getStudent1Schedule());
	}
}
