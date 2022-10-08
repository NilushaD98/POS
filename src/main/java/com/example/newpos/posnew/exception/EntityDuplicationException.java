package com.example.newpos.posnew.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class EntityDuplicationException extends  RuntimeException{

    public  EntityDuplicationException (String message){
        super(message);
    }
}

