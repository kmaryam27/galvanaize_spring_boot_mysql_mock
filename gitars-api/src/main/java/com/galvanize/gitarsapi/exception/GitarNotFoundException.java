package com.galvanize.gitarsapi.exception;

public class GitarNotFoundException extends RuntimeException {
    public GitarNotFoundException(String msg){
        super(msg);
    }
}
