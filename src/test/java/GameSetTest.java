import static org.junit.jupiter.api.Assertions.*;

import features.gameset.GameSet;
import features.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameSetTest {

  private GameSet gameSet;
  private Player playerOne;
  private Player playerTwo;

  @BeforeEach
  void setUp() {
    playerOne = new Player("Jo");
    playerTwo = new Player("Ha");
    gameSet = new GameSet(playerOne, playerTwo);
  }

  @AfterEach
  void tearDown() {
    playerOne = null;
    playerTwo = null;
    gameSet = null;
  }

  @Test
  void whenGameStartPlayerScoreShouldBeZero() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 0;
    Player playerOne = new Player("Jo");
    Player playerTwo = new Player("Ha");
    //When
    GameSet newGameSet = new GameSet(playerOne, playerTwo);
    //Then
    assertEquals(expectedScorePlayerOne, newGameSet.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, newGameSet.getPlayerTwoScore());
  }

  @Test
  void whenScorePointForPlayerOneItShouldGainOnePoint() {
    //Given
    int expectedScorePlayerOne = 1;
    int expectedScorePlayerTwo = 0;
    //When
    gameSet.scorePointForPlayerOne(playerOne);
    //Then
    assertEquals(expectedScorePlayerOne, gameSet.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, gameSet.getPlayerTwoScore());
  }

  @Test
  void whenScorePointForPlayerTwoItShouldGainOnePoint() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 1;
    //When
    gameSet.scorePointForPlayerTwo(playerTwo);
    //Then
    assertEquals(expectedScorePlayerOne, gameSet.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, gameSet.getPlayerTwoScore());
  }

  @Test
  void shouldThrowExceptionWhenScoringForWrongPlayerTwo() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 0;
    String expectedErrorMessage = String.format(
      "Was not able to score points for %s. Informed player was %s",
      playerTwo.getName(),
      playerOne.getName()
    );
    //When
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> gameSet.scorePointForPlayerTwo(playerOne)
    );

    //Then
    assertEquals(expectedErrorMessage, exception.getMessage());
    assertEquals(expectedScorePlayerOne, gameSet.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, gameSet.getPlayerTwoScore());
  }

  @Test
  void shouldThrowExceptionWhenScoringForWrongPlayerOne() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 0;
    String expectedErrorMessage = String.format(
      "Was not able to score points for %s. Informed player was %s",
      playerOne.getName(),
      playerTwo.getName()
    );
    //When
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> gameSet.scorePointForPlayerOne(playerTwo)
    );

    //Then
    assertEquals(expectedErrorMessage, exception.getMessage());
    assertEquals(expectedScorePlayerOne, gameSet.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, gameSet.getPlayerTwoScore());
  }

  @Test
  void getPlayerScore() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 1;
    gameSet.scorePointForPlayerTwo(playerTwo);

    //When
    int playerScore = gameSet.getPlayerScore(playerTwo);

    //Then
    assertEquals(expectedScorePlayerOne, gameSet.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, gameSet.getPlayerTwoScore());
    assertEquals(expectedScorePlayerTwo, playerScore);
  }
}
