package project.schedule.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import project.schedule.classes.LetterDay;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
/**
 * 
 * @author schulace
 * Calendar object specific to Greenwich high school.
 * This draws up a year-long student schedule from a given end-date, start date, days off list, and a "block schedule"
 * the "meat" of this class is an arrayList of GHSCalendarDay. Each calendarDay contains the student's schedule for the day.
 * 
 */
public class GHSCalendar
{
	public Calendar startDate;
	public Calendar endDate;
	public ArrayList<GHSCalendarDay> cal = new ArrayList<GHSCalendarDay>();
	public ArrayList<GregorianCalendar> daysOff = new ArrayList<GregorianCalendar>();
	public StudentSchedule studentSchedule;
	
	public StudentSchedule getStudentSchedule()
	{
		return studentSchedule;
	}

	/**
	 * 
	 * @param studentSchedule a schedule object
	 * sets the studentSchedule object to the schedule inputed, then runs refreshCalendar() to set up everything by day again.
	 */
	public void setStudentSchedule(StudentSchedule studentSchedule)
	{
		this.studentSchedule = studentSchedule;
		this.refreshCalendar();
	}
	/**
	 * 
	 * @param monthStart
	 * @param dayStart
	 * @param yearStart
	 * @param monthEnd
	 * @param dayEnd
	 * @param yearEnd
	 * @param studentSched
	 * 
	 * creates a new GHSCalendar with no days off and the inputted studentSchedule
	 * @deprecated
	 */
	public GHSCalendar(int monthStart, int dayStart, int yearStart, int monthEnd, int dayEnd, int yearEnd, StudentSchedule studentSched)
	{
		this.startDate = new GregorianCalendar(yearStart, monthStart -1, dayStart,0,0,0);
		this.endDate = new GregorianCalendar(yearEnd, monthEnd -1, dayEnd,0,0,0);
		this.studentSchedule = studentSched;
		this.refreshCalendar();
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param studentSched
	 * 
	 * creates a new GHSCalendar with no break days and the inputted student schedule.
	 * @deprecated
	 */
	public GHSCalendar(GregorianCalendar startDate, GregorianCalendar endDate, StudentSchedule studentSched)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		this.startDate.set(this.startDate.get(Calendar.YEAR), this.startDate.get(Calendar.MONTH), this.startDate.get(Calendar.DATE),0,0,0);
		this.endDate.set(this.endDate.get(Calendar.YEAR), this.endDate.get(Calendar.MONTH), this.endDate.get(Calendar.DATE),0,0,0);
		this.studentSchedule = studentSched;
		this.refreshCalendar();
	}
	/**
	 * 
	 * @param startDate typically Reference.StartDate
	 * @param endDate typically Reference.endDate
	 * @param studentSched a student schedule
	 * @param breakDays typically Reference.getBreakDays
	 */
	public GHSCalendar(GregorianCalendar startDate, GregorianCalendar endDate, StudentSchedule studentSched, ArrayList<GregorianCalendar> breakDays)
	{
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.startDate.set(this.startDate.get(Calendar.YEAR), this.startDate.get(Calendar.MONTH), this.startDate.get(Calendar.DATE),0,0,0);
		this.endDate.set(this.endDate.get(Calendar.YEAR), this.endDate.get(Calendar.MONTH), this.endDate.get(Calendar.DATE),0,0,0);
		this.studentSchedule = studentSched;
		this.daysOff = breakDays;
		this.refreshCalendar();
		
		
	}
	
	public boolean isDateInDaysOff(GregorianCalendar date)
	{
		for(GregorianCalendar dayOff: daysOff)
		{
			if(fuzzyDateEquals(date, dayOff))
			{
				return true;
			}
		}
		return false;	
	}
	
	public boolean fuzzyDateEquals(GregorianCalendar date, GregorianCalendar dayOff)
	{
		if(date.get(Calendar.YEAR) == dayOff.get(Calendar.YEAR) && date.get(Calendar.MONTH) == dayOff.get(Calendar.MONTH) && date.get(Calendar.DATE) == dayOff.get(Calendar.DATE))
		{
			return true;
		}
		return false;
	}
	/**
	 * remakes the calendar based off this calendar's current data.
	 */
	public void refreshCalendar()
	{
		GregorianCalendar CurrentDate = (GregorianCalendar)this.startDate.clone();
		LetterDay day = LetterDay.A;
		this.cal = new ArrayList<GHSCalendarDay>();
		while(CurrentDate.before(endDate))
		{
			if(!(CurrentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) && !(CurrentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) && !isDateInDaysOff(CurrentDate))
			{
				SchoolClass[] SchoolClasses = studentSchedule.getBlockSchedule()[day.getIntDay()];
				this.cal.add(new GHSCalendarDay(CurrentDate, day, SchoolClasses));
				day = day.getNextLetterDay();
			}
			GregorianCalendar nextDate = (GregorianCalendar)CurrentDate.clone();
			CurrentDate = nextDate;
			CurrentDate.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	public void setDaysOff(ArrayList<GregorianCalendar> calArray)
	{
		this.daysOff = calArray;
		refreshCalendar();
	}
	
	public void addDayOff(GregorianCalendar day)
	{
		if(!isDateInDaysOff(day))
		{
			daysOff.add(day);
			refreshCalendar();
		}
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public ArrayList<GHSCalendarDay> getCal() {
		return cal;
	}

	public void setCal(ArrayList<GHSCalendarDay> cal) {
		this.cal = cal;
	}

	public ArrayList<GregorianCalendar> getDaysOff() {
		return daysOff;
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
