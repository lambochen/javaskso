package com.chenlinghong.javaskso.controller;

import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.result.CodeMsg;
import com.chenlinghong.javaskso.result.Result;
import com.chenlinghong.javaskso.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/08
 * Time: 21:49
 */
//@RestController
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@Controller
@RequestMapping("/test")
public class DemoController<string> {

//    public static void main(String[] args) throws Exception{
//        SpringApplication.run(DemoController.class,args);
//    }

    @Autowired
    private IUserService userService;

    @GetMapping("/demo")
    @ResponseBody
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/hello")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("hello springboot.");
    }

    @GetMapping("/helloerror")
    @ResponseBody
    public Result<String> helloError(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    /**
     * 测试使用thymeleaf模板
     * @param model
     * @return
     */
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","SpringBoot");
        return "hello";
    }

    /**
     * 测试数据库获取数据
     * @return
     */
    @GetMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(){
        return Result.success(userService.getById(1));
    }

    /**
     * 测试数据库事务
     * @return
     */
    @GetMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx(){
        return Result.success(userService.tx());
    }

}
