package com.tms.o2o.service;

import com.tms.o2o.entities.PersonInfo;
import com.tms.o2o.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//用户业务层实现
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    //登陆客户验证
    @Override
    public PersonInfo checkuser(String username, String password) {
        return userRepository.findByUserNameAndPassword(username,password);
    }

    //登陆店家验证
    @Override
    public PersonInfo checkShopkeeper(String username, String password, Integer shopOwnerFlag) {
        return userRepository.findByUserNameAndPasswordAndShopOwnerFlag(username,password,shopOwnerFlag);
    }
}
