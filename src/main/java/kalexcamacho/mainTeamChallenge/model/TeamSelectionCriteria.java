package kalexcamacho.mainTeamChallenge.model;

/**
 * Represents the criteria used for selecting a team based on various factors such as power, speed, passes, and team size.
 */
public class TeamSelectionCriteria {
    private Float powerPercentage;
    private Float speedPercentage;
    private Float passesPercentage;
    private Integer teamSize;

    /**
     * Default constructor for creating an instance of TeamSelectionCriteria without any initial data.
     */
    public TeamSelectionCriteria() {
    }

    /**
     * Retrieves the percentage weight assigned to power.
     *
     * @return The percentage weight assigned to power.
     */
    public Float getPowerPercentage() {
        return powerPercentage;
    }

    /**
     * Sets the percentage weight assigned to power.
     *
     * @param powerPercentage The percentage weight assigned to power.
     */
    public void setPowerPercentage(Float powerPercentage) {
        this.powerPercentage = powerPercentage;
    }

    /**
     * Retrieves the percentage weight assigned to speed.
     *
     * @return The percentage weight assigned to speed.
     */
    public Float getSpeedPercentage() {
        return speedPercentage;
    }

    /**
     * Sets the percentage weight assigned to speed.
     *
     * @param speedPercentage The percentage weight assigned to speed.
     */
    public void setSpeedPercentage(Float speedPercentage) {
        this.speedPercentage = speedPercentage;
    }

    /**
     * Retrieves the percentage weight assigned to passes.
     *
     * @return The percentage weight assigned to passes.
     */
    public Float getPassesPercentage() {
        return passesPercentage;
    }

    /**
     * Sets the percentage weight assigned to passes.
     *
     * @param passesPercentage The percentage weight assigned to passes.
     */
    public void setPassesPercentage(Float passesPercentage) {
        this.passesPercentage = passesPercentage;
    }

    /**
     * Retrieves the size of the team.
     *
     * @return The size of the team.
     */
    public Integer getTeamSize() {
        return teamSize;
    }

    /**
     * Sets the size of the team.
     *
     * @param teamSize The size of the team.
     */
    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }
}
