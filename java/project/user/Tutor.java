/**
 * 
 * @author george
 * object for Tutor
 *
 */

package project.user;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;
import project.studyGuide.TutorReview;

public class Tutor extends User
{
	private ArrayList<SchoolClass> strongClasses;
	private ArrayList<TutorReview> reviews;
	
	/**
	 * calles super constructor
	 * @param name
	 * @param year
	 * @param month
	 * @param date
	 * @param grade
	 * @param gender
	 */
	
	public Tutor(String name, int grade)
	{
		super(name, grade);
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
	
	/**
	 * adds review for the Tutor
	 * @param re
	 */
	
	public void addReview(TutorReview re)
	{
		for(TutorReview r: this.reviews)
		{
			if(re.getStudent().equals(r.getStudent()));
			{
				return;
			}
		}
		reviews.add(re);
	}
}
