package com.chenlinghong.javaskso.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 15:28
 */
public class UUIDUtil {

    public static String uuid(){
        //原生UUID带-，此处去掉
        return UUID.randomUUID().toString().replace("-","");
    }
}
