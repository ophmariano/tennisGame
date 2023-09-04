import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TennisGameTest {

  private TennisGame tennisGame;

  @BeforeEach
  void setUp() {
    tennisGame = new TennisGame();
  }
  @Test
  public void playTennisGame() {
    //Given
    String expectedWinner = "Ha";

    //When
    String winnerOfGame = tennisGame.play();

    //Then
    Assertions.assertEquals(expectedWinner, winnerOfGame);

  }
}