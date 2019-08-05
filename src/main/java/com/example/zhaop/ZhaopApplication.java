package com.example.zhaop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.example.zhaop.test.mapper","com.example.zhaop"})
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class ZhaopApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(ZhaopApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(ZhaopApplication.class, args);
    }

}
