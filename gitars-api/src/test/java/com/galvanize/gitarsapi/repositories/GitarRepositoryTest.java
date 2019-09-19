package com.galvanize.gitarsapi.repositories;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.services.GitarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class GitarRepositoryTest {

    @Autowired
    private GitarRepository gitarRipository;
    @Autowired
    private GitarService gitarService;


    List<Gitar> gitarList = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Gitar> myList = gitarRipository.findAll();

        myList.stream()
                .forEach(gitar -> gitarRipository.deleteById(gitar.getId()));


        for (int i=0; i< 10; i++){
            Gitar gitar = new Gitar("model"+i,"brand"+i,i*2);
            gitarList.add(gitar);
        }
        gitarRipository.saveAll(gitarList);
    }

    @Test
    public void getAllGitars() {
        List<Gitar> gitars = gitarService.getAllGitars();
        assertEquals(gitarList.size(),gitars.size());
        assertEquals(10,gitars.size());
        assertNotNull(gitars);
    }
}