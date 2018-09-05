package com.teamtwo.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.teamtwo.pojo.Tuser;

public interface TuserMapper {

	//登录验证
	Map<String, Object> selectByUsernameAndPassword(Tuser tuser);
	
	//查询所有用户
	List<HashMap<String, Object>> selectAllTuser();

	//添加用户
	int addTuser(Tuser tuser);

	//修改用户信息
	int modifyTuser(Tuser tuser);

	//通过userid查询用户信息
	Map<String,Object> lookOneTuser(Integer userid);

	//通过userid修改用户类型
	int modifyRoleid(Tuser tuser);

	//通过用户id删除该用户
	int delTuser(int userid);

	//通过用户名查询用户
	Tuser checkun(String username);


}
