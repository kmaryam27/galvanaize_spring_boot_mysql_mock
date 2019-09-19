package com.galvanize.gitarsapi.services;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.repositories.GitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitarService {
    @Autowired
    private GitarRepository gitarRipository;

    public List<Gitar> getAllGitars(){
        return gitarRipository.findAll();
    }
}
