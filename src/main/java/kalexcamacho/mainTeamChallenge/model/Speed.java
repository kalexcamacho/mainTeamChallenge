package kalexcamacho.mainTeamChallenge.model;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;

/**
 * Represents the speed of a player in a training session.
 * Speed is defined by the distance covered and the time taken to cover that distance.
 */
public class Speed {
    private String distance;   // mts
    private String time;       // seg

    /**
     * Default constructor for creating an instance of Speed without any initial data.
     */
    public Speed() {
    }

    /**
     * Constructs a new Speed with the specified distance and time.
     *
     * @param distance The distance covered.
     * @param time     The time taken to cover the distance.
     */
    public Speed(String distance, String time) {
        this.distance = distance;
        this.time = time;
    }

    /**
     * Retrieves the distance covered.
     *
     * @return The distance covered.
     */
    public String getDistance() {
        return distance;
    }

    /**
     * Sets the distance covered.
     *
     * @param distance The distance covered.
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     * Retrieves the time taken to cover the distance.
     *
     * @return The time taken to cover the distance.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time taken to cover the distance.
     * Throws an InvalidTrainingDataException if the time is less than or equal to 0.
     *
     * @param time The time taken to cover the distance.
     * @throws InvalidTrainingDataException If the time is less than or equal to 0.
     */
    public void setTime(String time) throws InvalidTrainingDataException {
        if (Integer.parseInt(time) <= 0) {
            throw new InvalidTrainingDataException("Time must be greater than 0.");
        }
        this.time = time;
    }

    /**
     * Calculates the speed based on the distance and time.
     * Throws an IllegalStateException if the time is 0.
     *
     * @return The calculated speed.
     * @throws InvalidTrainingDataException If the time is 0.
     */
    public float calculateSpeed() throws InvalidTrainingDataException {
        if (Integer.parseInt(time) == 0) {
            throw new InvalidTrainingDataException("Cannot calculate speed when time is 0.");
        }
        return (float) Integer.parseInt(distance) / Integer.parseInt(time);
    }
}
