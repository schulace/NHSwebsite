package project.schedule.classes;

import java.util.ArrayList;

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
		SchoolClass[][] sched = studentName.getSchedule().getBlockSchedule();
		for(int i = 0; i< 8; i++)
		{
			for (int z = 0; z < 6; z++)
			{
				if(sched[i][z] == null)
				{
					int[] temp = {i,z};
					availableBlocks.add(temp);
				}
			}
		}
		
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
