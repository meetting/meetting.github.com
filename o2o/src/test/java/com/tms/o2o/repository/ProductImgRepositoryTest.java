package com.tms.o2o.repository;

import com.tms.o2o.entities.ProductImg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductImgRepositoryTest {
    @Autowired
    ProductImgRepository productImgRepository;


    @Test
    public void findAllByProductIdOrderByPriorityDesc() throws Exception {
        List<ProductImg> productImgs = productImgRepository.findAllByProductIdOrderByPriorityDesc(10);
        if (!Objects.isNull(productImgs))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(ProductImg productImg : productImgs) {
                System.out.println(productImg);
                System.out.println("------------------------------------");
            }
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);

    }

}