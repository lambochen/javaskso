package com.chenlinghong.javaskso.service.impl;

import com.chenlinghong.javaskso.domain.OrderInfo;
import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.service.IGoodsService;
import com.chenlinghong.javaskso.service.IOrderService;
import com.chenlinghong.javaskso.service.ISeckillService;
import com.chenlinghong.javaskso.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/11
 * Time: 12:13
 */
@Service
public class SeckillServiceImpl implements ISeckillService {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IOrderService orderService;

    @Override
    public OrderInfo seckill(User user, GoodsVo goodsVo) {
        //减库存　下订单　写入秒杀订单
        goodsService.reduceStock(goodsVo);
        return orderService.createOrder(user,goodsVo);
    }
}
