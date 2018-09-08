package com.chenlinghong.javaskso.controller.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 0:32
 */
@Data
@NoArgsConstructor
@ToString
public class User implements Serializable {

    int id;
    String name;

}
