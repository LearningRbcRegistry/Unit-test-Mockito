package mockitoBasis;

import java.math.BigDecimal;

public interface DataAccess {
	BigDecimal getPriceBySku(String sku);
}
