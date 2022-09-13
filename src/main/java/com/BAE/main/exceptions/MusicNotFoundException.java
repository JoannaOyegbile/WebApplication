package com.BAE.main.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MusicNotFoundException extends EntityNotFoundException {
	

}
