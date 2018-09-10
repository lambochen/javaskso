package com.chenlinghong.javaskso.controller;

import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.redis.RedisService;
import com.chenlinghong.javaskso.service.IUserService;
import com.chenlinghong.javaskso.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 15:40
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisService redisService;

    /**
     * 获取cookie，兼容移动端采用参数传递cookie
     * @param model
//     * @param cookieToken
//     * @param paramToken
     * @return
     */
    @RequestMapping("/tolist")
    public String toList(Model model,
//                         @CookieValue(value = UserServiceImpl.COOKIE_NAME_TOKEN,required = false) String cookieToken,
//                         @RequestParam(value = UserServiceImpl.COOKIE_NAME_TOKEN,required = false) String paramToken,
//                         HttpServletResponse response,
                         User user){
//        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)){
//            return "login";
//        }
//        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
//        User user = userService.getByToken(response,token);
        model.addAttribute("user",user);
        return "goods_list";
    }

}
