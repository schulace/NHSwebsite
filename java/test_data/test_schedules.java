package test_data;

import java.util.ArrayList;

import project.schedule.classes.LetterDay;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Subject;

public class test_schedules
{
	
	public static LetterDay[] days = {LetterDay.A, LetterDay.B, LetterDay.C, LetterDay.E, LetterDay.F, LetterDay.G};
	public static ArrayList<SchoolClass> classes = new ArrayList<SchoolClass>();
	public static SchoolClass a = new SchoolClass("honors biology", Subject.BIOLOGY,days, 6);
	public static SchoolClass b = new SchoolClass("honors english", Subject.ENGLISH, days, 5);
	public static StudentSchedule getStudent1Schedule()
	{
		classes.add(a);classes.add(b);
		return new StudentSchedule(classes);
	}
}
