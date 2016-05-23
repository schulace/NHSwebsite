package project.user;


import java.util.GregorianCalendar;

import project.schedule.calendar.GHSCalendar;
import project.schedule.calendar.ScheduleHistory;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Year;
import project.serverLogic.Reference;

/**
 * @author schulace
 * abstract class for user. extended by student and tutor.
 * contains a school calendar, name, date of birth, grade, gender.
 */
public abstract class User
{
	protected GHSCalendar userCalendar;
	protected String name;
	protected Year grade;
	protected ScheduleHistory history;
	
	
	
	/**
	 * 
	 * @param Schedule type: StudentSchedule
	 * @param name type: String
	 * @param dob type: GregorianCalendar (note that gregorianCalendar months start with 0 for january)
	 * @param school type: String; name of school
	 * @param year	type: Year (enum)
	 * @param gender type: Gender(enum)
	 */
	public User(StudentSchedule Schedule, String name,  Year year)
	{
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, Schedule, Reference.breakDays);
		this.name = name;
		this.grade = year;
	}
	
	


	/**
	 * 
	 * @param name the name of the student to create
	 */
	public User(String name)
	{
		this(new StudentSchedule(), name, Year.Unknown);
	}
	
	public User(String name, int grade)
	{
		this(new StudentSchedule(), name, grade);
	}
	
	/**
	 * 
	 * @param name student name
	 * @param year year of birth
	 * @param month month the user was born
	 * @param date day user was born
	 * @param grade school grade (int between 9 and 12)
	 * @param gender (takes "male" or "female" defaults to other)
	 */
	public User(StudentSchedule sched, String name, int grade)
	{		
		Year y;
		switch(grade)
		{
			case 9: y = Year.Freshman;
			break;
			case 10: y = Year.Sophomore;
			break;
			case 11: y = Year.Junior;
			break;
			case 12: y = Year.Senior;
			break;
			default: y = Year.Unknown;
		}
			
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, sched, Reference.breakDays);
		this.name = name;
		this.grade = y;
	}
	
	public GHSCalendar getCalendar()
	{
		return this.userCalendar;
	}
	
	/**
	 * @param sched student school schedule.
	 * Generates a new calendar schedule with the school startdate, endDate, this schedule, and all days off.
	 */
	public void setSchedule(StudentSchedule sched)
	{
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, sched, Reference.breakDays);
	}
	
	//TODO Google acct linkage
	
	public StudentSchedule getSchedule()
	{
		return userCalendar.getStudentSchedule();
	}
	
	public String getName()
	{
		return name;
	}
	protected void setName(String name)
	{
		this.name = name;
	}
	public Year getGrade()
	{
		return grade;
	}
	protected void setGrade(Year grade)
	{
		this.grade = grade;
	}
	protected ScheduleHistory getHistory()
	{
		return history;
	}
	protected void setHistory(ScheduleHistory history)
	{
		this.history = history;
	}
	
	
	
	@Override
	public String toString()
	{
		return "User [cal=" + userCalendar + ", name=" + name + ", grade=" + grade + ", history=" + history + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userCalendar == null) {
			if (other.userCalendar != null)
				return false;
		} else if (!userCalendar.equals(other.userCalendar))
			return false;
		if (grade != other.grade)
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




	
}
