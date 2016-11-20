package mockito2;

public interface AuthenticatorInterface {

    /**
     * User authentication method definition.
     *
     * @param username The user name to authenticate.
     * @param password The password to authenticate the user.
     * @return True if the user has been authenticated; false if it has not.
     * @throws EmptyCredentialsException If the received credentials (user name, password) are
     * empty.
     */
    public boolean authenticateUser(String username, String password);
    public boolean authenticateWithException(String username, String password) throws EmptyCredentialsException;
    public void foo();
    public void authenticateVoidUser(String username, String passwor) throws NotAuthenticatedException;
}