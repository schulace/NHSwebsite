package test_data;

import java.util.ArrayList;

import project.schedule.classes.LetterDay;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Subject;
import project.user.Teacher;

public class test_schedules
{
	
	public static LetterDay[] days = {LetterDay.A, LetterDay.B, LetterDay.C, LetterDay.D, LetterDay.E, LetterDay.F, LetterDay.G, LetterDay.H};
	public static LetterDay[] days2 = {LetterDay.B, LetterDay.C, LetterDay.H};
	public static ArrayList<SchoolClass> classes = new ArrayList<SchoolClass>();
	public static SchoolClass a = new SchoolClass("honors biology", Subject.BIOLOGY,days, 6, new Teacher());
	public static SchoolClass b = new SchoolClass("honors english", Subject.ENGLISH, days, 5, new Teacher());
	public static SchoolClass c = new SchoolClass("honors geometry", Subject.MATH, days, 1, new Teacher());
	public static SchoolClass d = new SchoolClass("honors history", Subject.HISTORY, days, 2, new Teacher());
	public static SchoolClass e = new SchoolClass("honors spanish", Subject.SPANISH, days, 3, new Teacher());
	public static SchoolClass f = new SchoolClass("band", Subject.ELECTIVE, days, 4, new Teacher());
	public static SchoolClass g = new SchoolClass("Finance", Subject.MATH, days2, 7, new Teacher());
//	public static SchoolClass h = 
	public static StudentSchedule getStudent1Schedule()
	{
		classes = new ArrayList<SchoolClass>();
		classes.add(a);classes.add(b); classes.add(c); classes.add(d); classes.add(e); classes.add(f); classes.add(g);
		return new StudentSchedule(classes);
	}
	
	public static StudentSchedule getStudent2Schedule()
	{
		classes = new ArrayList<SchoolClass>();
		classes.add(a);classes.add(b); classes.add(c); classes.add(d); classes.add(e); classes.add(f);
		return new StudentSchedule(classes);
	}
}
