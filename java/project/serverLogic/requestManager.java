package project.serverLogic;

import java.util.ArrayList;
import project.requests.Request;
import project.requests.TutorPossibility;
import project.schedule.classes.LetterDay;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Subject;
import project.schedule.classes.TutoringSession;
import project.user.Teacher;
import project.user.Tutor;
import com.google.gson.Gson;


public class requestManager
{
	private static ArrayList<Request> requestList = new ArrayList<Request>();
	
	public static ArrayList<Request> getRequestList()
	{
		return requestList;
	}

	public static void addRequest(Request req)
	{
		for(Request inList:requestList)
		{
			if(inList.equals(req))
			{
				return;
			}
		}
		
		
		for(Tutor t:userFactory.tutorList)
		{
			TutorPossibility pos = new TutorPossibility(t, req.getRequestor());
			if(pos.commonBlocks.size() >= 3 && t.getStrongClasses().contains(req.getSubject())) //only considers the request as valid if they can meet at least 3 times per cycle.
			{
				req.addPossibleFill(pos);
				t.addRequest(req);
			}
		}
		if(req.getTutPossibilities().size() > 0)
		{
			requestList.add(req);
			return;
		}
		else
		{
			for(Tutor t:userFactory.tutorList)
			{
				TutorPossibility pos = new TutorPossibility(t, req.getRequestor());
				if(pos.commonBlocks.size() >= 3) //only considers the request as valid if they can meet at least 3 times per cycle.
				{
					req.addPossibleFill(pos);
					t.addRequest(req);
				}
			}
			requestList.add(req);
		}
	}
	
	public static Request getRequest(String name)
	{
		for(Request req: requestList)
		{
			if(req.getRequestor().getName().equals(name))
			{
				return req;
			}
		}
		return null;
	}
	
	public static void serializeRequestList()
	{
		Gson g = new Gson();
		for (Request req: requestList)
		{
			String w = g.toJson(req);
			Mongoconnect con = new Mongoconnect();
			con.insertToDb(w, "requestCollection");
		}
	}
	
	public static void deserializeRequestList()
	{
		Mongoconnect connection = new Mongoconnect();
		ArrayList<String> jsons = connection.getCollection("studentCollection");
		Gson g = new Gson();
		for(String j: jsons)
		{
			Request req = g.fromJson(j, Request.class);
			addRequest(req);
		}
	}	
	
	/**
	 * 
	 * @param blocks blocks the tutor would want to teach
	 * @param tutIn tutor who fills request
	 * 
	 * goes through requestList, finds the filled one (objects are how it can be filled b/c pointers).
	 * once it finds the filled one, it runs genClassesFromRequest in order to put tutoring sessions into the student and tutor schedule.
	 */
	public static void update(ArrayList<int[]> blocks, Tutor tutIn)
	{
		for(int x = 0; x < requestList.size(); x ++)
		{
			Request re = requestList.get(x);
			if(re.isFilled())
			{
				boolean b = GenClassesFromRequest(re, blocks, tutIn);
				if(b)
				{
					x --;
				}
			}
		}
	}
	/**
	 * 
	 * @param reqIn request
	 * @param blocks tutor's preferred blocks
	 * @param tutIn tutor filling request
	 * 
	 * if the amount of classes filled is < 3, then this doesn't do anything. it sets the request filled to false.
	 * if it can continue, it adds 3 classes to the tutor + student schedule and updates their calendars to reflect this.
	 */
	public static boolean GenClassesFromRequest(Request reqIn, ArrayList<int[]> blocks, Tutor tutIn)
	{
		if(blocks.size() < 3)
		{
			reqIn.setFilled(false);
			return false;
		}
		for(int x = 0; x < 3; x ++)
		{
			TutoringSession c1 = new TutoringSession("Tutoring session for " + reqIn.getRequestor().getName(), genLetterDayFromArray(blocks.get(x)), getBlockFromArray(blocks.get(x)), new Teacher(tutIn.getName()));
			reqIn.getRequestor().getCalendar().getStudentSchedule().addClass(c1);
			tutIn.getCalendar().getStudentSchedule().addClass(c1);
			tutIn.getCalendar().refreshCalendar();
			reqIn.getRequestor().getCalendar().refreshCalendar();
		}
		requestList.remove(requestList.indexOf(reqIn));
		return true;
	}
	
	public static LetterDay[] genLetterDayFromArray(int[] arrIn)
	{
		LetterDay d = LetterDay.A;
		d = d.getDayFromInt(arrIn[0]);
		LetterDay[] toReturn = {d};
		return toReturn;
	}
	public static int getBlockFromArray(int[] arrIn)
	{
		return StudentSchedule.blocks[arrIn[0]][arrIn[1]];
	}
	//Creates a JSON of the requestList and returns it 		
	
	public static String toJSON()
	{
		Gson g = new Gson();
		String s = g.toJson(getRequestList());
		System.out.println(s);
		return s;
	}
	
	public static String getGoogleSignInAuth()
	{
		return "<div class=\"g-signin2\" data-onsuccess=\"onSignIn\" style=\"transform: rotate(3deg); position: absolute; margin-left: auto ; margin-right: auto ;\"></div>";
	}
	
}
