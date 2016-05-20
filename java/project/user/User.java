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
	protected GHSCalendar cal;
	protected String name;
	protected GregorianCalendar dob;
	protected String school;
	protected Year grade;
	protected Gender gender;
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
	public User(StudentSchedule Schedule, String name, GregorianCalendar dob, String school, Year year, Gender gender)
	{
		this.cal = new GHSCalendar(Reference.startDate, Reference.endDate, Schedule, Reference.breakDays);
		this.name = name;
		this.dob = dob;
		this.grade = year;
		this.gender = gender;
	}
	
	
	/**
	 * 
	 * @param name type: String
	 * @param dob type: GregorianCalendar (note that gregorianCalendar months start with 0 for january)
	 * @param school type: String; name of school
	 * @param gender type: Gender(enum)
	 */
	public User(String name, GregorianCalendar dob, String school, Gender gender)
	{
		this.name = name;
		this.dob = dob;
		this.school = school;
		this.gender = gender;
		this.grade = Year.Unknown;
	}

	/**
	 * 
	 * @param name the name of the student to create
	 */
	public User(String name)
	{
		this(new StudentSchedule(), name, new GregorianCalendar(), "Greenwich High School", Year.Unknown, Gender.OTHER);
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
	public User(String name, int year, int month, int date, int grade, String gender)
	{
		GregorianCalendar d = new GregorianCalendar(year, month-1, date); //TODO error handling in case of invalid date entered
		Gender g;
		if(gender.equalsIgnoreCase("male"))
		{
			g = Gender.MALE;
		}
		else if(gender.equalsIgnoreCase("female"))
		{
			g = Gender.FEMALE;
		}
		else
		{
			g = Gender.OTHER;
		}
		
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
			
		this.cal = new GHSCalendar(Reference.startDate, Reference.endDate, new StudentSchedule(), Reference.breakDays);
		this.name = name;
		this.school = "Greenwich High School";
		this.gender = g;
		this.dob = d;
		this.grade = y;
	}
	
	/**
	 * @param sched student school schedule.
	 * Generates a new calendar schedule with the school startdate, endDate, this schedule, and all days off.
	 */
	public void setSchedule(StudentSchedule sched)
	{
		this.cal = new GHSCalendar(Reference.startDate, Reference.endDate, sched, Reference.breakDays);
	}
	
	//TODO Google acct linkage
	
	public StudentSchedule getSchedule()
	{
		return cal.getStudentSchedule();
	}
	
	public String getName()
	{
		return name;
	}
	protected void setName(String name)
	{
		this.name = name;
	}
	public GregorianCalendar getDob()
	{
		return dob;
	}
	protected void setDob(GregorianCalendar dob)
	{
		this.dob = dob;
	}
	public String getSchool()
	{
		return school;
	}
	protected void setSchool(String school)
	{
		this.school = school;
	}
	public Year getGrade()
	{
		return grade;
	}
	protected void setGrade(Year grade)
	{
		this.grade = grade;
	}
	public Gender getGender()
	{
		return gender;
	}
	protected void setGender(Gender gender)
	{
		this.gender = gender;
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
		return "User [schedule=" + cal + ", name=" + name + ", dob=" + dob + ", school=" + school + ", grade="
				+ grade + ", gender=" + gender + ", history=" + history + "]";
	}
	
	public boolean equals(User c)
	{ 
		boolean equals = false;
		if(c.name.equals(this.name) && c.dob.equals(this.dob))
		{
			equals = true;
		}
		return equals;
	}
}
