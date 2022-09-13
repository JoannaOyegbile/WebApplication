package com.BAE.main.exceptions;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Music doesn't exist with that ID")
public class MusicNotFoundException extends EntityNotFoundException{
	
}
=======
@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Music doesn't exist with that ID")
public class MusicNotFoundException extends EntityNotFoundException {
	

}
>>>>>>> 644c8fce6eb4617b80370419f4205a0aa75f6c67
