package project.requests;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;
import project.schedule.classes.Subject;
import project.user.Student;

public class Request 
{
	private Student requestor;
	private Subject schoolSubject;
	private boolean isFilled;
	private ArrayList<int[]> availableBlocks;

	public Request(Student studentIn, Subject subject, boolean isFilled) 
	{
		requestor = studentIn;
		schoolSubject = subject;
		this.isFilled = isFilled;
		this.availableBlocks = studentIn.getOpens();
		
	}
	public ArrayList<int[]> getAvailableBlocks()
	{
		return this.availableBlocks;
	}

	public Student getStudentName()
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

	public boolean isFilled()
	{
		return isFilled;
	}

	public void setFilled(boolean isFilled) 
	{
		this.isFilled = isFilled;
	}
}
