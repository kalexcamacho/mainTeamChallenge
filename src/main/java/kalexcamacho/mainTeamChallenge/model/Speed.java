package kalexcamacho.mainTeamChallenge.model;

import kalexcamacho.mainTeamChallenge.exceptions.InvalidTrainingDataException;

public class Speed {
    private String distance;   // mts
    private String time;       // seg

    public Speed() {
    }
    public Speed(String distance, String time) {
        this.distance = distance;
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) throws InvalidTrainingDataException {
        if (Integer.parseInt(time) <= 0) {
            throw new InvalidTrainingDataException("Time must be greater than 0.");
        }
        this.time = time;
    }
    public float calculateSpeed() {
        if (Integer.parseInt(time) == 0) {
            throw new IllegalStateException("Cannot calculate speed when time is 0.");
        }
        return (float) Integer.parseInt(distance) / Integer.parseInt(time);
    }
}
