package com.chenlinghong.javaskso.controller;

import com.chenlinghong.javaskso.result.CodeMsg;
import com.chenlinghong.javaskso.result.Result;
import com.chenlinghong.javaskso.service.IUserService;
import com.chenlinghong.javaskso.util.ValidatorUtil;
import com.chenlinghong.javaskso.vo.LoginVo;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 11:36
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/dologin")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo){
        logger.info(loginVo.toString());
        //参数校验
//        String passInput = loginVo.getPassword();
//        String mobile = loginVo.getMobile();
//        if (StringUtils.isEmptyOrWhitespaceOnly(passInput)){
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if (StringUtils.isEmptyOrWhitespaceOnly(mobile)){
//            return Result.error(CodeMsg.MOBILE_EMPTY);
//        }
//        if (!ValidatorUtil.isMobile(mobile)){
//            return Result.error(CodeMsg.MOBILE_ERROR);
//        }
        //登录
        CodeMsg codeMsg = userService.login(loginVo);
        if (codeMsg.getCode() == 0){
            return Result.success(true);
        } else {
            return Result.error(codeMsg);
        }
    }


}
