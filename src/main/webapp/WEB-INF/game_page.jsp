<!DOCTYPE html>
<html>
<head>
  <title>Game Select</title>
  <link href="gamepage_style.css" rel="stylesheet" type="text/css">
  
</head>
<body>
	<%@ include file="components/login_status.jsp" %>
	<div>
		<a href="/BlackjackWeb/LogoutController">Logout</a>
	</div>

  <h1>Select a Game</h1>
  <form method="post">
    <div class="game-options">
        <div class="game-option">
            <input type="radio" name="game" value="blackjack" id="blackjack"/>
            <label for="blackjack">BlackJack</label>
            <p>Play the classic card game against the dealer.</p>
        </div>
        <div class="game-option">
            <input type="radio" name="game" value="roulette" id="roulette"/>
            <label for="roulette">Roulette</label>
            <p>Spin the wheel and place your bets.</p>
        </div>
        <div class="game-option">
            <input type="radio" name="game" value="coinflip" id="coinflip"/>
            <label for="coinflip">Coinflip</label>
            <p>Heads or tails? Place your bets.</p>
        </div>
        <div class="game-option">
            <input type="radio" name="game" value="slots" id="slots"/>
            <label for="slots">Slots</label>
            <p>Spin the reels and win big.</p>
        </div>
    </div>
    <input type="submit" value="Start Game">
  </form>
</body>
</html>
