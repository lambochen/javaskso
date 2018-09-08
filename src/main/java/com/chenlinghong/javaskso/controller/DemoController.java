package com.chenlinghong.javaskso.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/08
 * Time: 21:49
 */
@RestController
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DemoController {

//    public static void main(String[] args) throws Exception{
//        SpringApplication.run(DemoController.class,args);
//    }

    @GetMapping("/demo")
    @ResponseBody
    public String home(){
        return "Hello World!";
    }

}
