package webJava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.requests.Request;
import project.schedule.classes.Subject;
import project.serverLogic.requestManager;
import project.serverLogic.userFactory;
import project.user.Student;

/**
 * Servlet implementation class helpRequest
 */
@WebServlet("/helpRequest")
public class helpRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helpRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Subject s = Subject.valueOf(request.getParameter("subject"));
		userFactory.deserializeStudentList(false);
		userFactory.deserializeTutorList(false); //TODO george make sure this thing works OK
		requestManager.deserializeRequestList();
		String HRscriptletemail = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for (Cookie cookie : cookies)
			{
                if (cookie.getName().equals("NHSLoginEmail"))
                {
                	HRscriptletemail = cookie.getValue();
                }
            }
        }
		else
		{
			System.out.println("no cookies were found");
		}
		Student stu = null;
		try
		{
			stu = userFactory.getStudentByName(HRscriptletemail);
		}
		catch(Exception e)
		{
			
		}
		if(stu != null)
		{
			project.requests.Request req = new Request(stu, s, false);
			requestManager.addRequest(req);
		}
		userFactory.serializeStudentList();
		userFactory.serializeTutorList();
		requestManager.serializeRequestList();
		
		
	}

}
