package com.chenlinghong.javaskso.controller;

import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.redis.RedisService;
import com.chenlinghong.javaskso.result.Result;
import com.chenlinghong.javaskso.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/11
 * Time: 15:19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/info")
    @ResponseBody
    public Result<User> userInfo(Model model,User user){
        return Result.success(user);
    }
}
