package project.user;


import java.util.GregorianCalendar;

import project.schedule.calendar.GHSCalendar;
import project.schedule.calendar.ScheduleHistory;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Year;
import project.serverLogic.Reference;

public abstract class User
{
	protected GHSCalendar cal;
	protected String name;
	protected String school;
	protected Year grade;
	protected ScheduleHistory history;
	
	public User(StudentSchedule Schedule, String name,String school, Year year)
	{
		this.cal = new GHSCalendar(Reference.startDate, Reference.endDate, Schedule, Reference.breakDays);
		this.name = name;
		this.grade = year;
	}
	
	public User(String name, String school)
	{
		this.name = name;
		this.school = school;
	}

	public User(String name)
	{
		this(new StudentSchedule(), name, null, null);
	}
	
	public User(String name, int year, int month, int date, int grade)
	{
		GregorianCalendar d = new GregorianCalendar(year, month-1, date); //TODO error handling in case of invalid date entered
		Gender g;
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
		this.grade = y;
	}
	
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
		return "User [schedule=" + cal + ", name=" + name +", school=" + school + ", grade="
				+ grade + ", history=" + history + "]";
	}
	
	public boolean equals(User c)
	{ 
		boolean equals = false;
		if(c.getName().equals(this.getName()) && c.getGrade().equals(this.getGrade()))
		{
			equals = true;
		}
		return equals;
	}
}
