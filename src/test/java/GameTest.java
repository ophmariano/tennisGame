import static org.junit.jupiter.api.Assertions.*;

import features.game.Game;
import features.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

  private Game game;
  private Player playerOne;
  private Player playerTwo;

  @BeforeEach
  void setUp() {
    playerOne = new Player("Jo");
    playerTwo = new Player("Ha");
    game = new Game(playerOne, playerTwo);
  }

  @AfterEach
  void tearDown() {
    playerOne = null;
    playerTwo = null;
    game = null;
  }

  @Test
  void whenGameStartPlayerScoreShouldBeZero() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 0;
    Player playerOne = new Player("Jo");
    Player playerTwo = new Player("Ha");
    //When
    Game newGame = new Game(playerOne, playerTwo);
    //Then
    assertEquals(expectedScorePlayerOne, newGame.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, newGame.getPlayerTwoScore());
  }

  @Test
  void whenScorePointForPlayerOneItShouldGainOnePoint() {
    //Given
    int expectedScorePlayerOne = 1;
    int expectedScorePlayerTwo = 0;
    //When
    game.scorePointForPlayerOne(playerOne);
    //Then
    assertEquals(expectedScorePlayerOne, game.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, game.getPlayerTwoScore());
  }

  @Test
  void whenScorePointForPlayerTwoItShouldGainOnePoint() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 1;
    //When
    game.scorePointForPlayerTwo(playerTwo);
    //Then
    assertEquals(expectedScorePlayerOne, game.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, game.getPlayerTwoScore());
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
      () -> game.scorePointForPlayerTwo(playerOne)
    );

    //Then
    assertEquals(expectedErrorMessage, exception.getMessage());
    assertEquals(expectedScorePlayerOne, game.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, game.getPlayerTwoScore());
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
      () -> game.scorePointForPlayerOne(playerTwo)
    );

    //Then
    assertEquals(expectedErrorMessage, exception.getMessage());
    assertEquals(expectedScorePlayerOne, game.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, game.getPlayerTwoScore());
  }

  @Test
  void getPlayerScore() {
    //Given
    int expectedScorePlayerOne = 0;
    int expectedScorePlayerTwo = 1;
    game.scorePointForPlayerTwo(playerTwo);

    //When
    int playerScore = game.getPlayerScore(playerTwo);

    //Then
    assertEquals(expectedScorePlayerOne, game.getPlayerOneScore());
    assertEquals(expectedScorePlayerTwo, game.getPlayerTwoScore());
    assertEquals(expectedScorePlayerTwo, playerScore);
  }
}
