package com.teamtwo;


import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.print.attribute.standard.RequestingUserName;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.controller.PointSeekRangeController;
import com.teamtwo.mapper.TuserMapper;
import com.teamtwo.pojo.Role;
import com.teamtwo.pojo.Tuser;
import com.teamtwo.service.PointSeekRangeService;
import com.teamtwo.service.RoleService;
import com.teamtwo.service.TuserService;
import com.teamtwo.util.ReturnMsg;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class TuserTest {
	
	@Autowired
	private TuserMapper tuserMapper;
	@Autowired
	private TuserService tuserService;
	@Autowired
	private PointSeekRangeService pointSeekRangeService;

	//登录验证测试
	//@Test 
	public void loginTest()
	{
		Tuser tuser = new Tuser();
		tuser.setUsername("root");
		tuser.setPassword("root");
		
		Map<String,Object> ur = tuserService.checkTuser(tuser);
		if(!Objects.isNull(ur))
		{
			//System.out.println(Integer.parseInt(ur.get("userid").toString()) + ur.get("username") + ur.get("rolename"));
			System.out.println("------------------------不为空-------------------------");
			for (String key : ur.keySet()) {
		        System.out.println("key= " + key + " and value= " + ur.get(key));
		    }
		}
		
		else{System.out.println("--------------------为空----------------");}
	
	}
	
	//查询用户测试
	//@Test
	public void findTuserTest()
	{
		List<HashMap<String, Object>> allTusers = tuserService.selectAllTuser();
		
		if(!Objects.isNull(allTusers))
		{
			System.out.println("------------------------不为空-------------------------");
			//遍历每一个用户
			for (Map<String,Object> tuser : allTusers) {
				//遍历每一个用户的属性值
				for (String key : tuser.keySet()) {
			        System.out.println("key= " + key + " and value= " + tuser.get(key));
			    }
				System.out.println("-------------------------------------------------");
		    }
			
		}
	}
	
	//增加用户测试
	//@Test
	public void addTuserTest()
	{
		Tuser tuser = new Tuser();
		tuser.setPointid(1);
		tuser.setRoleid(1);
		tuser.setUsername("cs");
		tuser.setPassword("cs");
		tuser.setTel("27");
		tuser.setAddr("重庆");
		tuser.setRealname("谁呢");
		
		ReturnMsg msg =  tuserService.addTuser(tuser);
		
		if(!Objects.isNull(msg))
		{
			System.out.println("------------------------不为空-------------------------");
			System.out.println(msg.getStatus());
			System.out.println(msg.getMsg());
			
		}
	}
	
	//修改用户信息测试
	//@Test
	public void modifyTuser()
	{

		Tuser tuser = new Tuser();
		tuser.setUserid(12);
		tuser.setPointid(1);
		tuser.setUsername("ics");
		tuser.setPassword("ics");
		tuser.setTel("1271");
		tuser.setAddr("重庆");
		tuser.setRealname("爱你哦");
		
		ReturnMsg msg =  tuserService.updateTuser(tuser);
		
		if(!Objects.isNull(msg))
		{
			System.out.println("------------------------不为空-------------------------");
			System.out.println(msg.getStatus());
			System.out.println(msg.getMsg());	
		}
		
	}

	//按userid查询用户信息测试
	@Test
	public void lookOneTuser()
	{
		Map<String,Object> my2 = tuserMapper.lookOneTuser(12);
		if(!Objects.isNull(my2))
		{
			System.out.println("------------------------不为空-------------------------");
			for (String key : my2.keySet()) {
		        System.out.println("key= " + key + " and value= " + my2.get(key));
		    }
		}
		else
		{
			System.out.println("--------------------为空----------------");
		}
		
		Map<String,Object> my = tuserService.lookOneTuser(2);
		if(!Objects.isNull(my))
		{
			System.out.println("------------------------不为空-------------------------");
			for (String key : my.keySet()) {
		        System.out.println("key= " + key + " and value= " + my.get(key));
		    }
		}
		else
		{
			System.out.println("--------------------为空----------------");
		}
	}

	//修改用户roid
	//@Test
	public void modifyRoleid()
	{
		Tuser tuser = new Tuser();
		tuser.setUserid(11);
		tuser.setRoleid(2);

		//更新情况
		ReturnMsg info = tuserService.modifyroleid(tuser);

		if(!Objects.isNull(info))
		{
			System.out.println("------------------------不为空-------------------------");
			System.out.println(info.getStatus());
			System.out.println(info.getMsg());
			
		}
	}
	
	//查询用户名是否可用测试
	//@Test
	public void checkun()
	{
		Tuser tuser = tuserMapper.checkun("cs");

		if(!Objects.isNull(tuser))
		{
			System.out.println("------------------------不为空-------------------------");
		}
		else{
			System.out.println("------------------------空-------------------------");
		}
	}
	
	//通过pointid查询配送范围测试
	@Test
	public void psr()
	{
		List<HashMap<String,Object>> results = pointSeekRangeService.sbpointid(20);

		if(!Objects.isNull(results))
		{
			System.out.println("------------------------不为空-------------------------");
			//遍历每一个用户
			for (Map<String,Object> one : results) {
				//遍历每一个用户的属性值
				for (String key : one.keySet()) {
			        System.out.println("key= " + key + " and value= " + one.get(key));
			    }
				System.out.println("-------------------------------------------------");
		    }
			
		}
	}
		

}
