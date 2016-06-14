package project.schedule.calendar;

import java.util.Arrays;
import java.util.Calendar;

import project.schedule.classes.LetterDay;
import project.schedule.classes.SchoolClass;

/**
 * 
 * @author a
 * contains a Calendar for the day, the letterday of a day, and an array of classes in time order for the day.
 */
public class GHSCalendarDay
{
	public Calendar cal;
	public LetterDay letterDay;
	public SchoolClass[] classes;
	
	public GHSCalendarDay(Calendar cal, LetterDay day, SchoolClass[] classes)
	{
		this.cal = cal;
		this.letterDay = day;
		this.classes = classes;
	}

	@Override
	public String toString()
	{
		return "GHSCalendarDay [date=" + (cal.get(Calendar.MONTH) +1)+ "/" + cal.get(Calendar.DAY_OF_MONTH)+
				"/" + cal.get(Calendar.YEAR) +  ",letterDay=" + letterDay  + " " + "classes " + Arrays.toString(classes)+ "]";
	}
	
	@Override
	public GHSCalendarDay clone()
	{
		
		GHSCalendarDay day = new GHSCalendarDay((Calendar)this.cal.clone(), this.letterDay, this.classes.clone());
		return day;
		
	}
}
