package com.chenlinghong.javaskso.controller;

import com.chenlinghong.javaskso.domain.OrderInfo;
import com.chenlinghong.javaskso.domain.SeckillOrder;
import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.redis.RedisService;
import com.chenlinghong.javaskso.result.CodeMsg;
import com.chenlinghong.javaskso.service.IGoodsService;
import com.chenlinghong.javaskso.service.IOrderService;
import com.chenlinghong.javaskso.service.ISeckillService;
import com.chenlinghong.javaskso.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/11
 * Time: 11:58
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ISeckillService seckillService;

    @RequestMapping("/doseckill")
    public String list(Model model, User user, @RequestParam("goodsId") long goodsId) {
        if (user == null) {
            return "login";
        }
        //判断库存
        GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goodsVo.getStockCount();
        if (stock <= 0){
            model.addAttribute("errMsg", CodeMsg.SECKILL_OVER.getMsg());
            return "seckill_fail";
        }
        //判断是否已经秒杀过
        SeckillOrder seckillOrder = orderService.getSeckillOrderByUserIdGoodsId(user.getId(),goodsId);
        if (seckillOrder != null){
            //已经秒杀过了
            model.addAttribute("errMsg",CodeMsg.REPEATE_SECKILL.getMsg());
            return "seckill_fail";
        }
        //进行秒杀
        OrderInfo orderInfo = seckillService.seckill(user,goodsVo);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("goods",goodsVo);

        return "order_detail";
    }

}
