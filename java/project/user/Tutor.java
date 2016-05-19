package project.user;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;

public class Tutor extends User
{
	public ArrayList<SchoolClass> strongClasses;
	
	public Tutor(String name, int year, int month, int date, int grade, String gender)
	{
		super(name, year, month, date, grade, gender);
	}
	
	public boolean addStrongClass(SchoolClass newClass)
	{
		for(SchoolClass c:this.strongClasses)
		{
			if(c.equals(newClass)) 
			{
				return false;
			}
		}
		strongClasses.add(newClass);
		return true;	
	}
}
