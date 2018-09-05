package com.teamtwo.service;

import java.util.List;

import com.teamtwo.pojo.Point;

public interface PointService {
	
	/**
	 * 获取配送点列表无条件11
	 * @return
	 */
	List<Point> getPointListNoPage();
	
	/**
	 * 配送点名称
	 * @return
	 */
	List<String> getPointname();
	
	
	/**
	 * 获取配送点列表分页
	 * @return
	 */
	List<Point> getPointList(Point pointCondition,int pageIndex,int pageSize);

	/**
	 * 添加配送点
	 * @param point
	 * @return
	 */
	boolean addPoint(Point point);
	
	/**
	 * 修改配送点信息
	 * @param point
	 * @return
	 */
	boolean modifyPoint(Point point);
	
	/**
	 * 根据id获取配送点
	 * @param point
	 * @return
	 */
	Point getByPointId(int point);
	
	/**
	 * 批量删除配送点信息
	 * @param pointidList
	 * @return 影响的行数
	 */
	int batchDeletePoint(List<Integer> pointidList);
}
