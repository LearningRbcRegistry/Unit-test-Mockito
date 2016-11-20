package mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class VerificationExample {

	@Test public void testExample() {
		// mock
		NotificationService notificationService = mock(NotificationService.class);
		UserRepository userRepository = mock(UserRepository.class);
		UserBean user = mock(UserBean.class);
 
		// init
		AccountService service = new AccountService(userRepository, notificationService);
 
		// run
		service.removeUser(user);
 
		// verify
		verify(notificationService, times(1)).notifyUser(any(UserBean.class), anyString()); // verify
		// 1
		// invocation
		verify(userRepository).remove(any(UserBean.class)); // verify 1
		// invocation, short
		// syntax
 
		reset(notificationService); // reset the mocks
		reset(userRepository);
 
		verify(notificationService, never()).notifyUser(any(UserBean.class), anyString());
 
		service.removeUser(user);
		service.removeUser(user);
 
		verify(notificationService, times(2)).notifyUser(any(UserBean.class), anyString());
		verify(userRepository, atLeast(2)).remove(any(UserBean.class));
	}
	
}
