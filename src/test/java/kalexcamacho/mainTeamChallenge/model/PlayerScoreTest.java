package kalexcamacho.mainTeamChallenge.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerScoreTest {

    @Test
    public void testConstructorAndGetters() {
        PlayerScore playerScore = new PlayerScore(1, "Player Name", 100);

        assertEquals(1, playerScore.getId());
        assertEquals("Player Name", playerScore.getName());
        assertEquals(100, playerScore.getScore());
    }

    @Test
    public void testSetters() {
        PlayerScore playerScore = new PlayerScore();

        playerScore.setId(2);
        playerScore.setName("Another Name");
        playerScore.setScore(200);

        assertEquals(2, playerScore.getId());
        assertEquals("Another Name", playerScore.getName());
        assertEquals(200, playerScore.getScore());
    }
}
