package kalexcamacho.mainTeamChallenge.service;

import kalexcamacho.mainTeamChallenge.model.*;
import kalexcamacho.mainTeamChallenge.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class TeamSelectionServiceTest {

    private PlayerRepository playerRepository;
    private TeamSelectionService teamSelectionService;

    @BeforeEach
    public void setUp() {
        playerRepository = Mockito.mock(PlayerRepository.class);
        teamSelectionService = new TeamSelectionService(playerRepository);
    }

    @Test
    public void calculateMainTeam_EnoughPlayers_WithoutCriteriaValues() {
        List<Player> players = List.of(
                new Player(1, "Player 1", List.of(new Stats("70", new Speed("100", "10"), "60"), new Stats("65", new Speed("100", "10"), "65"), new Stats("72", new Speed("100", "10"), "70"))),
                new Player(2, "Player 2", List.of(new Stats("80", new Speed("200", "15"), "55"), new Stats("85", new Speed("200", "15"), "60"), new Stats("78", new Speed("200", "15"), "65"))));
        when(playerRepository.findAll()).thenReturn(players);

        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setTeamSize(2);

        ResponseEntity<TeamSelectionResponse> response = teamSelectionService.calculateMainTeam(criteria);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().getPlayerScores().size());
    }

    @Test
    public void calculateMainTeam_withCriteriaValidValues() {
        List<Player> players = List.of(
                new Player(1, "Player 1", List.of(new Stats("70", new Speed("100", "10"), "60"), new Stats("65", new Speed("100", "10"), "65"), new Stats("72", new Speed("100", "10"), "70"))),
                new Player(2, "Player 2", List.of(new Stats("80", new Speed("200", "15"), "55"), new Stats("85", new Speed("200", "15"), "60"), new Stats("78", new Speed("200", "15"), "65"))));
        when(playerRepository.findAll()).thenReturn(players);

        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setTeamSize(2);
        criteria.setPassesPercentage(0.2f);
        criteria.setPowerPercentage(0.3f);
        criteria.setSpeedPercentage(0.5f);

        ResponseEntity<TeamSelectionResponse> response = teamSelectionService.calculateMainTeam(criteria);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().getPlayerScores().size());
    }

    @Test
    public void calculateMainTeam_withCriteriaInvalidValues() {
        List<Player> players = List.of(
                new Player(1, "Player 1", List.of(new Stats("70", new Speed("100", "10"), "60"), new Stats("65", new Speed("100", "10"), "65"), new Stats("72", new Speed("100", "10"), "70"))),
                new Player(2, "Player 2", List.of(new Stats("80", new Speed("200", "15"), "55"), new Stats("85", new Speed("200", "15"), "60"), new Stats("78", new Speed("200", "15"), "65"))));
        when(playerRepository.findAll()).thenReturn(players);

        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setTeamSize(2);
        criteria.setPassesPercentage(null);
        criteria.setPowerPercentage(null);
        criteria.setSpeedPercentage(null);

        ResponseEntity<TeamSelectionResponse> response = teamSelectionService.calculateMainTeam(criteria);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().getPlayerScores().size());
    }

    @Test
    public void calculateMainTeam_NotEnoughPlayers() {
        List<Player> players = List.of(
                new Player(1, "Player 1", List.of(new Stats(), new Stats())));
        when(playerRepository.findAll()).thenReturn(players);

        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setTeamSize(2);

        ResponseEntity<TeamSelectionResponse> response = teamSelectionService.calculateMainTeam(criteria);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("There is not enough information.", response.getBody().getErrorMessage());
    }
}
