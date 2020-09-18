package com.fqy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fqy.client.ShopClient;
import com.fqy.pojo.BaseResp;
import com.fqy.pojo.shop.TbShop;
import com.fqy.pojo.user.TbUser;
import com.fqy.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ShopClient shopClient;

    @Override
    public BaseResp addShopCart(Integer id, HttpServletRequest request) {

        //获取到当前操作的用户
        TbUser user = findUserByToken(request);
        //获取商品信息
        //Integer shopid = tbShop.getShopid();
        TbShop shop = shopClient.findById(id);

        //声明返回值
        BaseResp baseResp = new BaseResp();

        try{
            //操作redis
            redisTemplate.opsForHash().put("shopcart_"+user.getId().toString(),id.toString(),shop);
        }catch (Exception e){
            System.out.println(e.getMessage());
            baseResp.setMessage("添加失败");
            return baseResp;
        }
        baseResp.setMessage("添加成功");
        return baseResp;
    }

    @Override
    public BaseResp findUserShopCart(HttpServletRequest request) {

        TbUser userByToken = findUserByToken(request);
        System.out.println(userByToken);

        if (redisTemplate.hasKey("shopcart_"+userByToken.getId())){
            List values = redisTemplate.opsForHash().values("shopcart_" + userByToken.getId());

            BaseResp baseResp = new BaseResp();
            baseResp.setList(values);
            return baseResp;
        }

        return null;
    }

    @Override
    public BaseResp deleteShop(Integer id, HttpServletRequest request) {
        //获取到当前操作的用户
        TbUser user = findUserByToken(request);
        BaseResp baseResp = new BaseResp();

        try {
            //操作redis删除该商品
            //Object o = redisTemplate.opsForHash().get("shopcart_" +user.getUserid().toString(), id.toString());
            redisTemplate.opsForHash().delete("shopcart_" + user.getId().toString(),id.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
            baseResp.setMessage("删除失败");
            return baseResp;
        }

        baseResp.setMessage("删除成功");
        return baseResp;
    }

    public TbUser findUserByToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String token = getToken(cookies);

        Object o = redisTemplate.opsForValue().get(token);

        Object o1 = JSONObject.toJSON(o);

        TbUser tbUser = JSONObject.parseObject(o1.toString(), TbUser.class);

        return tbUser;
    }

    public String getToken(Cookie[] cookies){
        if (cookies != null){
            for (Cookie cook : cookies
            ) {
                if (cook.getName().equals("token")){
                    String token = cook.getValue();
                    return token;
                }
            }
            return null;
        }
        return null;
    }
}
