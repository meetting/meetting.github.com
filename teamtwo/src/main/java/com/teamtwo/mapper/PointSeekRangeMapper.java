package com.teamtwo.mapper;

import java.util.HashMap;
import java.util.List;

public interface PointSeekRangeMapper {

	//通过pointid查询配送范围
	List<HashMap<String, Object>> sbpointid(int pointid);

}
