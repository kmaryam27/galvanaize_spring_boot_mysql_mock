package com.galvanize.gitarsapi.repositories;

import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.services.GitarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class GitarRepositoryServiceTest {

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
        for (Gitar g: gitars){
            assertNotNull(g);
        }
    }

    @Test
    public void addGetDeleteOneGitar() {
        //*******Create
        Gitar gitar = new Gitar();
        gitar.setBrand("testbrand");
        gitar.setStrings(27);
        gitar.setModel("modeltest");

        gitar = gitarService.createOneGitar(gitar);
        assertNotNull(gitar);
        //*************getOne
        Gitar gitar1 = gitarService.getOneGitar(gitar.getId());
        assertEquals(gitar, gitar1);
        assertNotNull(gitar1);
        //************deleteOne
        gitarService.deleteOneGitar(gitar.getId());
        Optional<Gitar> myGitar = gitarRipository.findById(gitar.getId());
        assertFalse(myGitar.isPresent());
    }




}