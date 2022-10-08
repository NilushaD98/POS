package com.example.newpos.posnew.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class EntriyNotFoundException extends RuntimeException{

    public EntriyNotFoundException (String message){
        super(message);
    }
}
