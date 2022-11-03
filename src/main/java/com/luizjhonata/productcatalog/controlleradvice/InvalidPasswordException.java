package com.luizjhonata.productcatalog.controlleradvice;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String msg) {
        super(msg);
    }

    public InvalidPasswordException(String msg, Throwable cause) {
        super(msg,cause);
    }

}
