package kalexcamacho.mainTeamChallenge.model;

/**
 * Represents a player's score in the team selection system.
 * This class stores the player's unique identifier, name, and score.
 */
public class PlayerScore {
    private int id;
    private String name;
    private int score;

    /**
     * Default constructor for creating an instance of PlayerScore without any initial data.
     */
    public PlayerScore() {

    }

    /**
     * Constructs a new PlayerScore with the specified ID, name, and score.
     *
     * @param id    The unique identifier of the player.
     * @param name  The name of the player.
     * @param score The score of the player.
     */
    public PlayerScore(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
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
     * Retrieves the score of the player.
     *
     * @return The score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the player.
     *
     * @param score The score of the player.
     */
    public void setScore(int score) {
        this.score = score;
    }
}
