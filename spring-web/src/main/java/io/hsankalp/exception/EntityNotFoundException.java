package io.hsankalp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Entity Not Found")
public class EntityNotFoundException extends Exception{
	private static final long serialVersionUID = 7596065111800488412L;
}
