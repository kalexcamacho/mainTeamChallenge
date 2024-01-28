package kalexcamacho.mainTeamChallenge.service;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import kalexcamacho.mainTeamChallenge.model.Player;
import kalexcamacho.mainTeamChallenge.model.PlayerScore;
import kalexcamacho.mainTeamChallenge.model.TeamSelectionCriteria;
import kalexcamacho.mainTeamChallenge.model.TeamSelectionResponse;
import kalexcamacho.mainTeamChallenge.repository.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Service class for handling team selection based on various criteria.
 * This service is responsible for processing the team selection logic
 * and providing the selected team as a response.
 */
@Service
public class TeamSelectionService {

    private final PlayerRepository playerRepository;

    /**
     * Constructs a new TeamSelectionService with the provided PlayerRepository.
     *
     * @param playerRepository The repository used for accessing player data.
     */
    public TeamSelectionService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Calculates the main team based on the given team selection criteria.
     * This method evaluates players and forms a team based on the defined criteria
     * such as power percentage, speed percentage, and passes percentage.
     *
     * @param criteria The criteria based on which the team is selected.
     * @return A ResponseEntity containing the TeamSelectionResponse.
     */
    public ResponseEntity<TeamSelectionResponse> calculateMainTeam(TeamSelectionCriteria criteria) {
        List<Player> players = playerRepository.findAll();

        float powerPercentage = criteria.getPowerPercentage() != null ? criteria.getPowerPercentage() / 100.0f : 0.2f;
        float speedPercentage = criteria.getSpeedPercentage() != null ? criteria.getSpeedPercentage() / 100.0f : 0.3f;
        float passesPercentage = criteria.getPassesPercentage() != null ? criteria.getPassesPercentage() / 100.0f : 0.5f;
        int teamSize = criteria.getTeamSize() != null ? criteria.getTeamSize() : 7;

        List<Player> eligiblePlayers = players.stream()
                .filter(player -> player.getStats() != null && player.getStats().size() >= 3)
                .toList();

        if (eligiblePlayers.size() < teamSize) {
            TeamSelectionResponse response = new TeamSelectionResponse();
            response.setErrorMessage("There is not enough information.");
            return ResponseEntity.badRequest().body(response);
        }

        List<PlayerScore> playerScores = eligiblePlayers.stream()
                .map(player -> {
                    try {
                        return new PlayerScore(player.getId(), player.getName(),
                                player.calculateTotalScore(player.getStats(), powerPercentage, speedPercentage, passesPercentage));
                    } catch (InvalidTrainingDataException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sorted(Comparator.comparingInt(PlayerScore::getScore).reversed())
                .limit(teamSize)
                .toList();

        TeamSelectionResponse response = new TeamSelectionResponse();
        response.setPlayerScores(playerScores);
        return ResponseEntity.ok(response);
    }
}
