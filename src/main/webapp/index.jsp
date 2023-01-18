<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Welcome to Gabe Casino</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    
  </head>
  <body>
    <div id="header">
      <h1>Gabe Casino</h1>
      <div id="header-buttons">
    	<button id="login-button" onclick="location.href='ControllerLogin'">Login</button>
    	
    	<button id="register-button" onclick="location.href='ControllerRegister'">Register</button>
  	  </div>
    </div>
    
 	<%@ include file="/WEB-INF/components/login_status.jsp" %>
    <div id="main">
      <h2>Welcome to Gabe Casino!</h2>
      <p>We offer a wide range of games and promotions for our players.</p>
    </div>
    <div id="promotions">
      <h3>Current Promotions</h3>
      <ul>
        <li>Welcome Bonus: 100% match up to $1000</li>
        <li>Weekly Slot Tournament: $5000 in prizes</li>
        <li>Loyalty Program: earn points for every wager and redeem for cash or prizes</li>
      </ul>
    </div>
   <%@ include file="WEB-INF/components/footer.jsp" %>
  </body>
</html>
    