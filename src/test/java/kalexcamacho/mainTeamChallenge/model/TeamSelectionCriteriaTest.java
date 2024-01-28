package kalexcamacho.mainTeamChallenge.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamSelectionCriteriaTest {

    @Test
    void testGetPowerPercentage() {
        Float expectedPowerPercentage = 0.5f;
        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setPowerPercentage(expectedPowerPercentage);

        assertEquals(expectedPowerPercentage, criteria.getPowerPercentage());
    }

    @Test
    void testGetSpeedPercentage() {
        Float expectedSpeedPercentage = 0.3f;
        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setSpeedPercentage(expectedSpeedPercentage);

        assertEquals(expectedSpeedPercentage, criteria.getSpeedPercentage());
    }

    @Test
    void testGetPassesPercentage() {
        Float expectedPassesPercentage = 0.2f;
        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setPassesPercentage(expectedPassesPercentage);

        assertEquals(expectedPassesPercentage, criteria.getPassesPercentage());
    }

    @Test
    void testGetTeamSize() {
        Integer expectedTeamSize = 11;
        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setTeamSize(expectedTeamSize);

        assertEquals(expectedTeamSize, criteria.getTeamSize());
    }
}
