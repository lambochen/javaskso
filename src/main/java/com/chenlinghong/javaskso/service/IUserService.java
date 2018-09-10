package com.chenlinghong.javaskso.service;

import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.result.CodeMsg;
import com.chenlinghong.javaskso.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 0:36
 */
public interface IUserService {

    User getById(long id);

//    int insert(User user);
//
//    boolean tx();

    boolean login(HttpServletResponse response,LoginVo loginVo);

    User getByToken(String token);
}
