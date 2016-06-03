package webJava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.schedule.classes.StudentSchedule;
import test_data.test_schedules;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main()
    {
        super();
        // 
    }
    
    @Override
    public void init() throws ServletException
    {
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 
		PrintWriter page = response.getWriter();
		
		page.append(test_schedules.getStudent1Schedule().toHTML());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		System.out.println(email);
		response.sendRedirect("NewFile.html");
	}

}
