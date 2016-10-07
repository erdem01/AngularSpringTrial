package erdemc.deneme.exception.error;

public class UserError {
	private int code;
	private String message;

	public UserError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
