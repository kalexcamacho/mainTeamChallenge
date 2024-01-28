package kalexcamacho.mainTeamChallenge.repository;

import kalexcamacho.mainTeamChallenge.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
}
