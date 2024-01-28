package kalexcamacho.mainTeamChallenge.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TeamSelectionResponseTest {

    @Test
    void testSetPlayerScores() {
        TeamSelectionResponse response = new TeamSelectionResponse();
        List<PlayerScore> playerScores = List.of(new PlayerScore()); // Crear una lista de PlayerScore para la prueba
        response.setPlayerScores(playerScores);

        assertEquals(playerScores, response.getPlayerScores());
    }

    @Test
    void testSetErrorMessage() {
        TeamSelectionResponse response = new TeamSelectionResponse();
        String errorMessage = "Error message";
        response.setErrorMessage(errorMessage);

        assertEquals(errorMessage, response.getErrorMessage());
    }

    @Test
    public void testConstructor() {
        List<PlayerScore> playerScores = List.of(new PlayerScore(), new PlayerScore());

        String errorMessage = "Test error message";

        TeamSelectionResponse response = new TeamSelectionResponse(playerScores, errorMessage);

        assertEquals(playerScores, response.getPlayerScores());
        assertEquals(errorMessage, response.getErrorMessage());
    }
}
