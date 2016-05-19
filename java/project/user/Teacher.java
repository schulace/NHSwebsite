package project.user;

import java.sql.Date;
import java.util.ArrayList;

import project.schedule.classes.SchoolClass;


public class Teacher
{ //we may not even need this, but its nice to have (just in case)
	public String name;
	public String school;
	public Gender gender;
	
	public Teacher(String n, String school, Gender g)
	{
		this.name = n;
		this.school = school;
		this.gender = g;
	}

	public Teacher()
	{
		this("testProf", "GHS", Gender.MALE);
	}
	
	public void rateTutor(Tutor placeholder)
	{
		
	}
}
