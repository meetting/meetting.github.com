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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamtwo.exceptions.PointOperationException;
import com.teamtwo.pojo.Charge;
import com.teamtwo.service.ChargeService;
import com.teamtwo.util.HttpServletRequestUtil;
import com.teamtwo.util.ListChange;

@Controller
@RequestMapping("/chargeadmin")
public class ChargeManagementController {

	@Autowired
	private ChargeService chargeService;
	
	@RequestMapping(value = "/passcharge",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> CheckChargeResult(HttpServletRequest request,@RequestBody int chargestatus){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		int chargeid = HttpServletRequestUtil.getInt(request, "chargeid");
		if(chargeid >-1){
			try{
				int effectedNum = chargeService.checkChargeResult(chargeid, chargestatus);
				if(effectedNum == 1){
					modelMap.put("success", true);
				}else{
					modelMap.put("success", true);
					modelMap.put("errMsg", "内部错误");
				}
				
			}catch(Exception e){
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
			}
				
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty charge");
		}
		return modelMap;
	}

	
	@RequestMapping(value = "/chargeseek",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> chargeSeek(HttpServletRequest request,@RequestBody Charge charge) throws IOException{
		Map<String,Object> modelMap = new HashMap<String,Object>();

		if(charge != null){
				Charge chargeseek =  chargeService.getSeekbyCharge(charge);
				if(chargeseek != null){
					modelMap.put("success", true);
					modelMap.put("chargeseek", chargeseek);
					
				}else{
					modelMap.put("seccess", false);
					modelMap.put("errMsg", "此配送点未开通");
				}
			return modelMap;
			
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入查询数据");
			return modelMap;
		}
	} 
	
	@RequestMapping(value="/addcharge",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCharge(HttpServletRequest request,@RequestBody Charge charge) throws IOException{
		Map<String,Object> modelMap = new HashMap<String,Object>();

		if(charge != null){
			boolean bl = false;
			try{
				bl = chargeService.addCharge(charge);
				if(bl){
					modelMap.put("success", true);
					
				}else{
					modelMap.put("seccess", false);
					modelMap.put("errMsg", "娣诲姞澶辫触");
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
			modelMap.put("errMsg", "璇疯緭鍏ユ爣鍑嗕俊鎭�");
			return modelMap;
		}
	}
	
	
	@RequestMapping(value="/modifycharge",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyCharge(HttpServletRequest request,@RequestBody Charge charge) throws IOException{
		Map<String,Object> modelMap = new HashMap<String,Object>();

		if(charge.getFirstvol() != null){
			boolean bl = false;
			try{
				bl = chargeService.modifyPoint(charge);
				if(bl){
					modelMap.put("success", true);
					
				}else{
					modelMap.put("seccess", false);
					modelMap.put("errMsg", "娣诲姞閰嶏拷?锟界偣澶辫触锟�?");
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
			modelMap.put("errMsg", "璇疯緭鍏ラ厤閫佺偣淇℃伅");
			return modelMap;
		}
	}
	
	@RequestMapping(value = "/listcharge",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> listCharge(){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<Charge> chargeList = new ArrayList<Charge>();
		try{
			chargeList = chargeService.queryChargeList();
			modelMap.put("success", true);
			modelMap.put("chargeList",chargeList);
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
	
	@RequestMapping(value = "/removecharge",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> BatchremoveCharge(HttpServletRequest request,String[] chargeidList){
		Map<String, Object> modelMap = new HashMap<String,Object>();
		if(chargeidList != null && chargeidList.length > 0){
			//灏嗕覆绫诲瀷杞崲涓烘暣绫诲瀷
			List<Integer> chargeidIntList = ListChange.ChangeStringtoInteger(chargeidList);
			int effectedNum = 0;
			try{
				effectedNum = chargeService.batchDeletecharge(chargeidIntList);
				if(effectedNum == chargeidIntList.size()){
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
			modelMap.put("errMsg", "瑕佸垹闄ょ殑鏍囧噯涓虹┖");
		}
		return modelMap;
	}
	

	@RequestMapping(value="/getchargebyid",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getId(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String,Object>();
		int chargeid = HttpServletRequestUtil.getInt(request, "chargeid");
		if(chargeid > -1){
			Charge charge = chargeService.getByChargeId(1);
			modelMap.put("charge", charge);
			modelMap.put("success", true);
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty chargeid");
		}
		
		return modelMap;
	}
	
		
}
