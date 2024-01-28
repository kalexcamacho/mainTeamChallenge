package kalexcamacho.mainTeamChallenge.repository;

import kalexcamacho.mainTeamChallenge.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on Player entities.
 * Extends Spring Data MongoDB's MongoRepository interface.
 */
@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
}
