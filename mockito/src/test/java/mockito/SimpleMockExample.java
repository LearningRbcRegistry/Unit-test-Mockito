package mockito;

import org.junit.Test;
import static org.mockito.Mockito.mock;

public class SimpleMockExample {



		@Test public void testSomething() {
			UserRepository userRepository = mock(UserRepository.class);
		}
	
}
