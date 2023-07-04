<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote Page</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, return-login");
%>
<% int userId = (int)request.getAttribute("userId"); %>
    <div
      class="h-100 d-flex align-items-center justify-content-center"
      style="text-align: center"
    >
      <div style="margin-top: 250px; text-align: center">Vote a Candidate</div>
      <br />
      <form action="/receiveVote/<%=userId %>" method="post">  <!-- record users vote -->
        <input type="checkbox" class="checkoption" value="Candidate 1" name="candidate" /> 
       Candidate 1
        <br />
        <input type="checkbox" class="checkoption" value="Candidate 2" name="candidate" />
        Candidate 2
        <br />
        <input type="checkbox" class="checkoption" value="Candidate 3" name="candidate" />
       Candidate 3
        <br />
        <input type="checkbox" class="checkoption" value="Candidate 4" name="candidate" />
         Candidate 4
        <br /><br />
          <button type="submit">Vote </button>
         <br/><br/> <button style="background-color: red; textcolor: white;"><nav><a href="logout">Log Out</a></nav></button>
          
      </form>
    </div>
 
    <!-- Script --> <!-- ensures that only one check box is tick at a time  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function () { // lets wait until page is loaded
        $(".checkoption").click(function () {  //allws to click one optn
          $(".checkoption").not(this).prop("checked", false); //selects all except the selected one
        }); //basically wat it is doing is when user checks one box all the other are unchecked 
      });
    </script>
  </body>
</html>