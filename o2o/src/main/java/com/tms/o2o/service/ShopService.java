package com.tms.o2o.service;

import com.tms.o2o.entities.Shop;

import java.util.List;

//用户业务层接口
public interface ShopService {
    //查询所有店铺类型
    List<Shop> findAll();

    //查大类
    List<Shop> findBig(Integer parentCategoryId);

    //查小类
    List<Shop> findSmall(Integer parentCategoryId,Integer shopCategoryId);

    //查询某一个商店信息
    Shop findOne(Integer shopId);

    //查询某个用户拥有的所有商店（userId）
    List<Shop> findShops(Integer userId);
}
