/**
 * 
 * @author george
 * object for Teacher
 *
 */

package project.user;

import project.schedule.classes.StudentSchedule;
import project.serverLogic.userFactory;

public class Teacher extends User
{ //we may not even need this, but its nice to have (just in case)
	private String name;
	private String school;
	
	/**
	 * basic constructor 
	 * @param n
	 * @param school
	 * @param g
	 */
	
	public Teacher(String name, StudentSchedule Schedule)
	{
		super(name,Schedule);
	}
	
	public Teacher(String name, String s){
		super(name);
		this.school = s;
	}
	
	public Teacher(String n)
	{
		super(n);
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
