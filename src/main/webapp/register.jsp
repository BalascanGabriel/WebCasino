<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.DaoUser" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Registration Page</title>
    <link href="registerstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	 <div>
    	<%= session.getAttribute("STATUS_LOGIN") %>
    </div>
    <div class="register-form">
        <form method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control">
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
