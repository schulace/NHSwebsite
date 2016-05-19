package project.user;


import java.util.Date;

import project.schedule.calendar.GHSCalendar;
import project.schedule.calendar.ScheduleHistory;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Year;

public abstract class User
{
	protected GHSCalendar cal;
	protected String name;
	protected Date dob;
	protected String school;
	protected Year grade;
	protected Gender gender;
	protected ScheduleHistory history;
	
	public User(StudentSchedule Schedule, String name, Date dob, String school, Year year, Gender gender)
	{
		this.cal = new GHSCalendar(Schedule);
		this.name = name;
		this.dob = dob;
		this.grade = year;
		this.gender = gender;
	}
	
	public User(String name)
	{
		this(new StudentSchedule(), name, null, "Greenwich High School", null, null);
	}
	
	public User(String name, int year, int month, int date, int grade, String gender)
	{
		Date d = new Date(year, month, date); //TODO error handling in case of invalid date entered
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
			
		this.cal = new StudentSchedule();
		this.name = name;
		this.school = "Greenwich High School";
		this.gender = g;
		this.dob = d;
		this.grade = y;
	}
	
	//TODO Google acct linkage
	
	public StudentSchedule getSchedule()
	{
		return cal;
	}
	protected void setSchedule(StudentSchedule schedule)
	{
		this.cal = schedule;
	}
	public String getName()
	{
		return name;
	}
	protected void setName(String name)
	{
		this.name = name;
	}
	public Date getDob()
	{
		return dob;
	}
	protected void setDob(Date dob)
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
