<%@page import="project.schedule.classes.StudentSchedule"%>
<%@page import="project.requests.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.serverLogic.requestManager"%>
<%@page import="project.serverLogic.userFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
public String genSchedule(ArrayList<int[]> blocks, int order)
{
	String toReturn = "<table><thead><tr> <th>*</th>  <th>A</th><th>B</th><th>C</th><th>D</th><th>E</th><th>F</th><th>G</th><th>H</th></tr></thead><tbody>";
	for(int x = 0; x < 6; x ++)
	{
		toReturn += "<tr><td>block: " + (x+1) + "</td>";
		for(int y = 0; y < 8; y ++)
		{
			if(isBlockInArrayList(y, x, blocks))
			{
				toReturn += "<td>block:" + StudentSchedule.blocks[y][x] + "<input type=\"checkbox\" name=\"" + order + y + x + "\" value=\"false\"></td>"; //3 digits to determine which class they're filling for, which day, and which block.
			}
			else
			{
				toReturn += "<td>block:" + StudentSchedule.blocks[y][x] + "</td>";
			}
		}
		toReturn += "</tr>";
	}
	
	return toReturn;
}

public boolean isBlockInArrayList(int day, int block, ArrayList<int[]> blocks)
{
	for(int[] a:blocks)
	{
		if(a[0] == day && a[1] == block)
		{
			return true;
		}
	}
	return false;
}

%>
<%
//focus. here, we fill requests. need to grab request list, figure out what requests have a possibility for this dude, allow the dude to pick when, then fill it, generate a class
String email = null;
String formTables = "";
Cookie[] cookies = request.getCookies();
if(cookies != null)
{
	for (Cookie cookie : cookies)
	{
        if (cookie.getName().equals("NHSLoginEmail"))
        {
        	email = cookie.getValue();
        }
    }
}
if(email != null);
{
	//puts DB objects into memory
	userFactory.deserializeStudentList(false);
	userFactory.deserializeTutorList(false);
	requestManager.deserializeRequestList();
	
	ArrayList<Request> possibilities = requestManager.getRequestPosForTutor(email);
	for(int x = 0; x < possibilities.size(); x ++)
	{
		formTables += genSchedule(possibilities.get(x).getAvailableBlocks(), x);
	}
	
	userFactory.serializeStudentList();
	userFactory.serializeTutorList();
	requestManager.serializeRequestList();
	
	
}


%>

<form>
	<%=formTables%>

</form>


</body>
</html>