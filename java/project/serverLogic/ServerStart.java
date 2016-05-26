package project.serverLogic;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import project.requests.Request;
import project.schedule.calendar.GHSCalendar;
import project.user.Student;
import project.user.Tutor;
import test_data.testRequests;
import test_data.test_schedules;
import test_data.test_user;

public class ServerStart
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		testSchedule();
	}
	
	public static void testSchedule()
	{
		System.out.println(test_schedules.getStudent1Schedule());
	}
	
	public static void testMatching()
	{
		Tutor tut = test_user.newTut;
		Student st = test_user.Idontknow;
		Request req1 = testRequests.req;
		userFactory.addStudent(st);
		userFactory.addTutor(tut);
		requestManager.addRequest(req1);
		System.out.println(Arrays.deepToString(st.getOpens().toArray()));
		System.out.println(Arrays.deepToString(tut.getOpens().toArray()));
		System.out.println(requestManager.getRequestList());
		
	}
	
	public static String getTestJson()
	{
		ArrayList<GregorianCalendar> daysOff = Reference.setAndGetBreakDays();
		Student stu = new Student(test_schedules.getStudent1Schedule(), "test_student@greenwich.k12.ct.us", 10);
		Gson g = new Gson();
		String s = g.toJson(stu);
		return s;
	}
	
	public static void testJson() throws FileNotFoundException
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
	}
}
