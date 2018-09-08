package com.chenlinghong.javaskso.service.impl;

import com.chenlinghong.javaskso.controller.domain.User;
import com.chenlinghong.javaskso.dao.IUserDao;
import com.chenlinghong.javaskso.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 0:37
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
