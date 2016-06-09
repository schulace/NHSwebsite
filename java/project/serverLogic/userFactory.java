package project.serverLogic;

import java.util.ArrayList;

import project.requests.Request;
import project.schedule.calendar.GHSCalendarDay;
import project.schedule.calendar.TutoringHistory;
import project.schedule.classes.StudentSchedule;
import project.studyGuide.StudyGuide;
import project.user.Administrator;
import project.user.Student;
import project.user.Teacher;
import project.user.Tutor;
import com.google.gson.Gson;

/**
 * 
 * @author schulace
 * note: deserialize this before requests.
 */
public class userFactory
{
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public static ArrayList<Tutor> tutorList = new ArrayList<Tutor>();
	public static ArrayList<Administrator> adminList = new ArrayList<Administrator>();
	public static ArrayList<StudyGuide> profaneGuides = new ArrayList<StudyGuide>();
	public static ArrayList<Tutor> badBoyz = new ArrayList<Tutor>();
	public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	public static ArrayList<TutoringHistory> confirmationList = new ArrayList<TutoringHistory>();
	
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
	
	public static Student getStudentByName(String email)
	{
		for(Student s:studentList)
		{
			if(s.getName().equals(email))
			{
				return s;
			}
		}
		return null;
	}
	
	public static void serializeStudentList()
	{
		Gson g = new Gson();
		Mongoconnect con = new Mongoconnect();
		for (Student s: studentList)
		{
			s.prepForJson();
			String w = g.toJson(s);
			System.out.println(w);
			con.deleteDocument("students", "name", s.getName());
			con.insertToDb(w,"students"); //TODO add the string back
		}
		studentList = new ArrayList<Student>();
		con.close();
	}
	
	public static void deserializeStudentList(boolean thorough)
	{
		Mongoconnect connection = new Mongoconnect();
		ArrayList<String> jsons = connection.getCollection("students");
		Gson g = new Gson();
		for(String fuzzyStudent: jsons)
		{
			Student stu = g.fromJson(fuzzyStudent, Student.class);
			if(thorough)
			{
				refreshCalendars();
			}
			addStudent(stu);
		}
		connection.close();
	}
	
	public static void refreshCalendars()
	{
		for(Student stu:studentList)
		{
			stu.getCalendar().setStartDate(Reference.startDate);
			stu.getCalendar().setEndDate(Reference.endDate);
			stu.getCalendar().setDaysOff(Reference.setAndGetBreakDays());
			stu.getCalendar().refreshCalendar();
		}
		
		for(Tutor tut:tutorList)
		{
			tut.getCalendar().setStartDate(Reference.startDate);
			tut.getCalendar().setEndDate(Reference.endDate);
			tut.getCalendar().setDaysOff(Reference.setAndGetBreakDays());
			tut.getCalendar().refreshCalendar();
		}
	}
	
	public static void serializeTutorList()
	{
		Gson g = new Gson();
		for(Tutor t: tutorList)
		{
			t.prepForJson();
			String s = g.toJson(t);
			Mongoconnect con = new Mongoconnect();
			con.insertToDb(s, "tutors");
		}
		tutorList = new ArrayList<Tutor>();
	}
	
	public static void deserializeTutorList() //TODO requests for tutors + setting that up properly.
	{
		Mongoconnect connection = new Mongoconnect();
		ArrayList<String> jsons = connection.getCollection("studentCollection");
		Gson g = new Gson();
		for(String s:jsons)
		{
			Tutor t = g.fromJson(s, Tutor.class);
			t.getCalendar().daysOff = Reference.setAndGetBreakDays();
			t.getCalendar().endDate = Reference.endDate;
			t.getCalendar().startDate = Reference.startDate;
			t.getCalendar().refreshCalendar();
		}
	}
	
	@Deprecated
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

	public static void addStudent(Student stIn)
	{
		for(int x = 0; x < studentList.size(); x ++)
		{
			if(studentList.get(x).getName().equals(stIn.getName()))
			{
				studentList.remove(x);
			}
		}
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
		for(Student student:studentList)
		{
			if(student.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < studentList.size(); i++)
				{
					if (student.getName().equals(toRemove.getName()))
					{
						studentList.remove(i);
					}
				}
			}
		}
	}
	
	public static void addTutor(String studentID, int grade)
	{
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
	
	public static void  removeTutor(Tutor t) //TODO george wtf is this
	{
		Tutor toRemove = new Tutor(t.getName(), t.getGradeAsInt());
		for(Tutor teacher:tutorList)
		{
			if(t.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < tutorList.size(); i++)
				{
					if (t.getName().equals(toRemove.getName()))
					{
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
	
	public static void removeAdministrator(Administrator a ) //TODO george wat did you doooooooooooo
	{
		Administrator toRemove = new Administrator(a.getName());
		for(Teacher teacher:teacherList)
		{
			if(a.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < adminList.size(); i++)
				{
					if (a.getName().equals(toRemove.getName()))
					{
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
	
	public static void  removeTeacher (Teacher Meyers) //TODO george wat
	{
		Teacher toRemove = new Teacher(Meyers.getName());
		for(Teacher teacher:teacherList)
		{
			if(Meyers.getName().equals(toRemove.getName()))
			{
				for (int i = 0; i < teacherList.size(); i++)
				{
					if (Meyers.getName().equals(toRemove.getName()))
					{
						teacherList.remove(i);
					}
				}
			}
		}
	}
	
	public static boolean sessionConfirm(Tutor t, Student s)
	{
		if((t.confirmSession() && s.confirmSession()) == true)
		{
			return true;
		}
		return false;
	}
}
