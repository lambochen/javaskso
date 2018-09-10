package com.chenlinghong.javaskso.redis;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 21:26
 */
public class UserKey extends BasePrefix {

    private static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    private UserKey(int expireSeconds,String prefix) {
        super(expireSeconds,prefix);

    }

    public static UserKey token = new UserKey(TOKEN_EXPIRE,"token");
}
