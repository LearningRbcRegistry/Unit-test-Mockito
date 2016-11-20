package mockito2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;

public class AuthenticatorApplicationTest {

	@Mock
	private AuthenticatorInterface authenticatorMock;
	
	@InjectMocks
	private AuthenticatorApplication authenticator;

    @Test
    public void testAuthenticate() {
       // AuthenticatorInterface authenticatorMock;
       // AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password = "unsafePassword";
        
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        
        when(authenticatorMock.authenticateUser(username, password))
            .thenReturn(false)
            .thenReturn(true);
        
        boolean actual = authenticator.authenticate(username, password);
        assertFalse(actual);
        
        verify(authenticatorMock).authenticateUser(username, password);
        verify(authenticatorMock, times(1)).authenticateUser(username, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);
        
        InOrder inOrder = inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).foo();
        inOrder.verify(authenticatorMock).authenticateUser(username, password); // This will make the test fail!
       
        verify(authenticatorMock, timeout(100)).authenticateUser(username, password);
      
        boolean actual2 = authenticator.authenticate(username, password);
        assertTrue(actual2);
      
        
    }

    @Test (expected = EmptyCredentialsException.class)
    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
      //     AuthenticatorInterface authenticatorMock;
      //     AuthenticatorApplication authenticator;
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
      //       We do not need them because they are declared as class dependencies with @Mock
        when(authenticatorMock.authenticateWithException("", ""))
            .thenThrow(new EmptyCredentialsException());
        
        authenticator.authenticate("","");
    }
    
    @Test(expected = NotAuthenticatedException.class)
    public void testVoidAuthenticate() throws NotAuthenticatedException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password = "wrong password";
        
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        
        doThrow(new NotAuthenticatedException()).when(authenticatorMock).authenticateVoidUser(username, password);
        
        authenticator.authenticateVoidUser(username, password);
        
    }
        
    @Test
    public void spyExampleTest() {
        Map<String, String> hashMap = new HashMap<String, String>();
        Map<String, String> hashMapSpy = spy(hashMap);
        hashMap.put("hashmapKey","hashmapValue");
        System.out.println(hashMapSpy.get("key")); // Will print null.
        
        hashMapSpy.put("key", "A value");
        System.out.println(hashMapSpy.get("key")); // Will print "A value".
        
        when(hashMapSpy.get("key")).thenReturn("Another value");
        System.out.println(hashMapSpy.get("key")); // Will print "Another value".
    }
    
    
    
}
