<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.User"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h2#titlu-pagina {
	color: red;
}

table#tabel-activity {
	display: none;
}
</style>
<!--  pentru jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>
</head>
<body>
	<h2 id="titlu-pagina">Users</h2>
	<%@ include file="components/login_status.jsp"%>


	<script>
		let theH2 = document.getElementById('titlu-pagina');
		console.log('titlu: ', theH2);
		theH2.style.color = 'blue';
	</script>
	<%
	List<User> userii = (List<User>) request.getAttribute("USERII"); //dao.testSelect();
	%>
	
	<a href="">Previous</a>
	<a href="">Next</a>

	<table border="1">
		<thead>
			<tr>
				<th><a href="?sort=desc&element=id">Id</a></th>
				<th><a href="?sort=desc&element=name">Name</a></th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (User u : userii) {
				// out.println("<tr><td>"+u.getId()+"</td><td>"+u.getName()+"</td></tr>");
			%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td>
					<%-- <a href="?userId=<%= u.getId() %>">Delete</a> --%>
					<form method="post">
						<input type="hidden" value="<%=u.getId()%>" name="userId">
						<input type="submit" value="Delete">
					</form>
				</td>
			</tr>
			<%
			} // end for
			%>
		</tbody>
	</table>

	<br>

	<form method="post" id="">
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
			<input type="submit"  id="submit-form" value="Save new user">
		</div>
	</form>
	<%
	// verifica daca vrem sa salvam un nou user
	%>

	<div>
		<table border="1" id="tabel-activity">
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
	</div>
	<button id="btn-load-activity">Load activity</button>

	<%
	out.println(request.getContextPath());
	%>

	<%
	String mesajPentruJs = "salutare din java";
	%>
	<script>
		let mesaj = '<%=mesajPentruJs%>';
		console.log('mesajul din java: ', mesaj);
	</script>

	<script>
		document.getElementById('btn-load-activity').addEventListener('click', function(){
			console.log('loading activity from server');
			
			let tabelul = document.getElementById('tabel-activity');
			tabelul.style.display = 'inline-block';
			
			fetch('<%=request.getContextPath()%>/ControllerRestActivity')
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
		
<div id="dialog-eroare" title="Basic dialog">
  <p>Error saving new user, complete all fields</p>
</div>
	<script>
	$("#dialog-eroare").css({
		'display' : 'none'
	});
	$(document).ready(function() {
	    $('#submit-form').click(function(e) {
	        e.preventDefault();
	        var empty = false;
	        $('form input').each(function() {
	            if ($(this).val() == '') {
	                empty = true;
	            }
	        });
	        if (empty) {
	        	$( "#dialog-eroare" ).dialog();
	        	
	        } else {
	            $('form').submit();
	        }
	    });
	});

	</script>
</body>
</html>
