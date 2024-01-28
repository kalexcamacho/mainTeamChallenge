package kalexcamacho.mainTeamChallenge.model;

import java.util.List;

/**
 * Represents training data consisting of a list of players.
 */
public class TrainingData {
    private List<Player> players;

    /**
     * Default constructor for creating an instance of TrainingData without any initial data.
     */
    public TrainingData() {
    }

    /**
     * Constructs a TrainingData object with a list of players.
     *
     * @param players The list of Player objects representing the players for training.
     */
    public TrainingData(List<Player> players) {
        this.players = players;
    }

    /**
     * Retrieves the list of players.
     *
     * @return The list of Player objects.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Sets the list of players.
     *
     * @param players The list of Player objects to set.
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
