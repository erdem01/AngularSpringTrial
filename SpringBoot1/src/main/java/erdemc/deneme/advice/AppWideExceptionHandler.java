package erdemc.deneme.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import erdemc.deneme.exception.UserNotFoundException;
import erdemc.deneme.exception.error.UserError;

@ControllerAdvice
public class AppWideExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ResponseBody
	public UserError handleUserException(UserNotFoundException e) {
		String userCode = e.getUserCode();
		return new UserError(4, "User [" + userCode + "] not found");
	}
	
}
