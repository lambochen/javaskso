package com.chenlinghong.javaskso.redis;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 21:19
 */
public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();

}
