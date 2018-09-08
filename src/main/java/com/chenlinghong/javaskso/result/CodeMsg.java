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
@NoArgsConstructor
@ToString
@Getter
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



}
