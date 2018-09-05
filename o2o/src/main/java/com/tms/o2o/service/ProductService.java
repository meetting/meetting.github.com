package com.tms.o2o.service;

import com.tms.o2o.entities.Product;

import java.util.List;

public interface ProductService {

    //查询所有商品
    List<Product> finAllProduct(int shopId);

    //查询一个商品的所有信息
    Product findOne(int productId);
}
