package project.schedule.classes;

import java.util.ArrayList;

import project.user.Student;

public class Request 
{
	private Student StudentName;
	private SchoolClass Subject;
	private boolean isFilled;
	private ArrayList<Integer> availableBlocksx;
	private ArrayList<Integer> availableBlocksy;

	public Request(Student studentName, SchoolClass subject, boolean isFilled) 
	{
		StudentName = studentName;
		Subject = subject;
		this.isFilled = isFilled;
		SchoolClass[][] sched = studentName.getSchedule().getBlockSchedule();
		for(int i = 0; i< 6; i++)
		{
			for (int z = 0; z < 8; z++)
			{
				if(sched[i][z] == null)
				{
					availableBlocksx.add(i); //TODO Find a way to store the position of 'null' in a students schedule
					availableBlocksy.add(z);
				}
			}
		}
		
	}

	public Student getStudentName()
	{
		return StudentName;
	}

	public SchoolClass getSubject() 
	{
		return Subject;
	}

	public void setSubject(SchoolClass subject) 
	{
		Subject = subject;
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
