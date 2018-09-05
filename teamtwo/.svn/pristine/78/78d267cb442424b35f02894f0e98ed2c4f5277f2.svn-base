package com.teamtwo.mapper;


//import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.teamtwo.pojo.Charge;

public interface ChargeDao {

	
	//List<HashMap<String,Object>> queryChargeList();
	List<Charge> queryChargeList();

	int batchDeletByid(List<Integer> chargeidIntList);
	
	int insertCharge(Charge charge);

	Charge getByChargeId(int chargeid);

	int updateCharge(Charge charge);
	
	Charge getSeekbyCharge(Charge charge);
	
	int checkChargeResult(@Param("chargeid") int chargeid,@Param("chargestatus") int chargestatus);
}
