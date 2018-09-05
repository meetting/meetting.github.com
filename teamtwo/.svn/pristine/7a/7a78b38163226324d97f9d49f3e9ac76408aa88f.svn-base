package com.teamtwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.ClassDao;
import com.teamtwo.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDao classDao;
	@Override
	public void addClass(com.teamtwo.pojo.Class lclass) {
		
		classDao.insertClass(lclass);
	}
	
	@Override
	public List<com.teamtwo.pojo.Class> queryClass() {
		
		return classDao.queryClass();
	}
	
	@Override
	public void updateClass(com.teamtwo.pojo.Class lclass){
		
		classDao.updateClass(lclass);
	}
	
	@Override
	public com.teamtwo.pojo.Class queryClassById(Integer classid){
		
		return classDao.queryClassById(classid);
	}
	
}
