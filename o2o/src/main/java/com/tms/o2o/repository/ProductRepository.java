package com.tms.o2o.repository;

import com.tms.o2o.entities.Product;
import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//商品，数据层接口
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    //查询全部商品（通过商店id并按照权重来降序排序）
    public List<Product> findAllByShopIdOrderByPriorityDesc(Integer shopId);

    //查询一个商品的所有信息通过商品编号
    public Product findByProductId(Integer productId);
}
