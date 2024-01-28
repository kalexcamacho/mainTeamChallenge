package kalexcamacho.mainTeamChallenge.model;

import java.util.ArrayList;
import java.util.List;

public class TrainingData {
    private List<Player> players;

    public TrainingData() {
    }

    public TrainingData(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
