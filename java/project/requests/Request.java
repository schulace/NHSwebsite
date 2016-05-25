package project.requests;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;
import project.schedule.classes.Subject;
import project.user.Student;

public class Request 
{
	private Student StudentName;
	private Subject schoolSubject;
	private boolean isFilled;
	private ArrayList<int[]> availableBlocks;

	public Request(Student studentName, Subject subject, boolean isFilled) 
	{
		StudentName = studentName;
		schoolSubject = subject;
		this.isFilled = isFilled;
		this.availableBlocks = studentName.getOpens();
		
	}
	public ArrayList<int[]> getAvailableBlocks()
	{
		return this.availableBlocks;
	}

	public Student getStudentName()
	{
		return StudentName;
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
