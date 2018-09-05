package com.teamtwo;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.mapper.JournalingMapper;
import com.teamtwo.service.JournalingService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class JournalingTest {

	@Autowired
	private JournalingMapper journalingMapper;
	@Autowired
	private JournalingService journalingService;
	
	//按年份查询测试
	@Test
	public void selectbyyear()
	{
		List<HashMap<String,Object>> infos = journalingMapper.selectByYear("2018");
		if(!Objects.isNull(infos))
		{
			System.out.println("------------------------不为空-------------------------");
			//遍历每一个配送点
			for (Map<String,Object> info : infos) {
				//遍历每一个配送点提取的报表属性值
				for (String key : info.keySet()) {
			        System.out.println("key= " + key + " and value= " + info.get(key));
			    }
				System.out.println("-------------------------------------------------");
		    }
		}
		else
		{
			System.out.println("--------------------为空----------------");
		}
	}
	
	//按月份查询测试
	//@Test
	public void selectbmonth()
	{
		List<HashMap<String,Object>> infos = journalingMapper.selectByMonth("2018-05");
		if(!Objects.isNull(infos))
		{
			System.out.println("------------------------不为空-------------------------");
			//遍历每一个配送点
			for (Map<String,Object> info : infos) {
				//遍历每一个配送点提取的报表属性值
				for (String key : info.keySet()) {
			        System.out.println("key= " + key + " and value= " + info.get(key));
			    }
				System.out.println("-------------------------------------------------");
		    }
		}
		else
		{
			System.out.println("--------------------为空----------------");
		}
	}
	
		//按季度查询测试
		//@Test
		public void selectbyquarter()
		{
			List<HashMap<String,Object>> infos = journalingService.selectByQuarter("2018-04", "2018-06");
			if(!Objects.isNull(infos))
			{
				System.out.println("------------------------不为空-------------------------");
				//遍历每一个配送点
				for (Map<String,Object> info : infos) {
					//遍历每一个配送点提取的报表属性值
					for (String key : info.keySet()) {
				        System.out.println("key= " + key + " and value= " + info.get(key));
				    }
					System.out.println("-------------------------------------------------");
			    }
			}
			else
			{
				System.out.println("--------------------为空----------------");
			}
		}
		
}
