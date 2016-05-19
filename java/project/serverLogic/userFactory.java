package project.serverLogic;

import java.util.ArrayList;

import project.schedule.classes.StudentSchedule;
import project.user.Student;
import project.user.Tutor;

public class userFactory
{
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public static ArrayList<Tutor> tutorList = new ArrayList<Tutor>();
	
	public static void addStudent(String studentID, int yearDob, int monthDob, int dayDob, int grade, String gender)
	{
		Student toAdd = new Student(studentID, monthDob, yearDob, dayDob, grade, gender);
		for(Student student:studentList)
		{
			if(!student.getName().equals(toAdd.getName()))
			{
				studentList.add(toAdd);
			}
		}
	}
	
	public static void attachSchedule(String studentID, StudentSchedule sched)
	{
		Student toAttachSched = null;
		for(Student st:studentList)
		{
			if(st.getName().equals(studentID))
			{
				toAttachSched = st;
			}
		}
		if(toAttachSched == null)
		{
			return;
		}
		
		toAttachSched.setSchedule(sched);
	}
}
