package com.teamtwo.service;

import java.util.List;

public interface ClassService {
	
	public void addClass(com.teamtwo.pojo.Class lclass);

	public List<com.teamtwo.pojo.Class> queryClass();
	
	public void updateClass(com.teamtwo.pojo.Class lclass);
	
	public com.teamtwo.pojo.Class queryClassById(Integer classid);
}
