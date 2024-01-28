package kalexcamacho.mainTeamChallenge.model;

import java.util.List;

public class TeamSelectionResponse {
    private List<PlayerScore> playerScores;
    private String errorMessage;

    public TeamSelectionResponse() {
    }

    public TeamSelectionResponse(List<PlayerScore> playerScores, String errorMessage) {
        this.playerScores = playerScores;
        this.errorMessage = errorMessage;
    }

    public void setPlayerScores(List<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
