package com.tms.o2o.service;

import com.tms.o2o.entities.ProductImg;
import com.tms.o2o.repository.ProductImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//商品图片业务层实现
@Service
public class ProductImgServiceImpl implements ProductImgService{

    @Autowired
    ProductImgRepository productImgRepository;
    //通过productId查询商品相关图片信息
    @Override
    public List<ProductImg> finOneProduct(int productId) {
        return productImgRepository.findAllByProductIdOrderByPriorityDesc(productId);
    }
}
