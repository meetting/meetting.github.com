package com.tms.o2o.repository;

import com.tms.o2o.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//店铺，数据层接口
@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
    //查所有
    public List<Shop> findAllByOrderByShopIdDesc();

    //根据parentCategoryId查询，大类
    public List<Shop> findByParentCategoryId(Integer parentCategoryId);

    //根据parentCategoryId和shopCategoryId查询，小类，更细
    public List<Shop> findByParentCategoryIdAndShopCategoryId(Integer parentCategoryId,Integer shopCategoryId);

    //根据shopId查询商店
    public Shop findByShopId(Integer shopId);

    //根据userId（ownerId）查询商店
    public List<Shop> findByOwnerId(Integer ownerId);

}
