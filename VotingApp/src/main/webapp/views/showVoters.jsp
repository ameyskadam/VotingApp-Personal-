<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@page import="com.VotingApp.entitydto.UsersDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Voters</title>
</head>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, return-login");
%>
<nav><a href="logout">Log Out</a></nav>
<div
      class="h-100 d-flex align-items-center justify-content-center"
    >
<table style="width:fit-content;text-align: center;">
  <tr>
    <td>Voted By</td>
  </tr>
  
<% List<UsersDTO> list = (List<UsersDTO>)request.getAttribute("list");
for(UsersDTO objUser : list) //Traversing
{
%>
  <tr>
    <td><%=objUser.getUserName() %></td> <!-- generates rows that contains username retrived using method of the UsersDTO class. --> 
  </tr>
  <%
}
  %>
</table>
</div>
</body>
</html>





