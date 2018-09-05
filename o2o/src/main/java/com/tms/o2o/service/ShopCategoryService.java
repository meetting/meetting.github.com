package com.tms.o2o.service;

import com.tms.o2o.entities.ShopCategory;

import java.util.List;

public interface ShopCategoryService {


    //查所有
    List<ShopCategory> findall();

    //shopCategoryId查一个
    ShopCategory finone(Integer shopCategoryId);

}
