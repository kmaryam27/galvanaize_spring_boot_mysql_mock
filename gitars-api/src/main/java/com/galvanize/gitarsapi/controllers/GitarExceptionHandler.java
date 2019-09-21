package com.galvanize.gitarsapi.controllers;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.exception.GitarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class GitarExceptionHandler {
//    @ExceptionHandler(value = {GitarNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<VndErrors> notFoundException(GitarNotFoundException e, WebRequest request) {
//        VndErrors error = new VndErrors(request.toString(), "Not found : " + e.getMessage());
//        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }

}
