package com.galvanize.gitarsapi.controllers;
import com.galvanize.gitarsapi.entities.Gitar;
import com.galvanize.gitarsapi.repositories.GitarRepository;
import com.galvanize.gitarsapi.services.GitarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Transactional
//@WebMvcTest(GitarController.class)
public class GitarControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    GitarService gitarService;
    @Autowired
    GitarRepository gitarRipository;



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
    public void getAll() throws Exception {

        this.mockMvc.perform(get("/gitars"))
                .andExpect(status().isOk());
    }

}