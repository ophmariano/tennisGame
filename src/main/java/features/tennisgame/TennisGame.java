package features.tennisgame;

import features.game.Game;
import features.player.Player;

public class TennisGame {

  private final Player playerOne;
  private final Player playerTwo;

  public TennisGame() {
    this.playerOne = new Player("Jo");
    this.playerTwo = new Player("Ha");
  }

  public Game playTennisGame() {
    Game game = new Game(playerOne, playerTwo);
    while (!game.hasWinner()) {
      Player gameSetWinner = playGameSet(playerOne, playerTwo);
      scoreWinnerPoint(game, gameSetWinner);
      if (hasVictoryCondition(game, gameSetWinner)) {
        game.setHasWinner(true);
        game.setWinnerPlayer(gameSetWinner);
      }
    }
    String winnerMessage = String.format(
      "Contratulations on winning %s",
      game.getWinnerPlayer().getName()
    );
    String gameScoreBoard = String.format(
      "Game score was: %s | %s - %s | %s",
      playerOne.getName(),
      game.getPlayerOneScore(),
      game.getPlayerTwoScore(),
      playerTwo.getName()
    );
    System.out.println(gameScoreBoard);
    System.out.println(winnerMessage);
    return game;
  }

  private static Player playGameSet(Player playerOne, Player playerTwo) {
    double random = Math.random();
    if (random > 0.5) {
      return playerOne;
    }
    return playerTwo;
  }

  private void scoreWinnerPoint(Game game, Player setWinner) {
    if (setWinner.equals(playerOne)) {
      game.scorePointForPlayerOne(setWinner);
    } else {
      game.scorePointForPlayerTwo(setWinner);
    }
  }

  private boolean hasVictoryCondition(Game game, Player gameSetWinner) {
    int gameSetWinnerScore = game.getPlayerScore(gameSetWinner);
    if (gameSetWinnerScore < 3) {
      return false;
    }
    int scoreDifference = game.getScoreDifference();
    return (gameSetWinnerScore > 3) && (scoreDifference >= 2);
  }
}
