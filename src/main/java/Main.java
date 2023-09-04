public class Main {
  public static void main(String[] args) {
    //start game
    String playerOneName = "Jo";
    String playerTwoName = "Ha";
//    startGame(playerOneName, playerTwoName);
    // print the evolution and after the winner.
//    System.out.println(playerOneName);

  }

//  private static void startGame(String playerOneName, String playerTwoName) {
//    if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
//      return; //exception
//    }
//
//    Player playerOne = new Player(playerOneName);
//    Player playerTwo = new Player(playerTwoName);
//
//    Player winnerOfSet = playGameSet(playerOne, playerTwo);
//    scoringPoint(playerOne, playerTwo, winnerOfSet);
//
//    //victoryConditions - having 4 points or 2 more when in deuce
//    int victoryPointsCondition = 4;
//    if (winnerOfSet.getScore() > victoryPointsCondition && winnerOfSet.hasAdvantage()) {
//      //Enter EndGame
//      if (checkForDeuce(playerOne, playerTwo)) {
//        // KeepPlaying
//      }
//      //won the game
//    }
//    int i = playerOne.getScore() - playerTwo.getScore();
//
//
//    //gameEnd
//  }
//
//  private static boolean checkForDeuce() {
//    return gameIsDeuce;
//  }
//
//  private static void scoringPoint(Player playerOne, Player playerTwo, Player winnerOfSet) {
//    int setScore = 1;
//    if (playerOne.equals(winnerOfSet)) {
//      int playerScore = playerOne.getScore();
//      playerOne.setScore(playerScore + setScore);
//    } else {
//      int playerScore = playerTwo.getScore();
//      playerTwo.setScore(playerScore + setScore);
//    }
//  }
//
//  private static Player playGameSet(Player playerOne, Player playerTwo) {
//    double random = Math.random();
//    if (random > 0.5) {
//      return playerOne;
//    }
//    return playerTwo;
//  }

//  public int getRandomNumber(int min, int max) {
//
//}
}