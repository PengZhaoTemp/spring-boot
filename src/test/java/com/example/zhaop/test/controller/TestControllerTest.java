package com.example.zhaop.test.controller;
import com.example.zhaop.ZhaopApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ZhaopApplication.class})
@AutoConfigureMockMvc
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTest() {
        //    MvcResult mvcResult = mockMvc.perform(
        //            post("/test/info")
        //            .contentType(MediaType.APPLICATION_JSON))
        //            .andReturn();
        //    System.out.println("------->>> " + mvcResult.getResponse().getContentAsString());
        //    System.out.println("+++++++>>> " + mvcResult.getResponse().getStatus());

        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/test/info")
                    .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print()).andReturn();
            System.out.println("------->>> " + mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}