package com.teamtwo.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BookingDao {

	public List<Map<String,Object>> queryBookingInfo();
	
	public Map<String,Object> queryChargeInfo(@Param("startpointid")Integer startpointid,@Param("endpointid")Integer endpointid);
    
	public void addBookingInfo(@Param("customid")Integer customid,@Param("startaddr")String startaddr,@Param("sendtime")Date sendtime,
			@Param("sendname")String sendname,@Param("sendphone")String sendphone,@Param("endaddr")String endaddr,@Param("recvname")String recvname,
			@Param("recvphone")String recvphone,@Param("startpointid")Integer startpointid,@Param("endpointid")Integer endpointid,
			@Param("weight")double weight,@Param("volume")double volume,@Param("cost")double cost,@Param("statev")String statev,
			@Param("describeo")String describeo);
	
	/*public void addBookingInfo(@Param("customid")Integer customid,@Param("startaddr")String startaddr,@Param("sendtime")Date sendtime,
			@Param("sendname")String sendname,@Param("sendphone")String sendphone,@Param("endaddr")String endaddr,@Param("recvname")String recvname);*/
    
	public Map<String,Object> modifyBookingInfo(@Param("orderid")Integer orderid);
	
	public void updateBookingInfo(@Param("orderid")Integer orderid,@Param("customid")Integer customid,@Param("startaddr")String startaddr,@Param("sendtime")Date sendtime,
			@Param("sendname")String sendname,@Param("sendphone")String sendphone,@Param("endaddr")String endaddr,@Param("recvname")String recvname,
			@Param("recvphone")String recvphone,@Param("startpointid")Integer startpointid,@Param("endpointid")Integer endpointid,
			@Param("weight")double weight,@Param("volume")double volume,@Param("cost")double cost,@Param("statev")String statev,
			@Param("describeo")String describeo);

}
