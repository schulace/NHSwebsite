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

<!--

Stylable signing button:

	  <div id="my-signin2"></div>
	  <script>
	    function onSuccess(googleUser) {
	      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
	    }
	    function onFailure(error) {
	      console.log(error);
	    }
	    function renderButton() {
	      gapi.signin2.render('my-signin2', {
	        'scope': 'profile email',
	        'width': 240,
	        'height': 50,
	        'longtitle': true,
	        'theme': 'dark',
	        'onsuccess': onSuccess,
	        'onfailure': onFailure
	      });
	    }
	  </script>
	
	  <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>



Getting user info example:

	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail());
	}


Sign out button:

	<a href="#" onclick="signOut();">Sign out</a>
	<script>
	  function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	  }
	</script>

-->