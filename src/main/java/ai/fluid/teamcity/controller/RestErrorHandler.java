package ai.fluid.teamcity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestErrorHandler {

	@ExceptionHandler(GenericException.class)
	@ResponseBody
	public ResponseEntity<GenericException> handleAllExceptions(GenericException e) {
		if (e.getHttpCode() == 500) {
			return new ResponseEntity<GenericException>(e, null, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (e.getHttpCode() == 400) {
			return new ResponseEntity<GenericException>(e, null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<GenericException>(e, null, HttpStatus.BAD_GATEWAY);
		}
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<String> handleAllExceptions(Exception e) {

		return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
