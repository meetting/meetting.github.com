package com.tms.o2o.service;

import com.tms.o2o.entities.Product;
import com.tms.o2o.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//商品业务层实现
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    //查询所有商品信息
    @Override
    public List<Product> finAllProduct(int shopId) {
        return productRepository.findAllByShopIdOrderByPriorityDesc(shopId);
    }

    //查询一个商品所有的信息
    @Override
    public Product findOne(int productId) {
        return productRepository.findByProductId(productId);
    }
}
