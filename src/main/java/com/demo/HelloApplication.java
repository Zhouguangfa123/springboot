package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HelloApplication
 *
 * @author zhougf
 * @date 2019/7/4
 */
@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello world！";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
