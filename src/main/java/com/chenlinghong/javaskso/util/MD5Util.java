package com.chenlinghong.javaskso.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 23:42
 */
public class MD5Util {

    public static String md5(String data){
        return DigestUtils.md5Hex(data);
    }

    private static final String salt = "f2342hjfw::{234hdfw/.hfs46iyfhi";

    /**
     * 将用户输入的password加盐MD5转换为Form表单password
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass){
        String data = "" + inputPass + salt;
        return md5(data);
    }

    /**
     * 将Form表单password MD5为DB password
     * @param formPass
     * @param randomSalt
     * @return
     */
    public static String formPassToDBPass(String formPass,String randomSalt){
        String data = "" + formPass + randomSalt;
        return md5(data);
    }

    public static String inputPassToDBPass(String input,String saltDB){
        String formPass = inputPassToFormPass(input);
        String dbPass = formPassToDBPass(formPass,saltDB);
        return dbPass;
    }

}
