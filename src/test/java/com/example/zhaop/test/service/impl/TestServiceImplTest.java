package com.example.zhaop.test.service.impl;

import com.example.zhaop.ZhaopApplication;
import com.example.zhaop.test.service.TestService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ZhaopApplication.class})
public class TestServiceImplTest {

    @Autowired
    private TestService testservice;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void searchTestInfo() {
        List<Map> list = testservice.searchTestInfo("1");
        if (list != null) {
            for (Map map : list) {
                for (Object str : map.keySet()) {
                    System.out.println("key---------->>> " + str + "------>>>value---->>> " + map.get(str));
                }
            }

        }
    }
}