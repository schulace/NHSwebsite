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
				theyDoneFuckedUp(request, response);
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
					if (classes.get(i) == c)
					{
						match = true;
					}
					else if (classes.get(i).getName() == c.getName())
					{
						match = true;
					}
					else if ((classes.get(i).getDays() == c.getDays()) && ((classes.get(i).getBlock()) == c.getBlock()))  
					{
						match = true;
					}
					else
					{
						match = false;
					}
				}
				
				if (match = true) //if they enter two of the same classes
				{
					theyDoneFuckedUp(request, response);
				}
				else
				{
					classes.add(c); //adds the class generated above to an array.
				}
			}
		}
		StudentSchedule sched = new StudentSchedule(classes); //creates a student schedule.
		System.out.println("\n"+sched);
		response.getWriter().append(sched.toPrettierHTML());
	}
	//redirects them to the userInfoEntry if they fucked up
	private void theyDoneFuckedUp (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("It seems like you have entered your shedule information incorrectly, please re-input your student shedule, you will be redirected shortly....");
			try 
			{
			    Thread.sleep(3000);                 //1000 milliseconds is one second, i'd say that 3 sec is a good time for the users to read the error message
			} catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			String redirectURL = "http://localhost:8080/nhsWeb/userInfoEntry.jsp"; //TODO change this once we have a domian name for the website
		    response.sendRedirect(redirectURL);
		    return;
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
