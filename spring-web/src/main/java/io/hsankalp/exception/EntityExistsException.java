package io.hsankalp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Entity Already Exists")
public class EntityExistsException extends Exception {
	private static final long serialVersionUID = -1392360064988589291L;
}
