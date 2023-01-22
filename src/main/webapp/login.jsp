<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.DaoUser" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	
	
    <div class="login-form">
        <form method="post">
        <%
	// TODO: vrem sa evitam la refresh aparitia mesajului astuia:
		if(session.getAttribute("LOGIN_STATUS") != null){
			%>
				<div style="color: red;">Login failed</div>
			<%
			session.setAttribute("LOGIN_STATUS", null);
		}
	%>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control">
            </div>
            <div class="form-group">
                <input type="submit" value="Submit" class="submit-btn">
            </div>
        </form>
    </div>
    
   
    
   
</body>
</html>
