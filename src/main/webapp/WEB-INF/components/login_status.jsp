<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
   <div>
    	<% 
    		User user = (User)session.getAttribute("UTILIZATORUL");
    		if(user != null){
    		out.println("Welcome, " + user.getName());
    		}else{
    			out.println("Not logged in");
    		}
    	%>
    </div>
    