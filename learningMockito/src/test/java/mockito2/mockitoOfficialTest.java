package mockito2;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
public class mockitoOfficialTest {
	
	@Test
	public void firstTest()
	{
		
		 //mock creation
		 List mockedList = mock(List.class);

		 //using mock object
		 mockedList.add("one");
		 mockedList.clear();

		 //verification
		 verify(mockedList).add("one");
		 verify(mockedList).clear();
		
	}

}
