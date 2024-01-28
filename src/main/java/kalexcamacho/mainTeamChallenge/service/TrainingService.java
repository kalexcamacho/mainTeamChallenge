package kalexcamacho.mainTeamChallenge.service;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import kalexcamacho.mainTeamChallenge.model.Player;
import kalexcamacho.mainTeamChallenge.model.Stats;
import kalexcamacho.mainTeamChallenge.model.TrainingData;
import kalexcamacho.mainTeamChallenge.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService {

    private final PlayerRepository playerRepository;

    /**
     * Constructs a new TrainingService with the provided PlayerRepository.
     *
     * @param playerRepository The repository used for accessing player data.
     */
    public TrainingService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Adds training data to the system.
     * This method adds training data for each player provided in the training data list.
     *
     * @param trainingData The training data containing information about players and their stats.
     * @throws InvalidTrainingDataException If the training data is invalid or contains errors.
     */
    public void addTrainingData (TrainingData trainingData) throws InvalidTrainingDataException {
        for (Player playerData : trainingData.getPlayers()) {
            Player player = playerRepository.findById(String.valueOf(playerData.getId())).orElse(null);

            if (player == null) {
                player = new Player();
                player.setId(playerData.getId());
                player.setName(playerData.getName());
                player.setStats(new ArrayList<>());
            }

            List<Stats> existingStats = player.getStats();
            List<Stats> newStats = playerData.getStats();

            for (Stats stats : newStats) {
                if (!existingStats.contains(stats)) {
                    if (stats.getSpeed() != null && Integer.parseInt(stats.getSpeed().getTime()) <= 0) {
                        throw new InvalidTrainingDataException("Time for speed must be greater than 0.");
                    }
                    existingStats.add(stats);
                }
            }

            playerRepository.save(player);
        }
    }
}

