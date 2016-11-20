package mockito;

public class AccountService {

	private final UserRepository        userRepository;
	private final NotificationService    notificationService;
 
	public AccountService(final UserRepository userRepository, final NotificationService notificationService) {
		this.userRepository = userRepository;
		this.notificationService = notificationService;
	}
 
	public void removeUser(final UserBean user) {
		notificationService.notifyUser(user, getUserDeletionMessage(user));
		userRepository.remove(user);
	}
 
	private String getUserDeletionMessage(final UserBean user) {
		return String.format("Dear administrator,\n the following user account has been deleted: %s", user.getName());
	}
	
}
