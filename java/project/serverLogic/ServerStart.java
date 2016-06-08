package project.serverLogic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;
import project.requests.Request;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.TutoringSession;
import project.user.Student;
import project.user.Tutor;
import test_data.testRequests;
import test_data.test_schedules;
import test_data.test_user;


public class ServerStart
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
	}
	
	public static void testSerialization() //TODO i need josh's DB methods to work for this to do anything.
	{
		Student st = test_user.Idontknow;
		Tutor t = test_user.newTut;
		Request r = testRequests.req;
		requestManager.addRequest(r);
		userFactory.serializeStudentList();
		userFactory.serializeTutorList();
		requestManager.serializeRequestList();
		userFactory.deserializeStudentList(false);
		userFactory.deserializeTutorList();
		requestManager.deserializeRequestList();
		int[][] wantedBlocksArray = {{1,5},{2,4},{3,4}};
		ArrayList<int[]> wantedBlocks = new ArrayList<int[]>();
		Collections.addAll(wantedBlocks, wantedBlocksArray);
		System.out.println(requestManager.getRequestList());
		t.fillRequest(st.getName(),wantedBlocks);
		System.out.println(requestManager.getRequestList());
		System.out.println(t.getCalendar());
	}
	
	public static void testSchedule()
	{
		System.out.println(test_schedules.getStudent1Schedule());
	}
	
	public static void objTest()
	{
		SchoolClass x = test_schedules.a;
		System.out.println(((TutoringSession)x).happened);
	}
	
	public static void testMatching()
	{
		Tutor tut = test_user.newTut;
		Student st = test_user.Idontknow;
		Request req1 = testRequests.req;
		userFactory.addStudent(st);
		userFactory.addTutor(tut);
		requestManager.addRequest(req1);
		int[][] wantedBlocksArray = {{1,5},{2,4},{3,4}};
		ArrayList<int[]> wantedBlocks = new ArrayList<int[]>();
		Collections.addAll(wantedBlocks, wantedBlocksArray);
		System.out.println(requestManager.getRequestList());
		tut.fillRequest(st.getName(),wantedBlocks);
		System.out.println(requestManager.getRequestList());
		System.out.println(tut.getCalendar());
		
	}
	
	public static String getTestJson()
	{
		Reference.setAndGetBreakDays();
		Student stu = new Student(test_schedules.getStudent1Schedule(), "test_student@greenwich.k12.ct.us", 10);
		Gson g = new Gson();
		String s = g.toJson(stu);
		return s;
	}
	
	public static void testJson() throws FileNotFoundException
	{
		Reference.setAndGetBreakDays();
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
