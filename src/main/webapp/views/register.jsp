<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, return-login");
%>
<body>

    <div class="h-100 d-flex align-items-center justify-content-center"style="margin: 250px">
      <div style="text-align: center">Login</div>
      <br />
      <form action="register" method="post" style="text-align: center">
        <div class="container">
          <label for="username"><b>Username</b></label>
          <input type="text" placeholder="Enter Username" name="username"required />
          <br /><br />
          <label for="password"><b>Password</b></label>
          <input type="password" placeholder="Enter Password"  name="password"required />
          <br /><br />
          <label for="username"><b>Email</b></label>
          <input type="text"placeholder="Enter Email"name="email" required /><br /><br />
          <label for="username"><b>Phone Number</b></label>
          <input type="text" placeholder="Enter Phone Number"name="phoneNumber"required />
         <br/>  <br/> <button type="submit" style="background-color: green; color: white;">Register</button>
        </div>
      </form>
    </div>
  </body>
</body>
</html>