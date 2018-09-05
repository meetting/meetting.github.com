package com.tms.o2o.repository;

import com.tms.o2o.entities.ProductImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//商品图片，数据层接口
@Repository
public interface ProductImgRepository extends JpaRepository<ProductImg,Integer> {

    //查询全部商品图片（通过商品id并按照权重来降序排序）
    public List<ProductImg> findAllByProductIdOrderByPriorityDesc(Integer productId);
}
