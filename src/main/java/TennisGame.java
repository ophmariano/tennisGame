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
