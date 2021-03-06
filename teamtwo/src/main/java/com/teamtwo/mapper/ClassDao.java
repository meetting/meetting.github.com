package com.teamtwo.mapper;

import java.util.List;

public interface ClassDao {
	
	public void insertClass(com.teamtwo.pojo.Class lclass);
	
	public List<com.teamtwo.pojo.Class> queryClass();
	
	public void updateClass(com.teamtwo.pojo.Class lclass);
	
	public com.teamtwo.pojo.Class queryClassById(Integer classid);
}
