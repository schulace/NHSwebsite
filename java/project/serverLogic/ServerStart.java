package project.serverLogic;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import com.google.gson.Gson;

import project.schedule.calendar.GHSCalendar;
import test_data.test_schedules;

public class ServerStart
{
	
	public static void main(String[] args)
	{
		ArrayList<GregorianCalendar> daysOff = Reference.setAndGetBreakDays();
		GHSCalendar cal = new GHSCalendar(Reference.startDate, Reference.endDate, test_schedules.getStudent1Schedule(), daysOff);
		Gson gs = new Gson();
		String s = gs.toJson(cal);
		System.out.println(s);
		GHSCalendar newCal = gs.fromJson(s, cal.getClass());
		System.out.println(newCal);
		
//		testing out schedule printing.
//		System.out.println(test_schedules.getStudent1Schedule());
	}
}
