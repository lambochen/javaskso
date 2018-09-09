package com.chenlinghong.javaskso.dao;

import com.chenlinghong.javaskso.controller.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/09
 * Time: 0:33
 */
@Mapper
public interface IUserDao {

    @Select("select id,name from user where id=#{id}")
    User getById(@Param("id") int id);

}
