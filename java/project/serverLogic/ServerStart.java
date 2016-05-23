package project.serverLogic;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import project.schedule.calendar.GHSCalendar;
import project.user.Student;
import test_data.test_schedules;

public class ServerStart
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<GregorianCalendar> daysOff = Reference.setAndGetBreakDays();
		Student stu = new Student(test_schedules.getStudent1Schedule(), "test_student@greenwich.k12.ct.us", 10);
		Gson g = new Gson();
		String s = g.toJson(stu);
		System.out.println(s);
		PrintWriter p = new PrintWriter("C:\\\\test\\studentTest.json");
		p.println(s);
		p.close();
		
		Student readStu = g.fromJson(s, Student.class);
		System.out.println(readStu.getCalendar());
//		testing out schedule printing.
//		System.out.println(test_schedules.getStudent1Schedule());
	}
}
