package com.teamtwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamtwo.exceptions.PointOperationException;
import com.teamtwo.mapper.ChargeDao;
import com.teamtwo.pojo.Charge;
import com.teamtwo.service.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService {

	@Autowired
	private ChargeDao chargeDao;
	
	@Override
	public List<Charge> queryChargeList() {
		return chargeDao.queryChargeList();
	}

	@Override
	@Transactional
	public int batchDeletecharge(List<Integer> chargeidIntList) {
		return chargeDao.batchDeletByid(chargeidIntList);
	}

	@Override
	public boolean addCharge(Charge charge) {
		if(charge == null){
			return false;
		}
		try{
			//缁欓厤閫佺偣鍒濆淇℃伅
			int effectedNum = chargeDao.insertCharge(charge);
			if(effectedNum <= 0){
				throw new PointOperationException("娣诲姞鏀惰垂鏍囧噯澶辫触");
			}
			
		}catch(Exception e){
			throw new PointOperationException("addCharge error:"+e.getMessage());
		}
		return true;
	}

	@Override
	public Charge getByChargeId(int chargeid) {
		
		return chargeDao.getByChargeId(chargeid);
	}

	@Override
	public boolean modifyPoint(Charge charge) {
			if(charge == null || charge.getChargeid() == null){
				return false;
			}
			try{
				int effectedNum = chargeDao.updateCharge(charge);
				if(effectedNum <= 0){
					//淇敼杩囩▼涓暟鎹簱鍐呴儴閿欒
					return false;
				}else{
					//鎴愬姛鐨勪慨鏀逛簡閰嶉�佺偣淇℃伅
					return true;
				}
			}catch(Exception e){
				throw new PointOperationException("modifyCharge error:"+e.getMessage());
			}
	}


	@Override
	public Charge getSeekbyCharge(Charge charge) {
		return chargeDao.getSeekbyCharge(charge);
	}

	@Override
	public int checkChargeResult(int chargeid, int chargestatus) {
		return chargeDao.checkChargeResult(chargeid, chargestatus);
	}
	
	
}
