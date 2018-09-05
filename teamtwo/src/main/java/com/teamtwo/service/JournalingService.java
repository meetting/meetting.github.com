package com.teamtwo.service;

import java.util.HashMap;
import java.util.List;

import com.teamtwo.util.ReturnMsg;

public interface JournalingService {

	List<HashMap<String, Object>> selectByYear(String startYear);

	List<HashMap<String, Object>> selectByMonth(String startMonth);
	
	List<HashMap<String, Object>> selectByQuarter(String startt,String endt);
}
