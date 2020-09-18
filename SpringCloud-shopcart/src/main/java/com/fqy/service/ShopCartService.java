package com.fqy.service;

import com.fqy.pojo.BaseResp;

import javax.servlet.http.HttpServletRequest;

public interface ShopCartService {

    BaseResp addShopCart(Integer id, HttpServletRequest request);

    BaseResp findUserShopCart(HttpServletRequest request);

    BaseResp deleteShop(Integer id,HttpServletRequest request);
}
