package com.teamtwo.mapper;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.teamtwo.BaseTest;
import com.teamtwo.pojo.Charge;
import com.teamtwo.service.ChargeService;


public class ChargeDaoTest extends BaseTest {

	 @Autowired
	 private ChargeDao chargeDao;
	 @Autowired
	 private ChargeService chargeService;
	 @Test
	 public void testgetSeekbyCharge(){
		 Charge charge = new Charge();
		 charge.setEndpotint(3);
		 charge.setStartpoint(1);
		 Charge chargeseek = chargeService.getSeekbyCharge(charge);
		 System.out.println(chargeseek.getChargeid());
	 }

	 
	 
	 @Test
	 //@Ignore
	public void testgetByChargeId(){
		 
		 Charge charge = chargeService.getByChargeId(1);
		 System.out.println(charge.getFirstvol());
	 }
	 
	 @Test
	 @Ignore
	 public void testQueryChargeList(){
		 
		 List<Charge> chargelist = chargeDao.queryChargeList();
		 assertEquals("1",chargelist.get(0).getChargeid());
		 
	 }
	
}
