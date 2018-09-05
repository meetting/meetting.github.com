package com.tms.o2o.service;

import com.tms.o2o.entities.Shop;
import com.tms.o2o.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//店铺业务层实现
@Service
public class ShopServiceImpl  implements ShopService{

    @Autowired
    ShopRepository shopRepository;

    //查询所有店铺类型
    @Override
    public List<Shop> findAll() {
        return shopRepository.findAllByOrderByShopIdDesc();
    }

    //查大类实现
    @Override
    public List<Shop> findBig(Integer parentCategoryId) {
        return shopRepository.findByParentCategoryId(parentCategoryId);
    }

    //查小类实现
    @Override
    public List<Shop> findSmall(Integer parentCategoryId, Integer shopCategoryId) {
        return shopRepository.findByParentCategoryIdAndShopCategoryId(parentCategoryId,shopCategoryId);
    }

    //查一个商店
    @Override
    public Shop findOne(Integer shopId) {
        return shopRepository.findByShopId(shopId);
    }

    //查询某一个人所开的所有的店铺
    @Override
    public List<Shop> findShops(Integer userId) {
        return shopRepository.findByOwnerId(userId);
    }
}
