package com.galvanize.gitarsapi.controllers;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.services.GitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/")
public class GitarController {
    @Autowired
    private GitarService gitarService;

    @GetMapping
    public String getAllGitars(){
        List<Gitar> list = gitarService.getAllGitars();
        return (list.size() + "");
    }

    @GetMapping(value="/{id}")
    public String getGitarById(@PathVariable String id){

        return "null";
    }
}
