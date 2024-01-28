package kalexcamacho.mainTeamChallenge.model;

public class Stats {

    private String power; //Newtons
    private Speed speed;
    private String passes;

    public Stats() {
    }

    public Stats(String power, Speed speed, String passes) {
        this.power = power;
        this.speed = speed;
        this.passes = passes;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public String getPasses() {
        return passes;
    }

    public void setPasses(String passes) {
        this.passes = passes;
    }
}
