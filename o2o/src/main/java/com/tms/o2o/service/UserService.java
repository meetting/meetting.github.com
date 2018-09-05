package com.tms.o2o.service;

import com.tms.o2o.common.Result;
import com.tms.o2o.entities.PersonInfo;

//用户业务层接口
public interface UserService {

    //验证客户登陆
    PersonInfo checkuser(String username, String password);

    //验证商家登陆
    PersonInfo checkShopkeeper(String username,String password,Integer shopOwnerFlag);

}
