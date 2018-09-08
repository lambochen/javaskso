package com.chenlinghong.javaskso.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/08
 * Time: 21:49
 */
@Controller
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DemoController {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(DemoController.class,args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "Hello World!";
    }

}
