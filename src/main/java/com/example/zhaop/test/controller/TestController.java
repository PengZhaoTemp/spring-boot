package com.example.zhaop.test.controller;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.example.zhaop.test.service.TestService;
import com.example.zhaop.test.vo.User;
import com.example.zhaop.utils.annotation.PassToken;
import com.example.zhaop.utils.annotation.UserLoginToken;
import com.example.zhaop.utils.jwt.JwtToken;
import com.example.zhaop.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestService testservice;

    @Autowired
    private RedisUtil redisutil;

    @Autowired
    private JwtToken jwtToken;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String test() {
        return "index";
    }

    /**
     * 查询信息
     * @return
     */
    @RequestMapping(value = "info",method = RequestMethod.GET)
    public String testInfo(){
        String jsonStr;
        Object ob = redisutil.get("jsonStr");
        if (ob != null) {
            jsonStr = "从redis中获取" + ob;
        } else {
            List<Map> list = testservice.searchTestInfo("1");
            String json = JSONObject.toJSONString(list);
            redisutil.set("jsonStr" , json , 60);
            jsonStr = "从数据库中获取中获取" + json;
        }
        return jsonStr;
    }

    /**
     * map测试
     * @return
     */
    @RequestMapping(value = "infomap",method = RequestMethod.GET)
    public Map testInfomap(){

        String str = "123";
        Map mapr = redisutil.hmget("map");
        if (mapr != null && mapr.size() > 0) {
            redisutil.hset("map" , "a" , "10" , 60);
            redisutil.hset("map" , "e" , "11" , 60);
            Object o = redisutil.hget("map" , "b");
            redisutil.hdel("map" , "a" , "e");
            boolean flag = redisutil.hHasKey("map" , "b");
            System.out.println("------ddd---->>> " + o);
            System.out.println(flag);
            System.out.println(str);

        } else {
            Map map = new HashMap();
            map.put("a" , 1);
            map.put("b" , 2);
            map.put("c" , 3);
            map.put("d" , 4);
            redisutil.hmset("map" , map , 60);
        }
        return mapr;
    }

    /**
     * 获取token
     * @return
     */
    @PostMapping("token")
    @PassToken
    public String getToken() {
        User user = new User();
        user.setId("1111");
        user.setUsername("赵芃");
        user.setPassword("1254aw4fd5fe5");
        String token = jwtToken.getToken(user);
        return token;
    }

    /**
     * token验证
     * @return
     */
    @PostMapping("message")
    @UserLoginToken
    public String getUserMessage(HttpServletRequest request) {
        String id = "";
        try {
            System.out.println("11111111");
            String token = request.getHeader("token");
            id = JWT.decode(token).getAudience().get(0);
            System.out.println("---------id------>>> " + id);
        } catch (Exception e) {
            throw new RuntimeException("401");
        }
        return id;
    }
}
