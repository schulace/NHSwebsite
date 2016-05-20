package project.serverLogic;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import project.schedule.calendar.GHSCalendar;
import test_data.test_schedules;

public class ServerStart
{
	
	public static void main(String[] args)
	{
		ArrayList<GregorianCalendar> daysOff = Reference.setAndGetBreakDays();
		GHSCalendar cal = new GHSCalendar(Reference.startDate, Reference.endDate, test_schedules.getStudent1Schedule(), daysOff);
		System.out.println(cal);
		
		
//		testing out schedule printing.
//		System.out.println(test_schedules.getStudent1Schedule());
	}
}
