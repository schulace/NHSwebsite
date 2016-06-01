<%@page import="test_data.test_schedules"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="google-signin-client_id" content="546309547030-ahl9ebonp8vi7i2e2otlkiu95tmnpd3r.apps.googleusercontent.com">
<title>test</title>
</head>
<body>
	<p>
		hello world
		<%= test_schedules.getStudent1Schedule().toHTML()%>
	</p>
</body>
</html>