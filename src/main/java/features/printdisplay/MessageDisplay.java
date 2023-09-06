package features.printdisplay;

import features.gameset.GameSet;

public class MessageDisplay {

  private static void printMessage(String message) {
    System.out.println(message);
  }

  public static void finalGameScore(GameSet gameSet) {
    String gameFinalScoreBoard = String.format(
      "Game total points made was: %s | %s - %s | %s",
      gameSet.getPlayerOne().getName(),
      gameSet.getPlayerOneScore(),
      gameSet.getPlayerTwoScore(),
      gameSet.getPlayerTwo().getName()
    );
    printMessage(gameFinalScoreBoard);
  }

  public static void winner(String winnerName) {
    String gameWinner = String.format(
      "Congratulations on winning %s",
      winnerName
    );
    printMessage(gameWinner);
  }

  public static void gameInDeuce() {
    String deuce = "Game is in Deuce";
    printMessage(deuce);
  }

  public static void playerGainsAdvantage(String playerName) {
    String playerGainsAdvantage = String.format(
      "Player %s has the advantage",
      playerName
    );
    printMessage(playerGainsAdvantage);
  }

  public static void gameStart() {
    printMessage("The game starts!!!!");
  }

  public static void gameScore(String playerOneName, String scoreSection, String playerTwoName) {
    String gameFinalScoreBoard = String.format(
        "%s | %s | %s",
        playerOneName,
        scoreSection,
        playerTwoName
    );
    printMessage(gameFinalScoreBoard);
  }
}
