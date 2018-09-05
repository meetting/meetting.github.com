package com.teamtwo.service;

import java.util.List;

import com.teamtwo.pojo.Automobile;

public interface AutoMobileService {

	public void addAutomobile(Automobile automobile);
	
	public List<Automobile> queryAutomobile();
	
	public void modifyAutomobile(Automobile automobile);
	
	public Automobile queryMobileById(Integer automobileid);
}
