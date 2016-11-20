package mockito;

import java.util.Calendar;

public interface UserBean {

	  String getName();
	  String setName();
	  Calendar getLastLogin();
	  void setLastLogin(Calendar lastLogin);
	  boolean isActive();
	  void setActive(boolean active);
	
}
