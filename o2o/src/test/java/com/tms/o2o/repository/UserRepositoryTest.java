package com.tms.o2o.repository;

import com.tms.o2o.entities.PersonInfo;
import com.tms.o2o.service.UserService;
import org.junit.Assert;
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
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    //用户登陆测试
    @Test
    public void findByUserNameAndPassword() throws Exception {
        PersonInfo users = userService.checkuser("lz","lz");
        if (!Objects.isNull(users))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            System.out.println(users);
            System.out.println("------------------------------------");
        }
        else
            {
                System.out.println("---------------查不到，为空---------------");
            }
        //Assert.assertNotNull(users);
    }

    //店家登陆测试
    @Test
    public void findByUserNameAndPasswordAndAdminFlag() throws Exception {
        PersonInfo user = userService.checkShopkeeper("lz","lz",1);
        if (!Objects.isNull(user))
        {
            System.out.println("----------------------不为空，可以查到！------------------");
            System.out.println(user);
            System.out.println("------------------------------------");
        }
        else
        {
            System.out.println("---------------查不到，为空---------------");
        }
        //Assert.assertNotNull(users);
    }


}