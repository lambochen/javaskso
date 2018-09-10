package com.chenlinghong.javaskso.service.impl;

import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.dao.IUserDao;
import com.chenlinghong.javaskso.result.CodeMsg;
import com.chenlinghong.javaskso.service.IUserService;
import com.chenlinghong.javaskso.util.MD5Util;
import com.chenlinghong.javaskso.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public CodeMsg login(LoginVo loginVo) {
        if (loginVo == null) {
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号码是否存在
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            return CodeMsg.MOBILE_NOT_EXISTS;
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass,saltDB);
        if (!calcPass.equals(dbPass)){
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
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
