package use_case.loggedIn;

/**
 * The LoginInputData class represents the input data for the user login process.
 * It holds information such as the username and password.
 */
public record LoggedInInputData(String username) {

    /**
     * Constructs a LoginInputData object with the provided username and password.
     *
     * @param username The username for the login attempt.
     */
    public LoggedInInputData {
    }

    /**
     * Gets the username.
     *
     * @return The username for the login attempt.
     */
    @Override
    public String username() {
        return username;
    }

}
