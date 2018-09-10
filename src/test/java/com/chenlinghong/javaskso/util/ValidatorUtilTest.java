package com.chenlinghong.javaskso.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 12:21
 */
public class ValidatorUtilTest {

    @Test
    public void isMobile() {

        System.out.println(ValidatorUtil.isMobile("1300234"));
        System.out.println(ValidatorUtil.isMobile("13002341234"));

    }
}