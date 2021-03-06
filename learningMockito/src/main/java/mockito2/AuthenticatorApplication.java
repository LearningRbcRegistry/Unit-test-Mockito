package mockito2;

public class AuthenticatorApplication {

    private AuthenticatorInterface authenticator;

    /**
     * AuthenticatorApplication constructor.
     *
     * @param authenticator Authenticator interface implementation.
     */
    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    /**
     * Tries to authenticate an user with the received user name and password, with the received
     * AuthenticatorInterface interface implementation in the constructor.
     *
     * @param username The user name to authenticate.
     * @param password The password to authenticate the user.
     * @return True if the user has been authenticated; false if it has not.
     */
    public boolean authenticate(String username, String password) {
        boolean authenticated;
        
        this.authenticator.foo();
        authenticated = this.authenticator.authenticateUser(username, password);
        
        return authenticated;
    }
    
    public boolean authenticate2(String username, String password) throws EmptyCredentialsException{
        boolean authenticated;
        this.authenticator.foo();
        authenticated = this.authenticator.authenticateWithException(username, password);
        return authenticated;
    }
    
    public void authenticateVoidUser(String username, String password) throws NotAuthenticatedException{
    	this.authenticator.authenticateVoidUser(username, password);
    }
    
}
