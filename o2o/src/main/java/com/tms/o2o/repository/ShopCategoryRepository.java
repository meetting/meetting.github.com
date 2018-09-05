package com.tms.o2o.repository;

import com.tms.o2o.entities.Area;
import com.tms.o2o.entities.ShopCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//店铺类别，数据层接口
@Repository
public interface ShopCategoryRepository extends JpaRepository<ShopCategory,Integer> {

    //查询所有店铺类型
    public List<ShopCategory> findAll();

    //按照shopCategoryId查询某个店铺类型
    public ShopCategory findByShopCategoryId(Integer shopCategoryId);

}
