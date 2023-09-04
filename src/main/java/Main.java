import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean keepPlaying = true;
    TennisGame tennisGame = new TennisGame();

    while (keepPlaying) {
      String winnerMessage = tennisGame.play();
      System.out.println(winnerMessage);
      keepPlaying = keepPlaying(scanner);
    }

    System.out.println("Thank you for playing with us!");
  }

  private static boolean keepPlaying(Scanner scanner) {
    boolean validAnswer = false;
    String playerAnswer = "";
    while (!validAnswer) {
      System.out.println("Play another game? (Y/N)");
      playerAnswer = scanner.nextLine().toLowerCase();  // Read user input
      if (playerAnswer.equals("y") || playerAnswer.equals("n")) {
        validAnswer = true;
      } else {
        System.out.println("Invalid answer, please try again.");
      }
    }
    return playerAnswer.equals("y");
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