package com.teamtwo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.TuserMapper;
import com.teamtwo.pojo.Tuser;
import com.teamtwo.service.TuserService;
import com.teamtwo.util.ReturnMsg;

@Service
public class TuserServiceImpl implements TuserService {

	@Autowired
	private TuserMapper tuserMapper;
	
	
	//登陆验证
	@Override
	public Map<String, Object> checkTuser(Tuser tuser) {
		
		return tuserMapper.selectByUsernameAndPassword(tuser);
	}
	
	//查询所有用户
	@Override
	public List<HashMap<String, Object>> selectAllTuser()
	{
		return tuserMapper.selectAllTuser();
	}
	
	//增加用户
	@Override
	public ReturnMsg addTuser(Tuser tuser)
	{
		//如果flag大于0，则说明影响的行数不为0，插入成功。
		int flag = tuserMapper.addTuser(tuser);
		
		if(flag > 0)
		{
			ReturnMsg info = new ReturnMsg(1,"添加用户成功！,可通过查看用户界面查看添加情况。");
			return info;
		}
		ReturnMsg info = new ReturnMsg(-1,"添加用户失败，请重试！");
		return info;
	}

	//修改用户信息
	@Override
	public ReturnMsg updateTuser(Tuser tuser) {
		
		//如果flag大于0，则说明影响的行数不为0，修改成功。
		int flag = tuserMapper.modifyTuser(tuser);
				
		if(flag > 0)
		{
			ReturnMsg info = new ReturnMsg(1,"用户信息修改成功！");
			return info;
		}
		
		ReturnMsg info = new ReturnMsg(-1,"用户信息修改失败，请重试！");
		return info;
	}

	//根据用户id查询用户的信息
	@Override
	public Map<String,Object> lookOneTuser(Integer userid) {
				
		return tuserMapper.lookOneTuser(userid);
	}

	//修改用户角色
	@Override
	public ReturnMsg modifyroleid(Tuser tuser) {

		//如果flag大于0，则说明影响的行数不为0，修改成功。
		int flag = tuserMapper.modifyRoleid(tuser);
						
		if(flag > 0)
		{
			ReturnMsg info = new ReturnMsg(1,"用户类型修改成功！");
			return info;
		}
				
		ReturnMsg info = new ReturnMsg(-1,"用户类型修改失败，请重试！");
		return info;
		
	}

	//根据用户id删除用户
	@Override
	public ReturnMsg delTuser(int userid) {
		
		//如果flag大于0，则说明影响的行数不为0，删除成功。
		int flag = tuserMapper.delTuser(userid);
							
		if(flag > 0)
		{
			ReturnMsg info = new ReturnMsg(1,"成功删除该用户！");
			return info;
		}
				
		ReturnMsg info = new ReturnMsg(-1,"删除失败，请重试！");
		return info;
	}

	
	//查询用户名是否可用
	@Override
	public ReturnMsg checkun(String username) {
		
		Tuser findone = tuserMapper.checkun(username);
						
		//如果通过这个用户名查到了某个用户的话，则说明用户名已经被使用了
		if(!Objects.isNull(findone))
		{
			ReturnMsg info = new ReturnMsg(-1,"用户名已存在");
			return info;
		}
						
		ReturnMsg info = new ReturnMsg(1,"√");
		return info;
	}
	
	
	
	
	
	
	
	
	

}
