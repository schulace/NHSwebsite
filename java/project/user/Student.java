/**
 * 
 * @author george
 * object for Student
 *
 */

package project.user;
import java.util.ArrayList;

import project.requests.Request;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.serverLogic.requestManager;
import project.serverLogic.userFactory;
import project.studyGuide.Review;
import project.studyGuide.StudyGuide;
import project.studyGuide.TutorReview;
public class Student extends User
{
	private ArrayList<SchoolClass> StrugglingClasses;

	/**
	 * constructor calls User's 
	 * @param name
	 * @param year
	 * @param month
	 * @param date
	 * @param grade
	 */
	
	public Student(String name, int year)
	{
		super(new StudentSchedule(), name, year);
	}
	
	public Student(StudentSchedule sched, String name, int year)
	{
		super(sched, name, year);
	}

	public void requestHelp(SchoolClass sClass)
	{
		Request request1 = new Request(this,sClass.getSubject(),true);
		requestManager.addRequest(request1);
	}
	
	/**
	 * sets a struggling class for the student
	 * @param sClass
	 * @return
	 */
	
	public boolean setStruggle (SchoolClass sClass)
	{
		boolean found = false;
		for(int i = 0; i < this.StrugglingClasses.size(); i++)
		{
			if(sClass.equals(this.StrugglingClasses.get(i)))
			{
				found = true;
				
			}
		}

		for(SchoolClass c:this.userCalendar.getStudentSchedule().getClasses())
		{
			if(sClass.equals(c))
			{
				StrugglingClasses.add(sClass);
				return true;
			}
		}
		
		if(found == false)
		{
			StrugglingClasses.add(sClass);
			return found;
		}
		else
		{
			return found;
		}
	}
	
	public ArrayList<SchoolClass> returnStruggle()
	{
		if(StrugglingClasses.isEmpty())
		{
			System.out.println("This Student is not currently Struggling");
			return StrugglingClasses;
		}
		else
		{
			System.out.println("This student is currently Struggling");
			return StrugglingClasses;
		}
	}
	
	/**
	 * rates a StudyGuide
	 * @param gender
	 * @param guide
	 * @param score
	 * @param reviewText
	 */
	
	public void rateGuide(StudyGuide guide, int score, String reviewText)
	{
		guide.addReview(new Review(this,(float)score, reviewText));
	}
	
	/**
	 * rates Tutor (by creating a TutorReview object + adding it to Tutor's review arrayList)
	 * @param placeholder
	 * @param review
	 * @param score
	 * @param re
	 */
	
	public void rateTutor(Tutor placeholder,String review, int score)
	{
		placeholder.addReview(new TutorReview(placeholder,this, score, review));
	}
	
	public void removeMyself()
	{
		userFactory.removeStudent(this);
	}

}
