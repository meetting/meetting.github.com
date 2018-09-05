package com.teamtwo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.teamtwo.pojo.Point;

public interface PointDao {
	
	String getPointaddrbyid(int pointid);
	
	/**
	 * 获取所有配送点的名称
	 * @return
	 */
	List<String> selectPointName();
	
	/**
	 * 查询所有的配送点11
	 * @return
	 */
	List<Point> queryPointListNoPage();
	
	/**
	 * 分页查询配送点，条件：配送点名称（模糊查询），城市
	 * @param pointCondition 有多个参数时要用这个注解唯一标识
	 * @param rowIndex 从第几行开始取数据
	 * @param pageSize 返回的条数
	 * @return
	 */
	List<Point> queryPointList(@Param("pointCondition") Point pointCondition,
			@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);
	
	/**
	 * 增加配送点
	 * @param point
	 */
	int insertPoint(Point point);
	
	/**
	 * 删除配送点
	 * @param pointid
	 */
	int delPoint(int pointid);
	
	/**
	 * 修改配送点
	 * @param point
	 */
    int updatePoint(Point point);
    
    /**
     * 根据id查对应的配送点
     * @param pointid
     * @return
     */
    Point queryByPointId(int pointid);
    
    /**
     * 批量删除配送点数据
     * @param pointidList
     * @return
     */
	int batchDeletByid(List<Integer> pointidList);
	
	
	int getchaerByid(int pointid);

}
