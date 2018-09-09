package com.chenlinghong.javaskso.service;

import com.chenlinghong.javaskso.domain.User;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 0:36
 */
public interface IUserService {

    User getById(int id);

    int insert(User user);

    boolean tx();
}
