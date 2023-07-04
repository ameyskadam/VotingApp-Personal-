<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voting Status</title>
<style>
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  
</style>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, return-login");

%>
<form>
<%String votedFor = (String)request.getAttribute("votedFor"); %> <!-- scriptlet that retrieves the value of the votedFor attribute from the request object -->
<h2>You have voted for <%= votedFor %></h2>
 
<br/>
<button style="background-color: red;  textcolor: white;"><nav><a href="/logout">Log Out</a></nav></button>
</form>
</body>
</html>