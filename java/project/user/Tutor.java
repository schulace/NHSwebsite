package project.user;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;

public class Tutor extends User
{
	public Tutor(String name, int year, int month, int date, int grade, String gender)
	{
		super(name, year, month, date, grade, gender);
	}

	public ArrayList<SchoolClass> strongClasses;

	public boolean addStrongClass(SchoolClass newClass)
	{
		for(SchoolClass c:this.strongClasses)
		{
			if(c.equals(newClass)) //TODO implement .equals() method for schoolClass
			{
				return false;
			}
		}
		return false;		
	}
}
