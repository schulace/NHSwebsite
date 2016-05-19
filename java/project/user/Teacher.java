package project.user;

import java.sql.Date;
import java.util.ArrayList;

import project.schedule.classes.SchoolClass;


public class Teacher
{ //we may not even need this, but its nice to have (just in case)
	private String name;
	private String school;
	private Gender gender;
	
	public Teacher(String n, String school, Gender g)
	{
		this.name = n;
		this.school = school;
		this.gender = g;
	}
	
	public Teacher()
	{
		this("test_teacher", "GHS", Gender.MALE);
	}

//TODO george put this in the admininstrator thing.
//	public void rateTutor(Tutor placeholder, int score, String review)
//	{
//		placeholder.teacherReview(score, review);
//	}
}
