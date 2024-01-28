package kalexcamacho.mainTeamChallenge.service;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import kalexcamacho.mainTeamChallenge.model.*;
import kalexcamacho.mainTeamChallenge.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TrainingServiceTest {
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private TrainingService trainingService;

    @BeforeEach
    public void setUp() {
        playerRepository = Mockito.mock(PlayerRepository.class);
        trainingService = new TrainingService(playerRepository);
    }

    @Test
    public void testAddTrainingData() throws InvalidTrainingDataException {
        Speed speed1 = new Speed("100", "10");

        Stats stats1 = new Stats();
        stats1.setPower("50");
        stats1.setSpeed(speed1);
        stats1.setPasses("10");

        Player demoPlayer = new Player();
        demoPlayer.setId(1);
        demoPlayer.setName("Existing Player");
        demoPlayer.setStats(new ArrayList<>());
        demoPlayer.getStats().add(stats1);

        TrainingData trainingData = new TrainingData();
        ArrayList<Player> players = new ArrayList<>();
        players.add(demoPlayer);
        trainingData.setPlayers(players);

        when(playerRepository.findById("1")).thenReturn(Optional.of(demoPlayer));

        trainingService.addTrainingData(trainingData);

        verify(playerRepository, times(1)).save(demoPlayer);

        assertEquals(1, demoPlayer.getStats().size());
    }

    @Test
    public void testAddTrainingData_PlayerDoesNotExist() throws InvalidTrainingDataException {
        Player nonExistingPlayer = new Player();
        nonExistingPlayer.setId(1);
        nonExistingPlayer.setName("Non Existing Player");
        nonExistingPlayer.setStats(new ArrayList<>());

        ArrayList<Player> fakeTrainingData = new ArrayList<>();
        fakeTrainingData.add(nonExistingPlayer);

        TrainingData trainingData = new TrainingData();
        trainingData.setPlayers(fakeTrainingData);

        when(playerRepository.findById("1")).thenReturn(Optional.empty());

        trainingService.addTrainingData(trainingData);

        ArgumentCaptor<Player> playerCaptor = ArgumentCaptor.forClass(Player.class);
        verify(playerRepository).save(playerCaptor.capture());

        Player savedPlayer = playerCaptor.getValue();
        assertNotNull(savedPlayer);
        assertEquals(1, savedPlayer.getId());
        assertEquals("Non Existing Player", savedPlayer.getName());
        assertEquals(0, savedPlayer.getStats().size());
    }

    @Test
    public void testAddNewStatsToExistingPlayer() throws InvalidTrainingDataException {
        Speed speed1 = new Speed("100", "10");

        Stats stats1 = new Stats();
        stats1.setPower("50");
        stats1.setSpeed(speed1);
        stats1.setPasses("10");

        Player demoPlayer = new Player();
        demoPlayer.setId(1);
        demoPlayer.setName("Existing Player");
        demoPlayer.setStats(new ArrayList<>());
        demoPlayer.getStats().add(stats1);

        Speed speed2 = new Speed("80", "7");

        Stats stats2 = new Stats();
        stats2.setPower("50");
        stats2.setSpeed(speed2);
        stats2.setPasses("10");

        Player demoPlayerWithNewStats = new Player();
        demoPlayerWithNewStats.setId(1);
        demoPlayerWithNewStats.setName("Existing Player");
        demoPlayerWithNewStats.setStats(new ArrayList<>());
        demoPlayerWithNewStats.getStats().add(stats2);

        ArrayList<Player> fakeTrainingData = new ArrayList<>();
        fakeTrainingData.add(demoPlayerWithNewStats);

        TrainingData trainingData = new TrainingData();
        trainingData.setPlayers(fakeTrainingData);

        when(playerRepository.findById("1")).thenReturn(Optional.of(demoPlayer));

        trainingService.addTrainingData(trainingData);

        verify(playerRepository, times(1)).save(demoPlayer);

        assertEquals(2, demoPlayer.getStats().size());
        assertTrue(demoPlayer.getStats().contains(stats2));
    }

    @Test
    void addTrainingData_ZeroTimeForSpeed_ThrowsException() {
        Speed speedWithTimeZero = new Speed("100", "0");
        Player player = new Player(1, "Jugador 1", List.of(new Stats("100",speedWithTimeZero,"10")));
        TrainingData trainingData = new TrainingData(List.of(player));

        when(playerRepository.findById(anyString())).thenReturn(Optional.empty());

        Speed speed = new Speed("100", "0");
        Stats stats = new Stats("70", speed, "60");
        player.setStats(Collections.singletonList(stats));

        assertThrows(InvalidTrainingDataException.class, () -> trainingService.addTrainingData(trainingData));
    }
}