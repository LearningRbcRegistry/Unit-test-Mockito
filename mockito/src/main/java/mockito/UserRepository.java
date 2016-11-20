package mockito;

import java.util.List;

public interface UserRepository {

	  List<UserBean> findAll();
	  void save(final UserBean user);
	  void remove(final UserBean user);
	
}
