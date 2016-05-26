package project.schedule.calendar;

import java.util.ArrayList;

import project.schedule.classes.LetterDay;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.serverLogic.userFactory;
import project.user.Student;
import project.user.Tutor;

public class ScheduleHistory
{
	private boolean match = false;
	private Student student;
	private Tutor tutor;
	private StudentSchedule stuShedule;
	private StudentSchedule tutShedule;
	public ArrayList<SchoolClass> cal = new ArrayList<SchoolClass>();
	public ArrayList<LetterDay> letterDays = new ArrayList<LetterDay>();
	
	public ScheduleHistory(Student s, Tutor t, StudentSchedule studentSchedule, StudentSchedule tutorSchedule)
	{
		student = s;
		tutor = t;
		stuShedule = studentSchedule;
		tutShedule = tutorSchedule;
		SchoolClass[][] StudentblockSchedule = studentSchedule.getBlockSchedule();
		SchoolClass[][] TutorblockSchedule = tutorSchedule.getBlockSchedule();
		
		for (int i = 0; i < StudentblockSchedule.length; i++)
		{
			for (int g = 0; i < StudentblockSchedule[i].length; g++)
			{
				if (StudentblockSchedule[i][g] && TutorblockSchedule[i][g] == XXXXXXXXX)//TODO when alex finishes tutoring session class, check for it here  
				{
					if (userFactory.sessionConfirm(t, s) == true)
					{
						match = true;
					}
					else 
					{
						match = false;
					}
					
					if (didThisHappen() == true)
					{
						cal.add(StudentblockSchedule[i][g]);
						
					}
				}
			}
		}
	}
	
	private boolean didThisHappen()
	{
		return match;
	}
}
