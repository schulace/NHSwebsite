/**
 * 
 * @author george
 * object for Teacher
 *
 */

package project.user;

import project.studyGuide.TutorReview;

public class Teacher
{ //we may not even need this, but its nice to have (just in case)
	private String name;
	private String school;
	private Gender gender;
	private TutorReview re;
	
	/**
	 * basic constructor 
	 * @param n
	 * @param school
	 * @param g
	 */
	
	public Teacher(String n, String school, Gender g)
	{
		this.name = n;
		this.school = school;
		this.gender = g;
	}
	
	/**
	 * no parameter constructor (mainly for testing)
	 */
	
	public Teacher()
	{
		this("test_teacher", "GHS", Gender.MALE);
	}
	
	/**
	 * allows the teacher to rate a tutor
	 * @param placeholder
	 * @param score
	 * @param review
	 */

	public void rateTutor(Tutor placeholder, int score, String review)
	{
		re = new TutorReview(placeholder,this, score, review);
		placeholder.addReview(re);
	}
}
