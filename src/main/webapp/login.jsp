<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.DaoUser" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%!
		DaoUser dao = new DaoUser();
	%>
	
	<%
	// TODO: vrem sa evitam la refresh aparitia mesajului astuia:
		if(request.getParameter("eroare") != null){
			%>
				<div style="color: red;">Login failed</div>
			<%
		}
	%>
	
    <div class="login-form">
        <form method="post">
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
    
    <%
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	boolean isTrue = dao.checkLogin(username,password);
    	//if(isTrue){
   	
    %>
        
    <%
    	//}else
    %>
    
   
</body>
</html>
