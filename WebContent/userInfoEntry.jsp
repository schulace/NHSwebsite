<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
var i = 0;
var subjList = ["BIOLOGY", "CHEMISTRY", "PHYSICS", "ENGLISH", "HISTORY", "SPANISH", "FRENCH", "ITALIAN", "GERMAN", "LATIN", "CHINESE", "MATH", "PROGRAMMING", "ELECTIVE", "OTHER"];
var letters = ["a", "b", "c", "d", "e", "f", "g", "h"];

function removeElem(parentDiv, childDiv)
{
	if (childDiv == parentDiv)
	{
		alert("The parent div cannot be removed.");
	}
	else if (document.getElementById(childDiv))
	{
		var child = document.getElementById(childDiv);
		var parent = document.getElementById(parentDiv);
		parent.removeChild(child);
		var child = document.getElementById(childDiv);
		var parent = document.getElementById(parentDiv);
		parent.removeChild(child);
	}
	else
	{
		alert("Child div has already been removed or does not exist.");
		return false;
	}
}

function classFunction()
{
	var r = document.createElement('span');
	var className = document.createElement("INPUT");
	className.setAttribute("type", "text");
	className.setAttribute("placeholder", "class name");
	var subj = document.createElement("select");
	for(var x = 0; x < subjList.length; x ++)
	{
		var z = document.createElement("option");
		z.setAttribute("value", subjList[x]);
		textint = document.createTextNode(subjList[x])
		z.appendChild(textint);
		subj.appendChild(z);
	}
	
	var block = document.createElement("select");
	for(var x = 1; x <=8; x ++)
	{
		var z = document.createElement("option");
		z.setAttribute("value", x);
		var textint = document.createTextNode(x)
		z.appendChild(textint);
		block.appendChild(z);
	}
	
	var teacherName = document.createElement("INPUT");
	teacherName.setAttribute("type", "text");
	teacherName.setAttribute("placeholder", "Teacher Name");

	i ++;
	
	var deletebutton = document.createElement("img");
	deletebutton.setAttribute("src", "https://s-media-cache-ak0.pinimg.com/30x30/60/cb/a7/60cba772a1da77d743dd6b59b7cc5161.jpg");
	deletebutton.setAttribute("onclick", "removeElem('formClasses','id_" + i + "')");
	className.setAttribute("Name", "className" + i);
	subj.setAttribute("name", "subject" + i);
	block.setAttribute("name", "block" + i);
	teacherName.setAttribute("name", "teacherName" + i);
	r.appendChild(className);
	r.appendChild(subj);
	r.appendChild(block);
	r.appendChild(teacherName);
	for(var x = 0; x < 8; x ++)
	{
		var letterday = document.createElement("INPUT");
		letterday.setAttribute("type", "checkbox");
		letterday.setAttribute("name", i);
		letterday.setAttribute("value", x);
		var textint = document.createTextNode(letters[x]);
		var br = document.createElement("br");
		r.appendChild(br);
		r.appendChild(letterday);
		r.appendChild(textint);
	}
	r.appendChild(deletebutton);
	r.setAttribute("id", "id_" + i);
	document.getElementById("formClasses").appendChild(r);
	var br = document.createElement('br')
	br.setAttribute("id", "id_" + i);
	document.getElementById("formClasses").appendChild(br);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<button onclick="classFunction()">add class</button> <!--black magic javascript function to generate form fields to input classes. it works.-->
<form action="ScheduleSubmit" method="post">
	<%
		String email = "";
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
		else
		{
			System.out.println("no cookies were found");
		}
		
	%>
	email: <input type="text" name="email" value=<%=email %>></input><br>
	year:
	<select name="year">
		<option value="9">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
	</select>
	
	<fieldset id="formClasses">
	
		
	
	</fieldset>
	<input type="submit" value="hello?">
	
</form>

</body>
</html>