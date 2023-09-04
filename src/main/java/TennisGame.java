public class TennisGame {
  public TennisGame(){}

  public String play() {
    //start game
    Player playerOne = new Player("Jo");
    Player playerTwo = new Player("Ha");
    Game game = new Game(playerOne, playerTwo);
    while (!game.hasWinner()) {
      //KeepPlaying
//      game.setWinnerPlayer(playerOne);
      game.setWinnerPlayer(playerTwo);
      game.setHasWinner(true);
    }

    return game.getWinnerPlayer().getName();
//
    // print the evolution and after the winner.
//    System.out.println(playerOneName);

  }
}
