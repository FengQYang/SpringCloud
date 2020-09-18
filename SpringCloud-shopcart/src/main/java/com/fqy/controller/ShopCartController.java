package com.fqy.controller;

import com.fqy.pojo.BaseResp;
import com.fqy.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class ShopCartController {

    @Autowired
    ShopCartService shopCartService;

    @RequestMapping("/testCart")
    public String testCart(){
        return "cart成功";
    }

    @RequestMapping("/addShopCart")
    public BaseResp addShopCart(@RequestBody Map map, HttpServletRequest request){

        return shopCartService.addShopCart((Integer) map.get("id"),request);
    }

    @RequestMapping("/findUserShopCart")
    public BaseResp findUserShopCart(HttpServletRequest request){
        return shopCartService.findUserShopCart(request);
    }

    @RequestMapping("/deleteShop")
    public BaseResp deleteShop(@RequestBody Map tbShop, HttpServletRequest request){
        return shopCartService.deleteShop((Integer) tbShop.get("id"),request);
    }
}
