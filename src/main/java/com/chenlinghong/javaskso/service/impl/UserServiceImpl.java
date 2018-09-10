package com.chenlinghong.javaskso.service.impl;

import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.dao.IUserDao;
import com.chenlinghong.javaskso.exception.GlobalException;
import com.chenlinghong.javaskso.redis.RedisService;
import com.chenlinghong.javaskso.redis.UserKey;
import com.chenlinghong.javaskso.result.CodeMsg;
import com.chenlinghong.javaskso.service.IUserService;
import com.chenlinghong.javaskso.util.MD5Util;
import com.chenlinghong.javaskso.util.UUIDUtil;
import com.chenlinghong.javaskso.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 0:37
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private RedisService redisService;

    public static final String COOKIE_NAME_TOKEN = "token";

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public boolean login(HttpServletResponse response,LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号码是否存在
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXISTS);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass,saltDB);
        if (!calcPass.equals(dbPass)){
            throw new GlobalException( CodeMsg.PASSWORD_ERROR);
        }
        //登录成功,实现分布式session
        String token = UUIDUtil.uuid();
        addCookie(user,response,token);
        return true;
    }

    //将Cookie生成单独抽离出来
    private void addCookie(User user,HttpServletResponse response,String token){
//        String token = UUIDUtil.uuid();
        redisService.set(UserKey.token,token,user);
        //生成Cookie
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        //设置有效期
        cookie.setMaxAge(UserKey.token.expireSeconds());
        //设置域
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public User getByToken(HttpServletResponse response,String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        User user = redisService.get(UserKey.token,token,User.class);
        //延长token有效期
        if (user != null){
            addCookie(user,response,token);
        }
        return user;
    }

//    @Override
//    public int insert(User user) {
//        return 0;
//    }
//
//    @Override
//    @Transactional
//    public boolean tx() {
//        User u1 = new User();
//        u1.setId(2);
//        u1.setName("22222");
//        userDao.insert(u1);
//
//        User u2 = new User();
//        u2.setId(1);
//        u2.setName("ceshi");
//        userDao.insert(u2);
//
//        return false;
//    }
}
