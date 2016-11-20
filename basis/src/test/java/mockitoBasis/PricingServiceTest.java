package mockitoBasis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.mockito.MockitoAnnotations;

import junit.framework.Assert;


public class PricingServiceTest {

	 private static final String SKU = "3283947";
	      private static final String BAD_SKU = "-9999993434";
	      private PricingService systemUnderTest;
	 
	      @MockitoAnnotations.Mock
	      private DataAccess mockedDependency;
	  
	      @Before
	      public void doBeforeEachTestCase() {
	          MockitoAnnotations.initMocks(this);
	          systemUnderTest = new PricingServiceImpl();
	          systemUnderTest.setDataAccess(mockedDependency);
	      }
	  
	      @Test
	      public void getPrice() throws SkuNotFoundException {
	          stub(mockedDependency.getPriceBySku(SKU)).toReturn(new BigDecimal(100));
	          final BigDecimal price = systemUnderTest.getPrice(SKU);
	          // Verify state
	          assertNotNull(price);
	          assertEquals(price,new BigDecimal(101));
	  
	          // Verify behavior
	          verify(mockedDependency).getPriceBySku(SKU);
	      }
	  
	      @Test(expected = SkuNotFoundException.class)
	      public void getPriceNonExistentSkuThrowsException() throws SkuNotFoundException {
	         stub(mockedDependency.getPriceBySku(BAD_SKU)).toReturn(null);
	          final BigDecimal price = systemUnderTest.getPrice(BAD_SKU);
	      }
	  
	      @Test(expected = RuntimeException.class)
	      public void getPriceDataAccessThrowsRuntimeException() throws SkuNotFoundException {
	          stub(mockedDependency.getPriceBySku(SKU)).toThrow(new RuntimeException("Fatal data access exception."));
	          final BigDecimal price = systemUnderTest.getPrice(SKU);
	      }
	}
