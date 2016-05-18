package project.schedule.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import project.schedule.classes.LetterDay;

public class GHSCalendar
{
	public Calendar startDate = Calendar.getInstance();
	public Calendar endDate = Calendar.getInstance();
	public ArrayList<GHSCalendarDay> cal = new ArrayList<GHSCalendarDay>();
	public ArrayList<Integer> daysOff = new ArrayList<Integer>();
	
	public GHSCalendar(int monthStart, int dayStart, int yearStart, int monthEnd, int dayEnd, int yearEnd)
	{
		startDate.clear();
		startDate.set(yearStart, monthStart, dayStart);
		endDate.clear();
		endDate.set(yearEnd, monthEnd, dayEnd);
		Calendar CurrentDate = (Calendar)startDate.clone();
		LetterDay day = LetterDay.A;
		
		while(CurrentDate.before(endDate))
		{
			if(!(CurrentDate.get(Calendar.DAY_OF_WEEK) == 3) && !(CurrentDate.get(Calendar.DAY_OF_WEEK) == 4) && !daysOff.contains(CurrentDate.get(Calendar.DAY_OF_YEAR))) //TODO why the fuck is saturday 3 and Sunday 4
			{
				cal.add(new GHSCalendarDay(CurrentDate, day));
				day = day.getNextLetterDay();
			}
			Calendar nextDate = (Calendar) CurrentDate.clone();
			CurrentDate = nextDate;
			CurrentDate.add(Calendar.DAY_OF_YEAR, 1);
			
		}
	}
	
	public void setDaysOff(Date[] dates)
	{
		for(Date d: dates)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			daysOff.add(cal.get(Calendar.DAY_OF_YEAR));
		}
		
	}

	@Override
	public String toString()
	{
		String s = "";
		for(GHSCalendarDay day:cal)
		{
			s += day.toString() + "\n";
		}
		return s;
	}
	
	
}
