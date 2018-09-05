package com.tms.o2o.repository;

import com.tms.o2o.entities.Shop;
import com.tms.o2o.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopRepositoryTest {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ShopService shopService;

    //查询所有店铺数据
    //@Test
    public void findAll() throws Exception {

        List<Shop> shops = shopService.findAll();
        if (!Objects.isNull(shops))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(Shop shop : shops) {
                System.out.println(shop);
                System.out.println("------------------------------------");
            }
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);
    }

    //根据parentCategoryId查询店铺数据
    @Test
    public void findByParentCategoryId() throws Exception {

        List<Shop> shops = shopRepository.findByParentCategoryId(10);
        if (!Objects.isNull(shops))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(Shop shop : shops) {
                System.out.println(shop);
                System.out.println("------------------------------------");
            }
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);
    }

    //根据parentCategoryId和shopCategoryId查询店铺数据，小类
    @Test
    public void findByParentCategoryIdAndShopCategoryId() throws Exception {

        List<Shop> shops = shopRepository.findByParentCategoryIdAndShopCategoryId(10,15);
        if (!Objects.isNull(shops))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(Shop shop : shops) {
                System.out.println(shop);
                System.out.println(shop.getLastEditTime());
                System.out.println("------------------------------------");
            }
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);
    }
    //根据shopId查一个商店
    @Test
    public void findByShopId() throws Exception {

        Shop shop = shopService.findOne(15);
        if (!Objects.isNull(shop))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            System.out.println(shop);
            System.out.println("------------------------------------");
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);
    }

    //根据userId（ownerId）查询商店
    @Test
    public void findByOwnerId() throws Exception {

        List<Shop> shops = shopService.findShops(8);
        if (!Objects.isNull(shops))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(Shop shop : shops) {
                System.out.println(shop);
                System.out.println("------------------------------------");
            }
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }

    }
}