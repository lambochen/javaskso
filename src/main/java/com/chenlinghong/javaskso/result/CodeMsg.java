package com.chenlinghong.javaskso.result;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/08
 * Time: 22:20
 */
//@NoArgsConstructor
//@ToString
//@Getter
public class CodeMsg implements Serializable {

    private int code;
    private String msg;

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //通用异常
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务端异常");

    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210,"Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211,"密码为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212,"手机号为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213,"手机号错误");
    public static CodeMsg MOBILE_NOT_EXISTS = new CodeMsg(500214,"手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215,"密码错误");

    //商品模块 5003XX

    //订单模块 5004XX


    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public CodeMsg() {
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
