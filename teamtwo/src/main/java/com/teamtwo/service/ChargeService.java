package com.teamtwo.service;

import java.util.List;

import com.teamtwo.pojo.Charge;

public interface ChargeService {

	/**
	 * 查询收费
	 * @return
	 */
	List<Charge> queryChargeList();

	int batchDeletecharge(List<Integer> chargeidIntList);
	
	boolean addCharge(Charge charge);

	Charge getByChargeId(int chargeid);

	boolean modifyPoint(Charge charge);
	
	Charge getSeekbyCharge(Charge charge);
	
	int checkChargeResult(int chargeid,int chargestatus);
}
