package erdemc.deneme.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userCode;

	public UserNotFoundException(String userCode) {
		super("No user found for code: " + userCode);
		this.userCode = userCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}
