<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home page</title>
</head>
<%
long votesForCandidate1 = (long)request.getAttribute("votesForCandidate1");  //request obj created by web container when snd reqst to applctn
long votesForCandidate2 = (long)request.getAttribute("votesForCandidate2");//in this case set in the request pipeline in same jsp
long votesForCandidate3 = (long)request.getAttribute("votesForCandidate3");
long votesForCandidate4 = (long)request.getAttribute("votesForCandidate4");
long sum = (long)request.getAttribute("sum");
%><style>
table, th, td {
  border:1px solid black;
}
</style>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, return-login");
%>

<div
      class="h-100 d-flex align-items-center justify-content-center"
    >
<table style="width:80%; margin: auto; text-align: center;">
  <tr>
    <td>Candidate Name</td>
    <td>Votes Received</td>
  </tr>
  <tr>
    <td>Candidate-1</td>
    <td><%=votesForCandidate1 %></td>
  </tr>
  <tr>
    <td>Candidate-2</td>
    <td><%=votesForCandidate2 %></td>
  </tr>
  <tr>
    <td>Candidate-3</td>
    <td><%=votesForCandidate3 %></td>
  </tr>
  <tr>
    <td>Candidate-4</td>
    <td><%=votesForCandidate4 %></td>
    <nav><a href="logout">Log Out</a></nav>
  </tr>
</table>
</div>
</body>
</html>