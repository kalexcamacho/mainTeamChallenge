package kalexcamacho.mainTeamChallenge.model;

import java.util.List;

/**
 * Represents the response of a team selection process, containing player scores and an error message if applicable.
 */
public class TeamSelectionResponse {
    private List<PlayerScore> playerScores;
    private String errorMessage;

    /**
     * Default constructor for creating an instance of TeamSelectionResponse without any initial data.
     */
    public TeamSelectionResponse() {
    }

    /**
     * Constructs a TeamSelectionResponse with a list of player scores and an error message.
     *
     * @param playerScores List of PlayerScore objects representing the scores of the selected players.
     * @param errorMessage Error message describing any issues that occurred during team selection.
     */
    public TeamSelectionResponse(List<PlayerScore> playerScores, String errorMessage) {
        this.playerScores = playerScores;
        this.errorMessage = errorMessage;
    }

    /**
     * Sets the list of player scores.
     *
     * @param playerScores The list of PlayerScore objects to set.
     */
    public void setPlayerScores(List<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }

    /**
     * Sets the error message.
     *
     * @param errorMessage The error message to set.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Retrieves the list of player scores.
     *
     * @return The list of PlayerScore objects.
     */
    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    /**
     * Retrieves the error message.
     *
     * @return The error message, if any.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

}
