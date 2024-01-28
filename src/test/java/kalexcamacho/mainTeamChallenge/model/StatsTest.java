package kalexcamacho.mainTeamChallenge.model;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsTest {

    @Test
    void testStatsConstructor() throws InvalidTrainingDataException {
        String power = "300";
        Speed speed = new Speed("30", "5");
        String passes = "20";

        Stats stats = new Stats(power, speed, passes);

        assertEquals(power, stats.getPower());
        assertEquals(speed, stats.getSpeed());
        assertEquals(passes, stats.getPasses());
    }
}
