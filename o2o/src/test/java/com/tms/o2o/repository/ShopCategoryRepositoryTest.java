package com.tms.o2o.repository;

import com.tms.o2o.entities.Area;
import com.tms.o2o.entities.ShopCategory;
import com.tms.o2o.service.ShopCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCategoryRepositoryTest {

    @Autowired
    ShopCategoryRepository shopCategoryRepository;
    @Autowired
    ShopCategoryService shopCategoryService;


    @Test
    public void findAll() throws Exception {
        List<ShopCategory> shopCategories = shopCategoryService.findall();
        if (!Objects.isNull(shopCategories))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(ShopCategory shopCategory : shopCategories) {
                System.out.println(shopCategory);
                System.out.println("------------------------------------");
            }
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);

    }

    @Test
    public void findByShopCategoryId() throws Exception {
        ShopCategory shopCategory = shopCategoryService.finone(11);
        if (!Objects.isNull(shopCategory))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            System.out.println(shopCategory);
            System.out.println("------------------------------------");
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
    }

}