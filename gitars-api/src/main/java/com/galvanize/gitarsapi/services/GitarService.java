package com.galvanize.gitarsapi.services;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.repositories.GitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GitarService {
    @Autowired
    private GitarRepository gitarRipository;

    public List<Gitar> getAllGitars(){ return gitarRipository.findAll(); }
    public Gitar getOneGitar(Long id){return gitarRipository.findById(id).get();}//.orElse(null) as get
    public Gitar createOneGitar(Gitar gitar){return gitarRipository.save(gitar);}
    public boolean deleteOneGitar(Long id){
        if (gitarRipository.findById(id).equals(null))
            return false;
        else {
            gitarRipository.deleteById(id);
            return true;
        }
    }
}
