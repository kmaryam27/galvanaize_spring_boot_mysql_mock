package com.galvanize.gitarsapi.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    private ObjectMapper mapper = new ObjectMapper();
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

    @Test
    public void createGitar() throws Exception {
        mockMvc.perform(post("/gitars").contentType(MediaType.APPLICATION_JSON)
                .content("{\"model\":\"Model200\",\"brand\":\"Brand200\",\"springs\":200}"))
                .andExpect(status().isOk())
        .andExpect(jsonPath("id").exists());

    }

    @Test
    public void updateGitar() throws Exception {

        Gitar gitar = new Gitar();
        gitar.setModel("modelBefore");
        gitar.setBrand("brandBefore");
        gitar.setStrings(20);
        gitar = gitarService.createOneGitar(gitar);

        String inputJson = mapper.writeValueAsString(gitar);
        String outputJson = mapper.writeValueAsString(gitar);

        this.mockMvc.perform(put("/gitars/" + gitar.getId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
