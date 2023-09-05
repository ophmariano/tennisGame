public class TennisGame {

  private final Player playerOne;
  private final Player playerTwo;

  public TennisGame() {
    this.playerOne = new Player("Jo");
    this.playerTwo = new Player("Ha");
  }

  public Game playTennisGame() {
    //start game
    Game game = new Game(playerOne, playerTwo);
    while (!game.hasWinner()) {
      Player gameSetWinner = playGameSet(playerOne, playerTwo);
      scoreWinnerPoint(game, gameSetWinner);
//      game.setWinnerPlayer(playerOne);
      game.setWinnerPlayer(gameSetWinner);
      game.setHasWinner(true);
    }
    return game;
//
    // print the evolution and after the winner.
//    System.out.println(playerOneName);

  }

  private void scoreWinnerPoint( Game game, Player setWinner) {
    if (setWinner.equals(playerOne)) {
      game.scorePointForPlayerOne(setWinner);
    } else {
      game.scorePointForPlayerTwo(setWinner);
    }
  }

  private static Player playGameSet(Player playerOne, Player playerTwo) {
    double random = Math.random();
    if (random > 0.5) {
      return playerOne;
    }
    return playerTwo;
  }
}
