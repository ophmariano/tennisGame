public class Game {

  private final Player playerOne;
  private final Player playerTwo;
  private int playerOneScore;
  private int playerTwoScore;
  private boolean deuce;
  private boolean hasWinner;
  private Player winnerPlayer;

  // TODO: Paulo - [feature-01] make it singleton
  public Game(Player playerOne, Player playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.playerOneScore = 0;
    this.playerTwoScore = 0;
    this.deuce = false;
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

  public int getPlayerOneScore() {
    return playerOneScore;
  }

  public int getPlayerTwoScore() {
    return playerTwoScore;
  }

  public boolean isDeuce() {
    return deuce;
  }

  public void setDeuce(boolean deuce) {
    this.deuce = deuce;
  }

  public boolean hasWinner() {
    return hasWinner;
  }

  public void setHasWinner(boolean hasWinner) {
    this.hasWinner = hasWinner;
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
}
