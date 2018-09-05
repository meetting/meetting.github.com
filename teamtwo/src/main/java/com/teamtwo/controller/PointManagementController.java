package com.teamtwo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamtwo.exceptions.PointOperationException;
import com.teamtwo.pojo.City;
import com.teamtwo.pojo.Point;
import com.teamtwo.service.CityService;
import com.teamtwo.service.PointService;
import com.teamtwo.util.HttpServletRequestUtil;

/**
 * 总公司配送点的控制层
 * @author 经舒媛
 *
 */
@Controller
@RequestMapping("/pointadmin")
public class PointManagementController {

	@Autowired
	private PointService pointService;
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/removepoint",method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Map<String,Object> BatchremovePoint(HttpServletRequest request,String[] pointidList){
		Map<String, Object> modelMap = new HashMap<String,Object>();
		if(pointidList != null && pointidList.length > 0){
			//将串类型转换为整类型
			List<Integer> pointidIntList = ChangeStringtoInteger(pointidList);
			int effectedNum = 0;
			try{
				effectedNum = pointService.batchDeletePoint(pointidIntList);
				if(effectedNum == pointidIntList.size()){
					modelMap.put("success", true);
				}else{
					modelMap.put("success",false);
					modelMap.put("errMsg", effectedNum);
				}
			}catch(PointOperationException e){
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
				return modelMap;
			}
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "要删除的配送点为空");
		}
		return modelMap;
	}
	
private List<Integer> ChangeStringtoInteger(String[] StringList){
		
		List<Integer> integerList = new ArrayList<Integer>();
		
		for(int i = 0;i < StringList.length;i++){
			integerList.add(Integer.parseInt(StringList[i]));
		}
		
		return integerList;
	}
	@RequestMapping(value = "/querypointnamesformobile",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> checkUsername(Model model){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<String> pointnamelist = new ArrayList<String>();
		try{
			pointnamelist = pointService.getPointname();
			model.addAttribute("pointnamelist",pointnamelist);

			modelMap.put("success", true);
			modelMap.put("pointnamelist", pointnamelist);
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
	
	/**
	 * 使用了泛型MAP，modelMap里存储着数据
	 * 获取配�?�点列表
	 * @return
	 */
	@RequestMapping(value = "/listpoint",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> listPoint(){                                                      
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<Point> pointList = new ArrayList<Point>();
		try{
			Point pointCondition = new Point();
			pointList = pointService.getPointList(pointCondition,0,100);
			modelMap.put("success", true);
			modelMap.put("pointList",pointList);
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		
		return modelMap;
	}
	
	@RequestMapping(value = "/listpointnopage",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> listPointNoPage(){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<Point> pointList = null;
		try{
			pointList = pointService.getPointListNoPage();
			modelMap.put("success", true);
			modelMap.put("pointList",pointList);
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		
		return modelMap;
	}
	
	/**
	 * 增加配�?�点
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/addpoint",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addPoint(HttpServletRequest request,@RequestBody Point point) throws IOException{
		Map<String,Object> modelMap = new HashMap<String,Object>();
	
		if(point.getPointname() != null && point.getPointname() != ""){
			boolean bl = false;
			City ci = new City();
			String provice = point.getCity().getProvice();
			String city = point.getCity().getCity();
			String district = point.getCity().getDistrict();
			ci.setProvice(provice);
			ci.setCity(city);
			ci.setDistrict(district);
			try{
				
				int cityid = cityService.selectByPCD(ci);
				if(cityid == 0){
					cityService.addCity(ci);
					cityid = cityService.selectByPCD(ci);
				}
				
				point.getCity().setCityid(cityid);
				bl = pointService.addPoint(point);
				if(bl){
					modelMap.put("success", true);
					
				}else{
					modelMap.put("seccess", false);
					modelMap.put("errMsg", "添加失败");
				}
			}catch(PointOperationException e){
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}catch(Exception e){
				throw new IOException(e.getMessage());
			}
			return modelMap;
			
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入配送点信息");
			return modelMap;
		}
	}


	/**
	 * 修改配�?�点信息
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/modifypoint",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyPoint(HttpServletRequest request,@RequestBody Point point) throws IOException{
		Map<String,Object> modelMap = new HashMap<String,Object>();

		if(point.getPointname() != null && point.getPointname() != ""){
			boolean bl = false;
			try{
				bl = pointService.modifyPoint(point);
				if(bl){
					modelMap.put("success", true);
					
				}else{
					modelMap.put("seccess", false);
					modelMap.put("errMsg", "添加配�?�点失败�?");
				}
			}catch(PointOperationException e){
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}catch(Exception e){
				throw new IOException(e.getMessage());
			}
			return modelMap;
			
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入配送点信息");
			return modelMap;
		}
	}
	
	@RequestMapping(value="/getpointbyid",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String,Object>();
		int pointid = HttpServletRequestUtil.getInt(request, "pointid");
		if(pointid > -1){
			Point point = pointService.getByPointId(pointid);
			City pcity = cityService.getCityById(point.getCity().getCityid());
			
			modelMap.put("point", point);
			modelMap.put("pcity", pcity);
			modelMap.put("success", true);
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty pointid");
		}
		return modelMap;
	}
	
}
