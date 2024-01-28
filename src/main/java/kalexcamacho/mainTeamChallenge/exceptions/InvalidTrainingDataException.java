package kalexcamacho.mainTeamChallenge.exceptions;

/**
 * Custom exception class for handling invalid training data scenarios.
 */
public class InvalidTrainingDataException extends Exception {

    /**
     * Constructs a new InvalidTrainingDataException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidTrainingDataException(String message) {
        super(message);
    }

}
