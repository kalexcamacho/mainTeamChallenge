package kalexcamacho.mainTeamChallenge.model;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Represents a player in the team challenge system.
 * This class stores the player's unique identifier, name, and statistics.
 */
@Document
public class Player {
    @Id
    private int id;
    private String name;
    private List<Stats> stats;

    /**
     * Default constructor for creating an instance of Player without any initial data.
     */
    public Player() {
    }

    /**
     * Constructs a new Player with the specified ID, name, and list of statistics.
     *
     * @param id    The unique identifier of the player.
     * @param name  The name of the player.
     * @param stats A list of {@link Stats} associated with the player.
     */
    public Player(int id, String name, List<Stats> stats) {
        this.id = id;
        this.name = name;
        this.stats = stats;
    }

    /**
     * Retrieves the unique identifier of the player.
     *
     * @return The ID of the player.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the player.
     *
     * @param id The ID of the player.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     *
     * @param name The name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the stats of the player.
     *
     * @return The stats of the player.
     */
    public List<Stats> getStats() {
        return stats;
    }

    /**
     * Sets the stats of the player.
     *
     * @param stats The name of the player.
     */
    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    /**
     * Calculates the total score for the player based on their statistics and the given weightage percentages.
     *
     * @param stats             The list of {@link Stats} to be evaluated.
     * @param powerPercentage   The weightage given to the power stat.
     * @param speedPercentage   The weightage given to the speed stat.
     * @param passesPercentage  The weightage given to the passes stat.
     * @return The calculated total score as an integer.
     */
    public int calculateTotalScore(List<Stats> stats, float powerPercentage, float speedPercentage, float passesPercentage) throws InvalidTrainingDataException {
        int totalScore = 0;

        final float defaultPowerPercentage = 0.20f;
        final float defaultSpeedPercentage = 0.30f;
        final float defaultPassesPercentage = 0.50f;

        float totalPercentage = powerPercentage + speedPercentage + passesPercentage;

        if (totalPercentage != 1) {
            powerPercentage = defaultPowerPercentage;
            speedPercentage = defaultSpeedPercentage;
            passesPercentage = defaultPassesPercentage;
        }

        if (stats != null && !stats.isEmpty()) {
            for (Stats stat : stats) {
                float powerScore = Integer.parseInt(stat.getPower()) * powerPercentage;
                float speedScore = stat.getSpeed().calculateSpeed() * speedPercentage;
                float passesScore = Integer.parseInt(stat.getPasses()) * passesPercentage;

                totalScore += Math.round(powerScore + speedScore + passesScore);
            }
        }

        return totalScore;
    }
}
