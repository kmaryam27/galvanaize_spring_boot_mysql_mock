package com.galvanize.gitarsapi.controllers;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.services.GitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/gitars")
public class GitarController {
    @Autowired
    private GitarService gitarService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Gitar createGitar(@RequestBody @Valid Gitar gitar){
        return gitarService.createOneGitar(gitar);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Gitar> getAll(){
        return gitarService.getAllGitars();
    }

//    @GetMapping(value="/{id}")
//    public String getGitarById(@PathVariable String id){
//
//        return "null";
//    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Gitar updateGitar(@RequestBody @Valid Gitar gitar, @PathVariable Long id){
        if(gitarService.getOneGitar(id) != null) {
            // If no ID is provided in the body, set the id to the one in the parameter
            // Without an ID, repo.save() would create a new record in the db
            gitarService.deleteOneGitar(id);
            if( gitar.getId() == null) {
                gitar.setId(id);
            }
           return gitarService.createOneGitar(gitar);
        }else throw new IllegalArgumentException("The selected item is not exist to update it");//RsvpNotFoundException("There is no RSVP with id " + id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGitar(@PathVariable Long id) {
        gitarService.deleteOneGitar(id);
    }

}
