package com.fqy.client;

import com.fqy.pojo.shop.TbShop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(serviceId = "SpringCloud-shop")
public interface ShopClient {

    @RequestMapping("/shop/findById")
    public TbShop findById(@RequestParam("id")Integer id);
}
