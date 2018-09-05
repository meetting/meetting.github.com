package com.tms.o2o.repository;

import com.tms.o2o.entities.Product;
import com.tms.o2o.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @Test
    public void findAllByShopIdOrderByPriorityDesc() throws Exception {
        List<Product> products = productService.finAllProduct(15);

        if (!Objects.isNull(products))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(Product product : products) {
                System.out.println(product);
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
    public void findone() throws Exception {
        //Product theproduct = productService.findOne(5);
        Product theproduct = productRepository.findByProductId(5);
        if (!Objects.isNull(theproduct))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            System.out.println(theproduct);
            System.out.println("------------------------------------");

        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);
    }

}