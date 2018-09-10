package com.chenlinghong.javaskso.controller;

import com.chenlinghong.javaskso.domain.User;
import com.chenlinghong.javaskso.redis.RedisService;
import com.chenlinghong.javaskso.service.IGoodsService;
import com.chenlinghong.javaskso.service.IUserService;
import com.chenlinghong.javaskso.service.impl.UserServiceImpl;
import com.chenlinghong.javaskso.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 15:40
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private IGoodsService goodsService;

    /**
     * 获取cookie，兼容移动端采用参数传递cookie
     *
     * @param model //     * @param cookieToken
     *              //     * @param paramToken
     * @return
     */
    @RequestMapping("/tolist")
    public String toList(Model model,
//                         @CookieValue(value = UserServiceImpl.COOKIE_NAME_TOKEN,required = false) String cookieToken,
//                         @RequestParam(value = UserServiceImpl.COOKIE_NAME_TOKEN,required = false) String paramToken,
//                         HttpServletResponse response,
                         User user) {
//        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)){
//            return "login";
//        }
//        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
//        User user = userService.getByToken(response,token);

        //查询商品列表
        List<GoodsVo> goodsVoList = goodsService.listGoodsVo();


        model.addAttribute("goodsList", goodsVoList);
        return "goods_list";
    }


    @RequestMapping("/todetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable("goodsId") long goodsId) {

        //ＩＤ：ｓｎｏｗｆｌａｋｅ算法
        GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goodsVo);

        long startAt = goodsVo.getStartDate().getTime();
        long endAt = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int seckillStatus = 0;
        int remainSeconds = 0;

        if (now < startAt) {
            //秒杀未开始
            seckillStatus = 0;
            remainSeconds = (int)(startAt - now) /1000;
        } else if (now > endAt) {
            //秒杀已结束
            seckillStatus = 1;
            remainSeconds = -1;
        } else {
            //秒杀进行中
            seckillStatus = 2;
            remainSeconds = 0;
        }
        model.addAttribute("seckillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }

}
