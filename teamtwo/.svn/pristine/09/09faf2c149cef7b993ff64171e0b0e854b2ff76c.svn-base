$(function(){
    
	var chargeid = getQueryString('chargeid');
	var isEdit = chargeid?true:false;
	//增加页面初始化城市下拉列表
	var initUrl = '/teamtwo/pointadmin/listpoint';
	var chargeseekUrl = '/teamtwo/chargeadmin/chargeseek';
	var pointInfoUrl = '/teamtwo/pointadmin/getpointbyid?pointid=';
	if(!isEdit){
		getChargeInitInfo();
	}else{
		//由id获取信息
		getChargeInfo(chargeid);
	}
	
	//地址信息加载
	function getChargeInitInfo(){
		$.getJSON(initUrl,function(data){
			
			if(data.success){
				var tempStartHtml = '';
				var temEndHtml = '';
				
				data.pointList.map(function(item,index){
					tempStartHtml += '<option value="'+ item.pointid +'">'+item.pointaddr + '</option>';
					temEndHtml += '<option value="'+ item.pointid +'">'+item.pointaddr + '</option>';
				});
				
				//动态引入到下拉选择框中
				$('#startpoint').html(tempStartHtml);
				$('#endpoint').html(temEndHtml);
			}else{
				alert(data.errMsg);
			}
		});
	}
	
	$("#submit").click(function(){
		
		var charge = {};
		charge.startpoint =$('#startpoint').find("option:selected").val();
		charge.endpoint =$('#endpoint').find("option:selected").val();
		
		$.ajax({
			url:chargeseekUrl,
			type:'POST',
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify(charge),
			cache:false,
			success:function(data){
				if(data.success){
					
					//待续
					alert('查询成功   首公斤：'+data.chargeseek.firstweight+'首公斤价格：'+data.chargeseek.firstweightprice+'次公斤：'+data.chargeseek.secondweight+'次公斤价格：'+data.chargeseek.secondweightprice+'首立方：'+data.chargeseek.firstvol+'首立方价格：'+data.chargeseek.firstvolprice+'次立方：'+data.chargeseek.secondvol+'次立方价格：'+data.chargeseek.secondvolprice);
				}else{
					alert('查询失败'+ data.errMsg);
				}
			}
		});
		
	});
});