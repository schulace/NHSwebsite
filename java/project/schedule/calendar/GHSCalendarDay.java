package project.schedule.calendar;

import java.util.Date;

import project.schedule.classes.LetterDay;

public class GHSCalendarDay
{
	public Date date;
	public LetterDay letterDay;
	public boolean isWeekDay;
	
	public GHSCalendarDay(Date date, LetterDay day)
	{
		this.date = date;
		this.letterDay = day;
	}
}
