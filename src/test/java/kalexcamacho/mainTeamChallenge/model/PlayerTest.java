package kalexcamacho.mainTeamChallenge.model;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTest {

    private Stats createStats(String power, String distance, String time, String passes) throws InvalidTrainingDataException {
        Stats stats = new Stats();
        stats.setPower(power);
        Speed speed = new Speed(distance, time);
        stats.setSpeed(speed);
        stats.setPasses(passes);
        return stats;
    }

    @Test
    void testPlayerConstructor() {
        List<Stats> stats = new ArrayList<>();
        Player player = new Player(1, "John Doe", stats);

        Assertions.assertEquals(1, player.getId());
        Assertions.assertEquals("John Doe", player.getName());
        Assertions.assertSame(stats, player.getStats());
    }

    @Test
    void testGetAndSetId() {
        Player player = new Player();
        player.setId(1);
        Assertions.assertEquals(1, player.getId());
    }

    @Test
    void testGetAndSetName() {
        Player player = new Player();
        player.setName("John Doe");
        Assertions.assertEquals("John Doe", player.getName());
    }

    @Test
    void testGetAndSetStats() {
        Player player = new Player();
        List<Stats> stats = new ArrayList<>();
        player.setStats(stats);
        Assertions.assertSame(stats, player.getStats());
    }

    @Test
    public void calculateTotalScoreTest() throws InvalidTrainingDataException {
        ArrayList<Stats> statsList = new ArrayList<>();
        statsList.add(createStats("300", "30", "5", "20"));

        Player player = new Player();
        int totalScore = player.calculateTotalScore(statsList, 0.2f, 0.3f, 0.5f);

        Assertions.assertEquals(72, totalScore);
    }

    @Test
    void testCalculateTotalScore_DefaultPercentages() throws InvalidTrainingDataException {
        ArrayList<Stats> statsList = new ArrayList<>();
        statsList.add(createStats("300", "30", "5", "20"));

        Player player = new Player();
        int totalScore = player.calculateTotalScore(statsList, 0.2f, 0.3f, 0.4f); // Suma de porcentajes diferente de 1

        Assertions.assertEquals(72, totalScore);
    }

}
