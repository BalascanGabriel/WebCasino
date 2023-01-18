<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="gamepage_style.css">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="components/login_status.jsp" %>
	<div>
		<a href="/BlackjackWeb/LogoutController">Logout</a>
	</div>
	
	<div >
		<form method="post">
		<h1>Select a Game Mode</h1>
			<input type="radio" name="mode" value="blackjack">BlackJack<br>
			<input type="radio" name="mode" value="roulette">Roulette<br>
			<input type="radio" name="mode" value="coinflip">Coinflip<br>
			<input type="radio" name="mode" value="slots">Slots<br>
			<input type="submit" value="Play">
		</form>
	</div>
</body>
</html>