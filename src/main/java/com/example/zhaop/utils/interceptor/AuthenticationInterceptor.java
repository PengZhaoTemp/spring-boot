package com.example.zhaop.utils.interceptor;
import com.auth0.jwt.JWT;
import com.example.zhaop.utils.annotation.PassToken;
import com.example.zhaop.utils.annotation.UserLoginToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {


    /*
     * Controller方法调用前，返回true表示继续处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {

        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(obj instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlermethod = (HandlerMethod)obj;
        Method method = handlermethod.getMethod();
        /*检查是否有PassToken注解，有则跳过认证*/
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        /*检查需要验证的*/
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userlogintoken = method.getAnnotation(UserLoginToken.class);
            if (userlogintoken.required()) {
                if (null == token) {
                    throw new RuntimeException("无token，请重新登录");
                }
                return true;
            }
        }
        return false;
    }

    /*
     * Controller方法调用后，视图渲染前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /*
     * 整个请求处理完，视图已渲染。如果存在异常则Exception不为空
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
