<%@page import="project.schedule.classes.SchoolClass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.schedule.classes.Subject"%>
<%@page import="project.user.*"%>
<%@page import="project.serverLogic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>select the area that you need the most help in</p>
	<form method="post" action="../../../helpRequest">
		<select name="subject">
		<%
		String formOut = "";
		String HRemail = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for (Cookie cookie : cookies)
			{
                if (cookie.getName().equals("NHSLoginEmail"))
                {
                	HRemail = cookie.getValue();
                }
            }
        }
		else
		{
			System.out.println("no cookies were found");
		}
		if(HRemail != null)
		{
			Student stu = null;
			userFactory.deserializeStudentList(false);
			for(Student st:userFactory.studentList)
			{
				if(st.getName().equals(HRemail))
				{
					stu = st;
					break;
				}
			}
			if(stu != null)
			{
				ArrayList<Subject> subjs = new ArrayList<Subject>();
				for(SchoolClass sClass : stu.getSchedule().getClasses())
				{
					subjs.add(sClass.getSubject());
				}
				if(subjs.size() > 0)
				{
					for(Subject s:subjs)
					{
						formOut += "<option value=\"" + s + "\">" + s.toString().toLowerCase() + "</option>";
					}
				}
			}
		}
		%>
		<%=formOut%>
		
	</select>
	<input type="submit" value="submit help request">
	</form>
</body>
</html>