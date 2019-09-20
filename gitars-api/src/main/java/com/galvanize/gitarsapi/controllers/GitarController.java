package com.galvanize.gitarsapi.controllers;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.services.GitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/gitars")
public class GitarController {
    @Autowired
    private GitarService gitarService;


    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
    public List<Gitar> getAll(){
        return gitarService.getAllGitars();
    }

    @GetMapping(value="/{id}")
    public String getGitarById(@PathVariable String id){

        return "null";
    }
}
