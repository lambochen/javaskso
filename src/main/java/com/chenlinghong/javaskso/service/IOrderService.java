package com.chenlinghong.javaskso.service;

import com.chenlinghong.javaskso.domain.OrderInfo;
import com.chenlinghong.javaskso.domain.SeckillOrder;
import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.vo.GoodsVo;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/11
 * Time: 12:07
 */
public interface IOrderService {
    SeckillOrder getSeckillOrderByUserIdGoodsId(Long id, long goodsId);

    OrderInfo createOrder(User user, GoodsVo goodsVo);
}
