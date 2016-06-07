package webJava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.serverLogic.userFactory;
import project.user.Student;

/**
 * Servlet implementation class loginDirect
 */
@WebServlet("/loginDirect")
public class loginDirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginDirect() {
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
		String userEmail = request.getParameter("email");
		Cookie c = new Cookie("NHSLoginEmail", request.getParameter("email"));
		c.setMaxAge(-1);
		response.addCookie(c);
		
		
//		boolean cookieAlreadyAttached = false;
//		String userEmail = "";
//		for(Cookie c: request.getCookies())
//		{
//			if(c.getName().equals("NHSLoginEmail"));
//			{
//				cookieAlreadyAttached = true;
//				userEmail = c.getValue();
//				break;
//			}
//			
//		}
//		if(!cookieAlreadyAttached)
//		{
//			Cookie c = new Cookie("NHSLoginEmail", request.getParameter("email"));
//			c.setMaxAge(30);
//			response.addCookie(c);
//			System.out.println("attached a cookie");
//			userEmail = request.getParameter("email");
//		}
		boolean userInDB = false;
		userFactory.deserializeStudentList(false);
		for(Student st:userFactory.studentList)
		{
			if(st.getName().equals(userEmail))
			{
				userInDB = true;
				break;
			}
		}
		if(!userInDB) //user doesn't exist
		{
			response.sendRedirect("userInfoEntry.jsp");
		}
		else
		{
			response.sendRedirect("AltJavaPage/startbootstrap-sb-admin-2-1.0.8/pages/HomePage.jsp");
		}
	}

}
