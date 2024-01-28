package kalexcamacho.mainTeamChallenge.model;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpeedTest {

    @Test
    void testGetDistance() {
        String distance = "100";
        String time = "10";
        Speed speed = new Speed(distance, time);

        String retrievedDistance = speed.getDistance();

        assertEquals(distance, retrievedDistance);
    }

    @Test
    void testSetDistance() {
        String distance = "100";
        String time = "10";
        Speed speed = new Speed();

        speed.setDistance(distance);

        assertEquals(distance, speed.getDistance());
    }

    @Test
    void testGetTime() {
        String distance = "100";
        String time = "10";
        Speed speed = new Speed(distance, time);

        String retrievedTime = speed.getTime();

        assertEquals(time, retrievedTime);
    }

    @Test
    void setTime_ValidTime_SetsTime() throws InvalidTrainingDataException {
        String validTime = "10";
        Speed speed = new Speed();

        speed.setTime(validTime);

        assertEquals(validTime, speed.getTime());
    }

    @Test
    void testSetTime_InvalidValue_ThrowsInvalidTrainingDataException() {
        Speed speed = new Speed();
        Exception exception = assertThrows(InvalidTrainingDataException.class, () -> {
            speed.setTime("0");
        });
        String expectedMessage = "Time must be greater than 0.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testSetTime_TimeLessThanZero_ThrowsInvalidTrainingDataException() {
        String invalidTime = "-10";
        Speed speed = new Speed();

        InvalidTrainingDataException exception = assertThrows(InvalidTrainingDataException.class, () -> {
            speed.setTime(invalidTime);
        });

        assertEquals("Time must be greater than 0.", exception.getMessage());
    }

    @Test
    void testCalculateSpeed() {
        Speed speed = new Speed("200", "20");
        assertEquals(10.0, speed.calculateSpeed());
    }

    @Test
    void testCalculateSpeedWithZeroTime() {
        Speed speed = new Speed("200", "0");
        assertThrows(IllegalStateException.class, speed::calculateSpeed);
    }
}
