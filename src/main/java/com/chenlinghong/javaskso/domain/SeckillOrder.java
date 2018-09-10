package com.chenlinghong.javaskso.domain;

/**
 * 秒杀订单
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 22:13
 */
public class SeckillOrder {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;

    public SeckillOrder() {
    }

    @Override
    public String toString() {
        return "SeckillOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
