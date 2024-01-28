package kalexcamacho.mainTeamChallenge.model;

/**
 * Represents the statistics of a player during a training session.
 * This includes measurements of power, speed, and passes.
 */
public class Stats {

    private String power; //Newtons
    private Speed speed;
    private String passes;

    /**
     * Default constructor for creating an instance of Stats without any initial data.
     */
    public Stats() {
    }

    /**
     * Constructs a new Stats object with specified values for power, speed, and passes.
     *
     * @param power  The power exerted by the player, measured in Newtons.
     * @param speed  The speed of the player, encapsulated in a Speed object.
     * @param passes The number of passes made by the player.
     */
    public Stats(String power, Speed speed, String passes) {
        this.power = power;
        this.speed = speed;
        this.passes = passes;
    }

    /**
     * Retrieves the power exerted by the player.
     *
     * @return The power exerted, measured in Newtons.
     */
    public String getPower() {
        return power;
    }

    /**
     * Sets the power exerted by the player.
     *
     * @param power The power exerted, measured in Newtons.
     */
    public void setPower(String power) {
        this.power = power;
    }

    /**
     * Retrieves the speed of the player.
     *
     * @return The Speed object representing the player's speed.
     */
    public Speed getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the player.
     *
     * @param speed The Speed object representing the player's speed.
     */
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    /**
     * Retrieves the number of passes made by the player.
     *
     * @return The number of passes.
     */
    public String getPasses() {
        return passes;
    }

    /**
     * Sets the number of passes made by the player.
     *
     * @param passes The number of passes.
     */
    public void setPasses(String passes) {
        this.passes = passes;
    }
}
