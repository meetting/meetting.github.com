package com.teamtwo;


import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.pojo.Role;
import com.teamtwo.service.RoleService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class RoleTest {
	@Autowired
	private RoleService roleService;
	
	@Test
	public void test1(){
		List<Role> roles = roleService.selectAll();
	}
	

}
