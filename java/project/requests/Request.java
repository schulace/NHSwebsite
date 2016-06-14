package project.requests;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;
import project.schedule.classes.Subject;
import project.user.Student;

/**
 * 
 * @author schulace
 * representative of a request for help by a student in a particular subject.
 * contains the student who requested it, the subject, and which blocks are available.
 * also now contains a list of tutorPosibilities from which a tutor will be selected eventually and the request
 * can be moved elsewhere and a tutoring session class can be added to the student and tutor schedules.
 */


public class Request 
{
	private Student requestor;
	private Subject schoolSubject;
	private boolean isFilled;
	private ArrayList<TutorPossibility> tutPossibilities = new ArrayList<TutorPossibility>();

	/**
	 * 
	 * @param studentIn requestor
	 * @param subject of enum subject.
	 * @param isFilled whether or not the request has been filled (usually going to be false)
	 */
	public Request(Student studentIn, Subject subject, boolean isFilled) 
	{
		requestor = studentIn;
		schoolSubject = subject;
		this.isFilled = isFilled;
		
	}
	
	public ArrayList<int[]> getCommonBlocks(String tutorName)
	{
		for(TutorPossibility tutPos:tutPossibilities)
		{
			if(tutPos.tut.getName().equals(tutorName))
			{
				return tutPos.commonBlocks;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param pos a tutorPosibility
	 * adds a possibility(which contains the blocks a tutoring session could happen + the tutor) to the request.
	 */
	public void addPossibleFill(TutorPossibility pos)
	{
		if(!tutPossibilities.contains(pos))
		{
			tutPossibilities.add(pos);
		}
	}
	
	public ArrayList<int[]> getAvailableBlocks()
	{
		return this.requestor.getOpens();
	}

	public Student getRequestor()
	{
		return requestor;
	}

	public Subject getSubject() 
	{
		return schoolSubject;
	}

	public void setSubject(SchoolClass classIn) 
	{
		schoolSubject = classIn.getSubject();
	}
	
	public void setSubject(Subject subjIn)
	{
		schoolSubject = subjIn;
	}

	public boolean isFilled()
	{
		return isFilled;
	}

	public void setFilled(boolean isFilled) 
	{
		this.isFilled = isFilled;
	}

	public ArrayList<TutorPossibility> getTutPossibilities()
	{
		return tutPossibilities;
	}

	@Override
	public String toString() {
		return "Request [requestor=" + requestor.toStringMinusSchedule() + ", schoolSubject=" + schoolSubject + ", isFilled=" + isFilled + ", tutPosibilities=" + tutPossibilities + "]";
	}
	
	
}
