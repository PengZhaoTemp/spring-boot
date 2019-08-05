package com.example.zhaop;

import com.example.zhaop.utils.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhaopApplicationTests {

    @Autowired
    private RedisUtil redisutil;


    @Test
    public void contextLoads() {

        /*
            =================Map================
            Map map = new HashMap();
            map.put("a" , "1");
            map.put("b" , "2");
            map.put("c" , "3");
            map.put("d" , "4");
            redisutil.hmset("map" , map , 60);
            double dd = redisutil.hincr("map" , "b" , 3d );
            System.out.println(dd);
        */

        /*=================Set==================*/
        /*
        * HashSet 实现自Set接口
        * HashSet 无序集合
        * TreeSet 有序集合
        * LinkeHashSet
        redisutil.sSetAndTime("set" , 120 , "1","0","3","2","5","0","4");
        Set setg = redisutil.sGet("set");
        System.out.println("==sHasKey==>>>" + redisutil.sHasKey("set" , "0"));
        System.out.println("==sHasKey==>>>" + redisutil.sHasKey("set" , "8"));
        System.out.println("==sGetSetSize==>>>" + redisutil.sGetSetSize("set"));
        System.out.println("==setRemove==>>>" + redisutil.setRemove("set" , "4"));
        Set setg1 = redisutil.sGet("set");
        System.out.println("==11111====>>>" + setg);
        for (Object s : setg) {
            System.out.println("====222====>>>" + s);
        }
        for (Object s : setg1) {
            System.out.println("====333====>>>" + s);
        }
        */

        /*=================List==================*/
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("2");
        /*redisutil.lSet("list",list,60);
        System.out.println("===size===>>> " + redisutil.lGetListSize("list"));
        List<Object> lists = redisutil.lGet("list",0 , -1);
        for (Object lstr :lists) {
            System.out.println(lstr);
        }*/

        redisutil.set("lists" ,list, 60);
        List<String> lists = (List<String>) redisutil.get("lists");
        for (String ss : lists) {
            System.out.println(ss);
        }
    }
}
