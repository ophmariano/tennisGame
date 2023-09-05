import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean keepPlaying = true;

    while (keepPlaying) {
      TennisGame tennisGame = new TennisGame();
      tennisGame.playTennisGame();
      keepPlaying = keepPlaying(scanner);
    }

    System.out.println("Thank you for playing with us!");
  }

  private static boolean keepPlaying(Scanner scanner) {
    boolean validAnswer = false;
    String playerAnswer = "";
    while (!validAnswer) {
      System.out.println("Play another game? (Y/N)");
      playerAnswer = scanner.nextLine().toLowerCase();
      if (playerAnswer.equals("y") || playerAnswer.equals("n")) {
        validAnswer = true;
      } else {
        System.out.println("Invalid answer, please try again.");
      }
    }
    return playerAnswer.equals("y");
  }
}
