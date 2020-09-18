package com.fqy.service;

import com.fqy.pojo.BaseResp;
import com.fqy.pojo.shop.TbShop;

public interface ShopService {

    //BaseResp findAll();
    BaseResp findAll(Integer page ,Integer size);

    TbShop findById(Integer id);

    Integer updateAndSave(TbShop tbShop);
}
