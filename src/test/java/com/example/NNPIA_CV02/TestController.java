package com.example.NNPIA_CV02;


import com.example.NNPIA_CV02.DAO.AppUser;
import com.example.NNPIA_CV02.controller.AppUserController;
import com.example.NNPIA_CV02.repository.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@Import(AppUserController.class)
@WebMvcTest(AppUserController.class)
public class TestController {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    public Repository repository;


    @Test
    @WithMockUser(username = "user", password = "password")
    public void getAppUserById() throws Exception {
        AppUser testAppUser = new AppUser();
        testAppUser.setId(1);
        given(repository.findAppUserById(testAppUser.getId())).willReturn(testAppUser);
        mockMvc.perform(get("/app-user/" + testAppUser.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(testAppUser.getId())));
    }

    @Test
    @WithMockUser(username = "user", password = "password")
    public void addAppUser() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setUsername("TestAddAppUser");

        given(repository.save(any(AppUser.class))).willReturn(appUser);

        mockMvc.perform(post("/app-user-add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(appUser))
                        .with(csrf()))
                .andExpect(status().isOk());
    }

    @BeforeEach
    void setUp() {

    }

}
