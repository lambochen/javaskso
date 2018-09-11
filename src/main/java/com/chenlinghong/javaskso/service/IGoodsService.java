package com.chenlinghong.javaskso.service;

import com.chenlinghong.javaskso.vo.GoodsVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 22:16
 */
public interface IGoodsService {

    List<GoodsVo> listGoodsVo();

    GoodsVo getGoodsVoByGoodsId(long goodsId);

    void reduceStock(GoodsVo goodsVo);
}
