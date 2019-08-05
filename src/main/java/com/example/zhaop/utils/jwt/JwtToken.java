package com.example.zhaop.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.zhaop.test.vo.User;
import org.springframework.stereotype.Component;

@Component
public class JwtToken {

    /**
     * 获取token
     * @param user
     * @return
     */
    public String getToken(User user) {
        String token = "";
        /*withAudience 存入需要保存在token的信息。Algorithm.HMAC256() 用什么秘钥来生成token。*/
        token = JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
