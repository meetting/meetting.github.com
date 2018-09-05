package com.teamtwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.exceptions.PointOperationException;
import com.teamtwo.mapper.PointDao;
import com.teamtwo.pojo.Point;
import com.teamtwo.service.PointService;
import com.teamtwo.util.PageCalculator;

@Service
public class PointServiceImpl implements PointService {
	@Autowired
	private PointDao pointDao;

	@Override
	public boolean addPoint(Point point) throws PointOperationException{
		if(point == null){
			return false;
		}
		try{
			//给配送点初始信息
			int effectedNum = pointDao.insertPoint(point);
			if(effectedNum <= 0){
				throw new PointOperationException("添加配送点失败");
			}
			
		}catch(Exception e){
			throw new PointOperationException("addPoint error:"+e.getMessage());
		}
		return true;
	}

	
	@Override
	public boolean modifyPoint(Point point) throws PointOperationException {
		if(point == null || point.getPointid() == null){
			return false;
		}
		try{
			int effectedNum = pointDao.updatePoint(point);
			if(effectedNum <= 0){
				//修改过程中数据库内部错误
				return false;
			}else{
				//成功的修改了配送点信息
				return true;
			}
		}catch(Exception e){
			throw new PointOperationException("modifyPoint error:"+e.getMessage());
		}
		
	}

	@Override
	public List<Point> getPointList(Point pointCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Point> pointList = pointDao.queryPointList(pointCondition, rowIndex, pageSize);
		if(pointList != null){
			return pointList;
		}
		return null;
	}


	@Override
	public Point getByPointId(int pointid) {
		return pointDao.queryByPointId(pointid);
	}

	@Override
	public List<String> getPointname() {
		return pointDao.selectPointName();
	}

	//11
	@Override
	public List<Point> getPointListNoPage() {
		return pointDao.queryPointListNoPage();
	}


	@Override
	public int batchDeletePoint(List<Integer> pointidList) {
		return pointDao.batchDeletByid(pointidList);
	}


}
