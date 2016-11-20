package mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SimpleMockExampleWithAnnotations {

	@Mock private UserRepository    userRepository;
	 
	@Before public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
 
	@Test public void testSomething() {
		// ...
	}
	
}
