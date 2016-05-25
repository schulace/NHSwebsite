package project.serverLogic;

import java.util.ArrayList;

import project.schedule.classes.StudentSchedule;
import project.studyGuide.StudyGuide;
import project.user.Administrator;
import project.user.Student;
import project.user.Teacher;
import project.user.Tutor;
import com.google.gson.Gson;

public class userFactory
{
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public static ArrayList<Tutor> tutorList = new ArrayList<Tutor>();
	public static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
	public static ArrayList<StudyGuide> profaneGuides = new ArrayList<StudyGuide>();
	public static ArrayList<Tutor> badBoyz = new ArrayList<Tutor>();
	public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	
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
	
	public static void attachStudentSchedule(String studentID, StudentSchedule sched)
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
	
	public static void addTutor(String studentID, int grade){
		Tutor toAdd = new Tutor(studentID, grade);
		boolean inList = false;
		for(Tutor tutor:tutorList)
		{
			if(tutor.getName().equals(toAdd.getName()))
			{
				inList = true;
				break;
			}
		}
		if(!inList)
		{
			tutorList.add(toAdd);
		}
	}
	
	public static void attachTutorSchedule(String studentID, StudentSchedule sched)
	{
		Tutor toAttachSched = null;
		for(Tutor st:tutorList)
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
	
	public void updateList()
	{
		for (int i = 0; i< profaneGuides.size(); i++)
		{
			badBoyz.set(i, profaneGuides.get(i).getAuthor());
		}
	}
	
	public static ArrayList<StudyGuide> getProfaneGuides()
	{
		return profaneGuides;
	}
	
	public void addProfaneGuide(StudyGuide s)
	{
		profaneGuides.add(s);
		updateList();
	}
	
	public void addAdminitrator(String name)
	{
		Administrator toAdd = new Administrator(name);
		boolean inList = false;
		for(Administrator admin:adminList)
		{
			if(admin.getName().equals(toAdd.getName()))
			{
				inList = true;
				break;
			}
		}
		if(!inList)
		{
			adminList.add(toAdd);
		}
	}
	
	public static void addTeacher(String teacher, String school)
	{
		Teacher toAdd = new Teacher(teacher, school);
		boolean inList = false;
		for(Teacher prof:teacherList)
		{
			if(prof.getName().equals(toAdd.getName()))
			{
				inList = true;
				break;
			}
		}
		if(!inList)
		{
			teacherList.add(toAdd);
		}
	}
}
