package com.tms.o2o.repository;

import com.tms.o2o.entities.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//用户，数据层接口
@Repository
public interface UserRepository extends JpaRepository<PersonInfo,Integer>{

    //查询是否有该用户
    public PersonInfo findByUserNameAndPassword(String username, String password);

    //查询是否有该店主
    public PersonInfo findByUserNameAndPasswordAndShopOwnerFlag(String username,String password,Integer shopOwnerFlag);

}
