package project.schedule.calendar;

import java.util.Calendar;
import java.util.Date;

import project.schedule.classes.LetterDay;

public class GHSCalendarDay
{
	public Calendar cal;
	public LetterDay letterDay;
	
	public GHSCalendarDay(Calendar cal, LetterDay day)
	{
		this.cal = cal;
		this.letterDay = day;
	}

	@Override
	public String toString() {
		return "GHSCalendarDay [date=" + (cal.get(Calendar.MONTH) +1)+ "/" + cal.get(Calendar.DAY_OF_MONTH)+ "/" + cal.get(Calendar.YEAR) +  ", letterDay=" + letterDay  +" " + "weekday =" + " " +this.cal.get(Calendar.DAY_OF_WEEK) + "]";
	}
	
	
}
