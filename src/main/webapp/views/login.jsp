<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, return-login");
%>

<body>
    <div class="h-100 d-flex align-items-center justify-content-center"style="margin: 250px"
    >
      <div style="text-align: center">-- LOGIN PAGE --</div>
      <br />
      <form action="login" method="post" style="text-align: center">
        <div class="container">
          <label for="username"><b>Username</b></label>
          <input type="text" placeholder="Enter Username"  name="username"  required/>
          <br /><br />
          <label for="password"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" name="password" required/>
          <br /><br />
          <button type="submit" style="background-color: green; color: white; style="margin-right: 50px"; >Login</button>
         <button> <a href="register" style="text-decoration: none; color: Green">Register</a></button>
        </div>
      </form>
    </div>
  </body>
</body>
</html>