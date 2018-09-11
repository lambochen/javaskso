package com.chenlinghong.javaskso.service.impl;

import com.chenlinghong.javaskso.dao.IGoodsDao;
import com.chenlinghong.javaskso.domain.Goods;
import com.chenlinghong.javaskso.domain.SeckillGoods;
import com.chenlinghong.javaskso.service.IGoodsService;
import com.chenlinghong.javaskso.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 22:16
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsDao goodsDao;

    @Override
    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

    @Override
    public GoodsVo getGoodsVoByGoodsId(long goodsId) {

        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    @Override
    public void reduceStock(GoodsVo goodsVo) {
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setGoodsId(goodsVo.getId());
        goodsDao.reduceStock(seckillGoods);
    }
}
