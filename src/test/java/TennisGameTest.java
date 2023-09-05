import features.game.Game;
import features.tennisgame.TennisGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TennisGameTest {

  private TennisGame tennisGame;

  @BeforeEach
  void setUp() {
    tennisGame = new TennisGame();
  }

  @Test
  public void playTennisGameShouldHaveWinnerWithOnePoint() {
    //Given
    int expectedPoint = 1;
    //When
    Game game = tennisGame.playTennisGame();

    //Then
    int gameScoreDifference = Math.abs(
      game.getPlayerOneScore() - game.getPlayerTwoScore()
    );
    Assertions.assertTrue(game.hasWinner());
    Assertions.assertEquals(expectedPoint, gameScoreDifference);
  }
}
//love-love -> 0
//15-love -> 1
//30-0 -> 2
//40-0 -> 3
//50-0 -> 4 = 1win
//-------------
//30-30 -> 2
//40-30 -> 3
//50-30 -> 4 = 1win
//-------------
//40-40 -> 3 = deuce
//50-40 -> 4
//60-40 -> 5 = 1win
//------------
