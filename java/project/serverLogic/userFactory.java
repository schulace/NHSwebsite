package project.serverLogic;

import java.util.ArrayList;

import project.schedule.classes.StudentSchedule;
import project.studyGuide.StudyGuide;
import project.user.Administrator;
import project.user.Student;
import project.user.Tutor;
import com.google.gson.Gson;

public class userFactory
{
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public static ArrayList<Tutor> tutorList = new ArrayList<Tutor>();
	public static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
	public static ArrayList<StudyGuide> profaneGuides = new ArrayList<StudyGuide>();
	public static ArrayList<Tutor> badBoyz = new ArrayList<Tutor>();
	
	public static void addStudent(String studentID, int grade)
	{
		Student toAdd = new Student(studentID, grade);
		boolean inList = false;
		for(Student student:studentList)
		{
			if(student.getName().equals(toAdd.getName()))
			{
				inList = true;
				break;
			}
		}
		if(!inList)
		{
			studentList.add(toAdd);
		}
	}
	
	public static void addStudent(String jsonIn)
	{
		Gson gs = new Gson();
		Student toAdd = gs.fromJson(jsonIn, Student.class);
		for(Student student:studentList)
		{
			if(!student.getName().equals(toAdd.getName()))
			{
				studentList.add(toAdd);
			}
		}
	}
	
	public void updateList()
	{
		for (int i = 0; i< profaneGuides.size(); i++)
		{
			badBoyz.set(i,(Tutor) profaneGuides.get(i).getAuthor());
		}
	}
	
	public static ArrayList<StudyGuide> getProfaneGuides()
	{
		return profaneGuides;
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
	
	public void addProfaneGuide(StudyGuide s)
	{
		profaneGuides.add(s);
	}
	
	
}
