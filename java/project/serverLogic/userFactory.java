package project.serverLogic;

import java.util.ArrayList;

import project.schedule.calendar.ScheduleHistory;
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
	public static ArrayList<ScheduleHistory> confirmationList = new ArrayList<ScheduleHistory>();
	
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
	
	//TODO only for testing. delete later
	public static void addStudent(Student stIn)
	{
		studentList.add(stIn);
	}
	//TODO only for testing. delete later
	public static void addTutor(Tutor tutIn)
	{
		tutorList.add(tutIn);
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
	
	public static void removeStudent (Student s)
	{
		Student toRemove = new Student(s.getName(), s.getGradeAsInt());
		boolean inList = false;
		for(Student student:studentList)
		{
			if(student.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < studentList.size(); i++)
				{
					if (student.getName().equals(toRemove.getName()))
					{
						inList = true;
						studentList.remove(i);
					}
				}
			}
		}
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
	
	public static void updateList()
	{
		for (int i = 0; i< profaneGuides.size(); i++)
		{
			badBoyz.set(i, (Tutor)profaneGuides.get(i).getAuthor());
		}
	}
	
	public static ArrayList<StudyGuide> getProfaneGuides()
	{
		return profaneGuides;
	}
	
	public static void addProfaneGuide(StudyGuide s)
	{
		profaneGuides.add(s);
		updateList();
	}
	
	public static void  removeTutor(Tutor t){
		Tutor toRemove = new Tutor(t.getName(), t.getGradeAsInt());
		boolean inList = false;
		for(Tutor teacher:tutorList)
		{
			if(t.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < tutorList.size(); i++)
				{
					if (t.getName().equals(toRemove.getName()))
					{
						inList = true;
						tutorList.remove(i);
					}
				}
			}
		}
	}
	
	public static void addAdminitrator(String name)
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
	
	public static void removeAdministrator(Administrator a )
	{
		Administrator toRemove = new Administrator(a.getName());
		boolean inList = false;
		for(Teacher teacher:teacherList)
		{
			if(a.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < adminList.size(); i++)
				{
					if (a.getName().equals(toRemove.getName()))
					{
						inList = true;
						adminList.remove(i);
					}
				}
			}
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
	
	public static void  removeTeacher (Teacher Meyers)
	{
		Teacher toRemove = new Teacher(Meyers.getName());
		boolean inList = false;
		for(Teacher teacher:teacherList)
		{
			if(Meyers.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < teacherList.size(); i++)
				{
					if (Meyers.getName().equals(toRemove.getName()))
					{
						inList = true;
						teacherList.remove(i);
					}
				}
			}
		}
	}
	
	public static boolean sessionConfirm (Tutor t, Student s)
	{
		if((t.confirmSession() && s.confirmSession()) == true)
		{
			return true;
		}
		else if (t.confirmSession() || s.confirmSession() == false)
		{
			return false;
		}
	}
}
