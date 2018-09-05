package com.tms.o2o.service;

import com.tms.o2o.entities.ShopCategory;
import com.tms.o2o.repository.ShopCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//店铺分类业务层实现
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{

    @Autowired
    ShopCategoryRepository shopCategoryRepository;

    //查所有
    @Override
    public List<ShopCategory> findall() {
        return shopCategoryRepository.findAll();
    }

    //查一个
    @Override
    public ShopCategory finone(Integer shopCategoryId) {
        return shopCategoryRepository.findByShopCategoryId(shopCategoryId);
    }

}
