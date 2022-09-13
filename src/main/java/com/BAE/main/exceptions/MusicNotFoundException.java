package com.BAE.main.exceptions;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Music doesn't exist with that ID")
public class MusicNotFoundException extends EntityNotFoundException {
	

}
