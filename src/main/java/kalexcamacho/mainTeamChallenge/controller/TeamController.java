package kalexcamacho.mainTeamChallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import kalexcamacho.mainTeamChallenge.model.TeamSelectionCriteria;
import kalexcamacho.mainTeamChallenge.model.TrainingData;
import kalexcamacho.mainTeamChallenge.service.TeamSelectionService;
import kalexcamacho.mainTeamChallenge.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main-team")
public class TeamController {

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
    private final TrainingService trainingService;
    private final TeamSelectionService teamSelectionService;

    @Autowired
    public TeamController(TrainingService trainingService, TeamSelectionService teamSelectionService) {
        this.trainingService = trainingService;
        this.teamSelectionService = teamSelectionService;
    }

    @PostMapping("/training")
    @Operation(summary = "Add training data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Training data added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid training data provided")
    })
    public ResponseEntity<?> addTrainingData(@RequestBody String data) {
        try {
            ObjectMapper om = new ObjectMapper();
            TrainingData auxData = om.readValue(data, TrainingData.class);
            trainingService.addTrainingData(auxData);
            return ResponseEntity.ok().build();

        } catch (InvalidTrainingDataException e) {
            logger.error("Invalid training data provided", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            logger.error("Error adding training data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/team")
    @Operation(summary = "Get team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to get team", content = @Content),
            @ApiResponse(responseCode = "400", description = "Not enough information available", content = @Content)
    })
    public ResponseEntity<?> getTeam(@RequestParam(required = false) Float powerPercentage,
                                     @RequestParam(required = false) Float speedPercentage,
                                     @RequestParam(required = false) Float passesPercentage,
                                     @RequestParam(required = false) Integer teamSize) {

        TeamSelectionCriteria criteria = new TeamSelectionCriteria();
        criteria.setPowerPercentage(powerPercentage);
        criteria.setSpeedPercentage(speedPercentage);
        criteria.setPassesPercentage(passesPercentage);
        criteria.setTeamSize(teamSize);

        return teamSelectionService.calculateMainTeam(criteria);
    }
}
