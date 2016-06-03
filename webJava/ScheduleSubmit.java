package webJava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.schedule.classes.LetterDay;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Subject;
import project.user.Teacher;

/**
 * Servlet implementation class ScheduleSubmit
 */
@WebServlet("/ScheduleSubmit")
public class ScheduleSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleSubmit() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Map<String, String[]> m = request.getParameterMap(); //for which blocks of they day we have
		ArrayList<SchoolClass> classes = new ArrayList<SchoolClass>(); //eventually passed into a schedule constructor
		boolean match = false; //used for error checking
		for(int x = 1; x <= getNumberOfClasses(request); x ++)
		{
			String s = Integer.toString(x);
			String[] ar = m.get(s); //gets a string array of numbers representing which days of the schedule the class meets
			if (ar == null) //error checking for people not checking any days for their classes
			{
				//TODO use AJAX to push a pop-up warning to the user
			}
			
			else if(ar != null) //errors if not this (deals with retards not checking any days.
			{
				LetterDay[] days = new LetterDay[ar.length]; //new letterday array of same size as number of boxes ticked for the class.
				for(int y = 0; y < ar.length; y ++)
				{
					LetterDay d2 = LetterDay.A;
					d2 = d2.getDayFromInt(Integer.parseInt(ar[y])); //takes the string number of the block, parses it to an integer, then gets a letterday from it + puts it in the day array.
					days[y] = d2;
				}
				//i swear the below line works. it just parses the stuff that's not hard.
				SchoolClass c = new SchoolClass(request.getParameter("className" + x), Subject.valueOf(request.getParameter("subject" + x)), days, Integer.parseInt(request.getParameter("block" + x)), new Teacher(request.getParameter("teacher" + x)));
				//checks to see if the school class has already been checked more than once
				
				for (int i = 0; i < classes.size(); i++)
				{
					if (classes.get(i).getName().equals(c.getName()))
					{
						match = true;
						theyDoneFuckedUp(request, response, "2 classes with the same name");
					}
					else if (isArrayInOtherArray(classes.get(i).getDays(), c.getDays()) && ((classes.get(i).getBlock()) == c.getBlock()))  
					{
						match = true;
						theyDoneFuckedUp(request, response, "2 classes scheduled in the same block");
					}
					else if ((classes.get(i).getSubject() == c.getSubject()) && ((classes.get(i).getName().equals(c.getName()))))
					{
						match = true;
						theyDoneFuckedUp(request, response, "2 classes with the same subject + name"); //may not be needed to check (since people can take multiple english classes, etc) but I figured that we may aswell check for it
					}
					else
					{
						match = false;
					}
				}
				
				if (!match)
				{
					classes.add(c); //adds the class generated above to an array.
				}
			}
		}
		if(!match)
		{
			StudentSchedule sched = new StudentSchedule(classes); //creates a student schedule.
			System.out.println("\n"+sched);
			response.getWriter().append(sched.toPrettierHTML());
		}
	}
	
	private boolean isArrayInOtherArray(LetterDay[] a, LetterDay[] b)
	{
		for(LetterDay dA: a)
		{
			for(LetterDay dB : b)
			{
				if(dA == dB)
				{
					return true;
				}
			}
		}
		return false;
	}
	//redirects them to the userInfoEntry if they fucked up
	private void theyDoneFuckedUp (HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException 
	{
		System.err.println("Error: " + message);
		String redirectURL = "userInfoEntry.jsp"; //TODO change this once we have a domian name for the website
		response.sendRedirect(redirectURL);
	}
	private int getNumberOfClasses(HttpServletRequest request)
	{
		Enumeration<String> stuff = request.getParameterNames();
		ArrayList<String> stList = new ArrayList<String>();
		while(stuff.hasMoreElements())
		{
			stList.add(stuff.nextElement());
		}
		return (stList.size()-2)/4;	
	}
}
