<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getCookies() != null)
 for(Cookie c:request.getCookies())
{
	c.setMaxAge(0);
	System.out.println("deleted a cookie?");
}
	
	%>
<form action="../../../loginDirect" method="post">
email: <input type="text" name="email">
<input type="submit" value="enter">
</form>
</body>
</html>