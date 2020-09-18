package com.fqy.repository;

import com.fqy.pojo.shop.TbShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<TbShop,Integer> {
}
