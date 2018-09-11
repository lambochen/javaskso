package com.chenlinghong.javaskso.dao;

import com.chenlinghong.javaskso.domain.OrderInfo;
import com.chenlinghong.javaskso.domain.SeckillOrder;
import org.apache.ibatis.annotations.*;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/11
 * Time: 12:23
 */
@Mapper
public interface IOrderDao {

    @Select("select * from seckill_order where user_id=#{userId} and goods_id=#{goodsId}" )
    SeckillOrder getSeckillOrderByUserIdGoodsId(@Param("userId") Long userId, @Param("goodsId") long goodsId);

    @Insert("insert into order_info(user_id,goods_id,goods_name,goods_count,goods_price,order_channel,status,create_date) " +
            "values(#{userId},#{goodsId},#{goodsName},#{goodsCount},#{goodsPrice},#{orderChannel},#{status},#{createDate})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = Long.class,before = false,statement = "select last_insert_id()")
    Long insert(OrderInfo orderInfo);

    @Insert("insert into seckill_order(user_id,goods_id,order_id) " +
            "values(#{userId},#{goodsId},#{orderId})")
    Long insertSeckillOrder(SeckillOrder seckillOrder);
}
