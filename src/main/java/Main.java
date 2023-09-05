import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean keepPlaying = true;

    while (keepPlaying) {
      TennisGame tennisGame = new TennisGame();
      String winnerMessage = tennisGame.playTennisGame();
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
}