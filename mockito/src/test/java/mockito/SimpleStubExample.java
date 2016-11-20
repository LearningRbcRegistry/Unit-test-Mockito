package mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import junit.framework.Assert;

public class SimpleStubExample {
	
	@Test(expected = RuntimeException.class) public void testSomething() {
		UserRepository userRepository = mock(UserRepository.class);
		when(userRepository.findAll()).thenReturn(null);
		doThrow(new RuntimeException()).when(userRepository).save(any(UserBean.class));
		Assert.assertNull(userRepository.findAll());
		userRepository.save(null);
	}

}
