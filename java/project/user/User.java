package project.user;


import java.util.Date;

import project.schedule.Schedule;
import project.schedule.ScheduleHistory;
import project.schedule.classes.Year;

public abstract class User
{
	private Schedule schedule;
	private String name;
	private Date dob;
	private String school;
	private Year grade;
	private Gender gender;
	private ScheduleHistory history;
	
	//need to do google acct creds
	public Schedule getSchedule()
	{
		return schedule;
	}
	protected void setSchedule(Schedule schedule)
	{
		this.schedule = schedule;
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
	
}
