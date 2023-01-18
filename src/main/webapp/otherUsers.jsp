<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="model.User" %>
<%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
String mesaj = (String)request.getAttribute("MesajdinServlet");
out.println("Mesajul din servlet este : " + mesaj);
%>

<%
List<User> users = (List<User>)request.getAttribute("Users");
%>

<table style="border:1px solid black">
<thead>
<tr><th>Id</th><th>Name</th><th>Actions</th>
</thead>
<tbody>

<%
for(User x : users){
%>
<tr><td><%= x.getId()%></td><td><%=x.getName() %></td>
<td>
	<form method="post">
		<input type="hidden" value="<%= x.getId() %>" name="userId">
		<input type="submit" value="Delete">
	</form> 
</td>
</tr>

<%} %>
</tbody>
</table>


</body>
</html>