package com.tms.o2o.repository;

import com.tms.o2o.entities.Area;
import com.tms.o2o.entities.ProductImg;
import com.tms.o2o.service.AreaService;
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
public class AreaRepositoryTest {

    @Autowired
    AreaRepository areaRepository;
    @Autowired
    AreaService areaService;

    @Test
    public void findAll() throws Exception {
        List<Area> areas = areaService.findall();
        if (!Objects.isNull(areas))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            for(Area area : areas) {
                System.out.println(area);
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
    public void findByAreaId() throws Exception {
        Area area = areaService.findone(4);
        if (!Objects.isNull(area))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            System.out.println(area);
            System.out.println("------------------------------------");
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
    }

}