<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="model.User" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Users</h2>
	<%@ include file="components/login_status.jsp" %>
	
	
	<%
	
	List<User> userii = (List<User>)request.getAttribute("USERII"); //dao.testSelect();

	%>
	
	<table border="1">
		<thead>
			<tr><th><a href="?sort=desc&element=id">Id</a></th><th><a href="?sort=desc&element=name">Name</a></th><th>Actions</th></tr>
		</thead>
		<tbody>
			<%
				for(User u : userii){
					// out.println("<tr><td>"+u.getId()+"</td><td>"+u.getName()+"</td></tr>");
			%>
				<tr><td><%= u.getId() %></td><td><%= u.getName() %></td>
				<td>
				<%-- <a href="?userId=<%= u.getId() %>">Delete</a> --%>
				<form method="post">
					<input type="hidden" value="<%= u.getId() %>" name="userId">
					<input type="submit" value="Delete">
				</form> 
				</td>
				</tr>
			<%	}// end for
			%>
		</tbody>
	</table>
	
	<br>
	
	<form method="post">
		<div>
		<input placeholder="Name" name="new-username">
		</div>
		<div>
		<input placeholder="Email" name="new-useremail">
		</div>
		<div>
		<input placeholder="Balance" name="new-userbalance">
		</div>
		<div>
			<input type="submit" value="Save new user">
		</div>
	</form>
	<%
		// verifica daca vrem sa salvam un nou user
		
		
	%>
	
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>User id</th>
				<th>Last login</th>
				<th>Ip</th>
			</tr>
		</thead>
		<tbody id="tbody-tabel-activity">
		</tbody>
	</table>
	<button id="btn-load-activity">Load activity</button>
	
	<script>
		document.getElementById('btn-load-activity').addEventListener('click', function(){
			console.log('loading activity from server');
			fetch('http://localhost:8080/BlackjackWeb/ControllerRestActivity')
			.then(datele => datele.json())
			.then(datele => {
				console.log('de la server am luat: ', datele);
				let corpTabel = document.getElementById("tbody-tabel-activity");
				for(let act of datele){
					corpTabel.innerHTML += '<tr><td>'+act.id+'</td><td>'+act.user_id+'</td><td>'+act.last_login+'</td><td>'+act.user_ip+'</td></tr>';
				}
			})
			
		})
		
		// tabelul sa fie afisat DOAR cand dam click prima oara pe buton
		// ar trebui ca datele care vin la fiecare click pe buton sa inlocuiasca vechile date din 'vechiul' tabel
		</script>
	
</body>
</html>