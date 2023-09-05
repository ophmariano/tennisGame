package features.gameset;

import features.player.Player;
import features.printdisplay.MessageDisplay;

public class GameSet {

  private final Player playerOne;
  private final Player playerTwo;
  private int playerOneScore;
  private int playerTwoScore;
  private Player winnerPlayer;
  private boolean deuce;

  // TODO: Paulo - [feature-01] make it singleton
  public GameSet(Player playerOne, Player playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.playerOneScore = 0;
    this.playerTwoScore = 0;
  }

  public void scorePointForPlayerOne(Player player) {
    if (playerOne.getName().equals(player.getName())) {
      this.playerOneScore++;
    } else {
      //TODO: Paulo - [feature-01] create custom error class
      String errorMessage = String.format(
        "Was not able to score points for %s. Informed player was %s",
        playerOne.getName(),
        player.getName()
      );
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public void scorePointForPlayerTwo(Player player) {
    if (playerTwo.getName().equals(player.getName())) {
      this.playerTwoScore++;
    } else {
      //TODO: Paulo - [feature-01] - Create custom error class
      String errorMessage = String.format(
        "Was not able to score points for %s. Informed player was %s",
        playerTwo.getName(),
        player.getName()
      );
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public int getPlayerScore(Player player) {
    if (playerOne.getName().equals(player.getName())) {
      return getPlayerOneScore();
    } else {
      return getPlayerTwoScore();
    }
  }

  public void checkForDeuce(GameSet gameSet, Player gameSetWinner) {
    if (gameSet.getPlayerScore(gameSetWinner) < 3) {
      return;
    }
    if (gameSet.getPlayerOneScore() == gameSet.getPlayerTwoScore()) {
      setDeuce(true);
      MessageDisplay.gameInDeuce();
    }
  }

  public int getPlayerOneScore() {
    return playerOneScore;
  }

  public int getPlayerTwoScore() {
    return playerTwoScore;
  }

  public Player getPlayerOne() {
    return playerOne;
  }

  public Player getPlayerTwo() {
    return playerTwo;
  }

  public Player getWinnerPlayer() {
    return winnerPlayer;
  }

  public void setWinnerPlayer(Player winnerPlayer) {
    this.winnerPlayer = winnerPlayer;
  }

  public int getScoreDifference() {
    return Math.abs(getPlayerOneScore() - getPlayerTwoScore());
  }

  public void setDeuce(boolean deuce) {
    this.deuce = deuce;
  }

  public boolean isDeuce() {
    return deuce;
  }

  public Player playPoint() {
    double random = Math.random();
    if (random > 0.5) {
      return playerOne;
    }
    return playerTwo;
  }

  public boolean hasVictoryCondition(Player pointWinner) {
    int gameSetWinnerScore = getPlayerScore(pointWinner);
    if (gameSetWinnerScore < 3) {
      return false;
    }
    int scoreDifference = getScoreDifference();
    return (gameSetWinnerScore > 3) && (scoreDifference >= 2);
  }

  public void scoreWinnerPoint(Player pointWinner) {
    if (playerOne.getName().equals(pointWinner.getName())) {
      scorePointForPlayerOne(pointWinner);
    } else {
      scorePointForPlayerTwo(pointWinner);
    }
  }
}
