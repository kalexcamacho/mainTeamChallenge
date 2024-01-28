package kalexcamacho.mainTeamChallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import kalexcamacho.mainTeamChallenge.model.*;
import kalexcamacho.mainTeamChallenge.repository.PlayerRepository;
import kalexcamacho.mainTeamChallenge.service.TeamSelectionService;
import kalexcamacho.mainTeamChallenge.service.TrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class TeamControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TrainingService trainingService;

    @Mock
    private TeamSelectionService teamSelectionService;

    @InjectMocks
    private TeamController teamController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void addTrainingData_Success() throws Exception {
        TrainingData trainingData = new TrainingData();
        String jsonTrainingData = objectMapper.writeValueAsString(trainingData);

        mockMvc.perform(post("/main-team/training")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonTrainingData))
                .andExpect(status().isOk());

        verify(trainingService, times(1)).addTrainingData(any(TrainingData.class));
    }

    @Test
    void addTrainingData_InvalidDataException() throws Exception {
        TrainingData trainingData = new TrainingData();
        String jsonTrainingData = objectMapper.writeValueAsString(trainingData);

        doThrow(new InvalidTrainingDataException("Invalid Data"))
                .when(trainingService).addTrainingData(any(TrainingData.class));

        mockMvc.perform(post("/main-team/training")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonTrainingData))
                .andExpect(status().isBadRequest());

        verify(trainingService, times(1)).addTrainingData(any(TrainingData.class));
    }

    @Test
    void addTrainingData_GenericException() throws Exception {
        TrainingData trainingData = new TrainingData();
        String jsonTrainingData = objectMapper.writeValueAsString(trainingData);

        doThrow(RuntimeException.class)
                .when(trainingService).addTrainingData(any(TrainingData.class));

        mockMvc.perform(post("/main-team/training")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonTrainingData))
                .andExpect(status().isInternalServerError());

        verify(trainingService, times(1)).addTrainingData(any(TrainingData.class));
    }

    @Test
    void getTeam_Successful() throws Exception {
        when(teamSelectionService.calculateMainTeam(any(TeamSelectionCriteria.class)))
                .thenReturn(new ResponseEntity<>(new TeamSelectionResponse(), HttpStatus.OK));

        mockMvc.perform(get("/main-team/team")
                        .param("powerPercentage", "20")
                        .param("speedPercentage", "30")
                        .param("passesPercentage", "50")
                        .param("teamSize", "5"))
                .andExpect(status().isOk());
    }

    @Test
    void getTeam_NotEnoughInformation() throws Exception {
        when(teamSelectionService.calculateMainTeam(any(TeamSelectionCriteria.class)))
                .thenReturn(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

        mockMvc.perform(get("/main-team/team")
                        .param("teamSize", "11"))
                .andExpect(status().isBadRequest());
    }
}