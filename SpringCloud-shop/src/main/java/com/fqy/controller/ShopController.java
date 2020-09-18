package com.fqy.controller;

import com.fqy.pojo.BaseResp;
import com.fqy.service.ShopService;
import com.fqy.pojo.shop.TbShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    //查询全部
    @RequestMapping("/findAll/{page}/{size}")
    public BaseResp findAll(@PathVariable("page")Integer page , @PathVariable("size")Integer size){

        return shopService.findAll(page,size);
    }

    @RequestMapping("/findById")
    public TbShop findById(@RequestParam("id") Integer id){
        return shopService.findById(id);
    }

    @RequestMapping("/updateAndSave")
    public Integer updateAndSave(@RequestBody TbShop tbShop){
        return shopService.updateAndSave(tbShop);
    }
}
