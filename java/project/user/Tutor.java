/**
 * 
 * @author george
 * object for Tutor
 *
 */

package project.user;

import java.util.ArrayList;

import project.requests.Request;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.serverLogic.requestManager;
import project.serverLogic.userFactory;
import project.studyGuide.StudyGuide;
import project.studyGuide.TutorReview;

public class Tutor extends User
{
	private ArrayList<SchoolClass> strongClasses = new ArrayList<SchoolClass>();
	

	private ArrayList<TutorReview> reviews;
	/**
	 * @deprecated
	 */
	private ArrayList<StudyGuide> Guides;
	private ArrayList<Request> possibilities = new ArrayList<Request>();
	
	/**
	 * calls super constructor
	 * @param name
	 * @param grade
	 */
	
	public Tutor(String name, int grade)
	{
		super(name, grade);
	}
	
	public Tutor(StudentSchedule sc, String name, int gr)
	{
		super(sc,name,gr);
	}
	
	public ArrayList<SchoolClass> getStrongClasses()
	{
		return strongClasses;
	}
	
	public void prepForJson()
	{
		userCalendar.cal = null;
		userCalendar.daysOff = null;
		userCalendar.endDate = null;
		userCalendar.startDate = null;
		possibilities = null;
	}

	public void setStrongClasses(ArrayList<SchoolClass> strongClasses)
	{
		this.strongClasses = strongClasses;
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
	 * @param re review of tutor.
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
	
	public void removeMyself()
	{
		userFactory.removeTutor(this);
	}
	
	public void addRequest(Request reqIn)
	{
		this.possibilities.add(reqIn);
	}
	
	public ArrayList<Request> getRequests()
	{
		return this.possibilities;
	}
	/**
	 * @param studentName name (email) of student to be tutored
	 * @param blocks blocks that the tutor chooses to teach the kid
	 * 
	 * how it works:
	 * the tutor will be able to see all requests matching them when they log in, and will be able to fill one of them. this will (hopefully) call fillRequest.
	 * then the site will pass it the name of the student who made the request, as well as a list of which block the tutor wants to do shit.
	 * this sets the request filled to true, and then runs update on requestManager
	 */
	public void fillRequest(String studentName, ArrayList<int[]> blocks) //TODO explain to marshall + josh how I think this is going to work
	{
		Request req = requestManager.getRequest(studentName);
		if(req != null)
		{
			req.setFilled(true);
			requestManager.update(blocks, this);
		}
	}
	
	/**
	 * 
	 * @param sub generates a new study guide
	 * @param comment
	 */
	
	public void submitGuide(project.schedule.classes.Subject sub, String comment)
	{
		Guides.add(new StudyGuide(this, sub, comment));
	}

}