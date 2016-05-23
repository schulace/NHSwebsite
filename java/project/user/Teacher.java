/**
 * 
 * @author george
 * object for Teacher
 *
 */

package project.user;
//TODO make this class have more admin shit
import project.studyGuide.TutorReview;

public class Teacher
{ //we may not even need this, but its nice to have (just in case)
	private String name;
	private String school;
	
	/**
	 * basic constructor 
	 * @param n
	 * @param school
	 * @param g
	 */
	
	public Teacher(String n, String school)
	{
		this.name = n;
		this.school = school;
	}
	
	/**
	 * no parameter constructor (mainly for testing)
	 */
	
	public Teacher()
	{
		this("test_teacher", "GHS");
	}
	
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
