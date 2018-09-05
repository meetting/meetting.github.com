package com.teamtwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.AutoMobileDao;
import com.teamtwo.pojo.Automobile;
import com.teamtwo.service.AutoMobileService;

@Service
public class AutoMobileServiceImpl implements AutoMobileService {

	@Autowired
	private AutoMobileDao automobileDao;
	
	@Override
	public void addAutomobile(Automobile automobile) {
	
		automobileDao.addMobile(automobile);
	}
	
	@Override
	public List<Automobile> queryAutomobile(){
		return automobileDao.queryMobile();
	}
	
	@Override
	public void modifyAutomobile(Automobile automobile) {
	
		automobileDao.modifyMobile(automobile);
	}
	
	@Override
	public Automobile queryMobileById(Integer automobileid){
		return automobileDao.queryMobileById(automobileid);
	}
}
