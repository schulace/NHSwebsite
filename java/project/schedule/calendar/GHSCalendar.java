package project.schedule.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import project.schedule.classes.LetterDay;

public class GHSCalendar
{
	public Calendar startDate;
	public Calendar endDate;
	public ArrayList<GHSCalendarDay> cal = new ArrayList<GHSCalendarDay>();
	public ArrayList<Integer> daysOff = new ArrayList<Integer>();
	
	public GHSCalendar(int monthStart, int dayStart, int yearStart, int monthEnd, int dayEnd, int yearEnd)
	{
		this.startDate = new GregorianCalendar(yearStart, monthStart -1, dayStart); //TODO fuck you java. why does the week start at 1, and months start at 0;
		this.endDate = new GregorianCalendar(yearEnd, monthEnd -1, dayEnd);
		this.refreshCalendar();
	}
	
	public void refreshCalendar()
	{
		Calendar CurrentDate = (Calendar)this.startDate.clone();
		LetterDay day = LetterDay.A;
		
		while(CurrentDate.before(endDate))
		{
			if(!(CurrentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) && !(CurrentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) && !this.daysOff.contains(CurrentDate.get(Calendar.DAY_OF_YEAR))) //TODO why the fuck is saturday 3 and Sunday 4
			{
				this.cal.add(new GHSCalendarDay(CurrentDate, day));
				day = day.getNextLetterDay();
			}
			Calendar nextDate = (Calendar) CurrentDate.clone();
			CurrentDate = nextDate;
			CurrentDate.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	public void setDaysOff(ArrayList<Calendar> calArray)
	{
		this.daysOff = new ArrayList<Integer>();
		for(Calendar cal : calArray)
		{
			addDayOff(cal);
		}
	}
	
	public void addDayOff(Calendar day)
	{
		int intDay = day.get(Calendar.DAY_OF_YEAR);
		System.err.println(intDay);
		if(!this.daysOff.contains(intDay))
		{
			this.daysOff.add(intDay);
			refreshCalendar();
		}
		
	}

	@Override
	public String toString()
	{
		String s = "";
		for(GHSCalendarDay day:this.cal)
		{
			s += day.toString() + "\n";
		}
		return s;
	}
	
	
}
