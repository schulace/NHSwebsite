package project.schedule.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import project.schedule.classes.LetterDay;

public class GHSCalendar
{
	public Date startDate;
	public Date endDate;
	public ArrayList<GHSCalendarDay> cal;
	public ArrayList<Integer> daysOff;
	
	public GHSCalendar(Date startDate, Date endDate)
	{
		Calendar CurrentDate = Calendar.getInstance();
		CurrentDate.setTime(startDate);
		LetterDay day = LetterDay.A;
		
		while(CurrentDate.before(endDate))
		{
			if(!(CurrentDate.get(Calendar.DAY_OF_WEEK) == 6) && !(CurrentDate.get(Calendar.DAY_OF_WEEK) == 0) && !daysOff.contains(CurrentDate.getFirstDayOfWeek()))
			{
				cal.add(new GHSCalendarDay(CurrentDate.getTime(), day));
				day = day.getNextLetterDay();
			}
			
		}
	}
	
}
