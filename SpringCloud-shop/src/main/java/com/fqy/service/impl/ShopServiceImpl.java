package com.fqy.service.impl;

import com.fqy.pojo.BaseResp;
import com.fqy.repository.ShopRepository;
import com.fqy.service.ShopService;
import com.fqy.pojo.shop.TbShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;

   /* @Override
    public BaseResp findAll() {
        List<TbShop> all = shopRepository.findAll();

        BaseResp baseResp = new BaseResp();
        baseResp.setList(all);
        return baseResp;
    }*/
   @Override
   public BaseResp findAll(Integer page ,Integer size) {

       PageRequest pageRequest = new PageRequest(page - 1, size);
       Page<TbShop> all = shopRepository.findAll(pageRequest);

       BaseResp baseResp = new BaseResp();
       baseResp.setList(all.getContent());
       baseResp.setCount(all.getTotalElements());
       return baseResp;
   }

    @Override
    public TbShop findById(Integer id) {

        Optional<TbShop> byId = shopRepository.findById(id);
        System.out.println(byId.get());
        return byId.get();
    }

    @Override
    public Integer updateAndSave(TbShop tbShop) {

        TbShop tbShop1 = shopRepository.saveAndFlush(tbShop);
        if (tbShop1 != null){
            return 1;
        }
        return 0;
    }

}
