<%@page import="gamemodes.Coinflip" %>
<!DOCTYPE html>
<html>
<head>
    <title>Coin Flip</title>
    <style>
        #coin {
            animation: flip 2s;
            margin:auto;
        }
        
        #main-frame{
        display:flex;
        margin:auto;
        padding:10px;
       
        }
        
        @keyframes flip {
            from {
                transform: rotateY(0deg);
            }
            to {
                transform: rotateY(720deg);
            }
        }
    </style>
</head>
<body>
<div id="main-frame">
	<form>
		<input type="submit" value="Flip the coin">
		
	</form>
    <div id="coin">
        <% 
            String result = Coinflip.flipCoin();
        %>
        <% if (result.equals("heads")) { %>
            <img src="heads.jpg" alt="heads" height="100" width="100"/>
        <% } else { %>
            <img src="tails.jpg" alt="tails" height="100" width="100"/>
        <% } %>
    </div>
</div>
</body>
</html>
