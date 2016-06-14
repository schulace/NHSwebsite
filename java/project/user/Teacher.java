/**
 * 
 * @author george
 * object for Teacher
 *
 */

package project.user;

import project.schedule.calendar.GHSCalendar;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Year;
import project.serverLogic.Reference;
import project.serverLogic.userFactory;

public class Teacher
{ //we may not even need this, but its nice to have (just in case)
	private String name;
	private String school;
	private GHSCalendar userCalendar;
	private Year grade;

	/**
	 * basic constructor 
	 * @param n
	 * @param school
	 * @param g
	 */
	
	public Teacher(String n, StudentSchedule Schedule)
	{
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, Schedule, Reference.breakDays);
		this.name = n;
	}
	
	public Teacher(StudentSchedule Schedule, String name,  Year year)
	{
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, Schedule, Reference.breakDays);
		this.name = name;
		this.grade = year;
	}
	
	public Teacher(String name, String s){
		this(new StudentSchedule(), name, Year.Unknown);
		this.school = s;
	}
		
	public Teacher(String name)
	{
		this(new StudentSchedule(), name, Year.Unknown);
	}
	
	public void prepForJson()
	{
		this.userCalendar.cal = null;
		this.userCalendar.daysOff = null;
		this.userCalendar.endDate = null;
		this.userCalendar.startDate = null;
	}
	
	/**
	 * no parameter constructor (mainly for testing)
	 */
	
	//public Teacher()
	//{
	//	this("test_teacher", "GHS");
	//}
	
	/**
	 * allows the teacher to rate a tutor
	 * @param placeholder
	 * @param score
	 * @param review
	 */

	public String getName() 
	{
		return name;
	}
	
	public void removeMyself()
	{
		userFactory.removeTeacher(this);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSchool()
	{
		return school;
	}

	public void setSchool(String school) 
	{
		this.school = school;
	}
}
