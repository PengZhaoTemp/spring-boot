package com.example.zhaop.test.service.impl;
import com.example.zhaop.test.mapper.TestMapper;
import com.example.zhaop.test.service.TestService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testmapper;

    /**
     * 测试信息
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testInfo() {
        try{
            testmapper.inserto();
            ((TestServiceImpl)AopContext.currentProxy()).testInfot();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Map> searchTestInfo(String id) {
        Map map = new HashMap();
        map.put("id" , id);
        List<Map> list = testmapper.searchTestInfo(map);
        return list;
    }

    /**
     * 测试信息2
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void testInfot() {
        testmapper.insertt();
        System.out.println(1/0);
    }
}
