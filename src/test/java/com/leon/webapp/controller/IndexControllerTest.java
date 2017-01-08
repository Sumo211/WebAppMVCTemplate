package com.leon.webapp.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by ntcong on 12/29/2016.
 */
public class IndexControllerTest {

    @Test
    public void testIndexPage() throws Exception {
        IndexController indexController = new IndexController();
        MockMvc mockMvc = standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
               .andExpect(view().name("index"));
    }

}
