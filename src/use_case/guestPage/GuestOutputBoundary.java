package use_case.guestPage;

/**
 * The LoginOutputBoundary interface defines methods for presenting the output of the login use case.
 * It includes operations for preparing views in case of successful and failed login attempts.
 */
public interface GuestOutputBoundary {

    /**
     * Prepare the view for a successful login attempt.
     *
     * @param guestOutputData The output data containing user information.
     */
    void prepareSuccessView(GuestOutputData guestOutputData);

    /**
     * Prepare the view for a failed login attempt.
     *
     * @param errorMessage The error message to be displayed.
     */
    void prepareFailView(String errorMessage);

    void switchPageLogOut();

    void switchPageSearch(String username);
}