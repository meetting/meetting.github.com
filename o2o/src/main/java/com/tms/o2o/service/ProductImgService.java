package com.tms.o2o.service;

import com.tms.o2o.entities.ProductImg;

import java.util.List;

public interface ProductImgService {

    //通过productId查询商品相关图片信息
    List<ProductImg> finOneProduct(int productId);
}
