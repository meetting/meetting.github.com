$(function(){
    
	var pointid = getQueryString('pointid');
	var isEdit = pointid?true:false;
	//增加页面初始化城市下拉列表
	var initUrl = '/teamtwo/pointadmin/getpointinitinfo';
	var addPointUrl = '/teamtwo/pointadmin/addpoint';
	//通过id，未完成
	var pointInfoUrl = '/teamtwo/pointadmin/getpointbyid?pointid='+pointid;
	var editPointUrl = '/teamtwo/pointadmin/modifypoint';
	var provice = $('#provice');
	var city = $('#city');
	var district = $('#district');
	if(!isEdit){
		getPointInitInfo();
	}else{
		//由id获取信息
		getPointInfo(pointid);
	}
	
	//地址信息加载
	function getPointInitInfo(){
		//将jsp页面中的select id值取出
		var obj_1 = "provice";
		var obj_2 = "city";
		var obj_3 = "district";
		var val_1 = "";
		var val_2 = "";
		var val_3 = "";
		//初始化城市数据
		cityInit(obj_1,val_1,obj_2,val_2,obj_3,val_3);
	}
	
	
	//获取配送点的信息
	function getPointInfo(pointid){
		$.getJSON(pointInfoUrl,function(data){
			if(data.success){
				var point = data.point;
				var pcity = data.pcity;
				$('#pointname').val(point.pointname);
				$('#pointstamp').val(point.pointstamp);
				$('#pointaddr').val(point.pointaddr);
				$('#pointphone').val(point.pointphone);
				$('#icome').val(point.icome);
				
				//城市不可更改
				var tempProviceHtml = '<option data_id="'
					+ pcity.cityid + '"slelected>'
					+ pcity.provice + '</option>';
				
				var tempCityHtml = '<option data_id="'
					+ pcity.cityid + '"slelected>'
					+ pcity.city + '</option>';
				
				var tempDistrictHtml = '<option data_id="'
					+ pcity.cityid + '"slelected>'
					+ pcity.district + '</option>';
			
				//将城市信息动态加载到页面中
				provice.html(tempProviceHtml);
				provice.attr('disabled','disabled');
				city.html(tempCityHtml);
				city.attr('disabled','disabled');
				district.html(tempDistrictHtml);
				district.attr('disabled','disabled');
			}else{
				alert(data.errMsg);
			}
		});
	}
	
	$("#submit").click(function(){
		
		var point = {};
		var pcity = {};
		if(isEdit){
			point.pointid = pointid;
		}
		pcity.provice = provice.find("option:selected").text();
		pcity.city = city.find("option:selected").text();
		pcity.district = district.find("option:selected").text();
		
		point.pointname = $('#pointname').val();
		point.pointstamp = $('#pointstamp').val();
		point.pointaddr = pcity.provice+pcity.city+pcity.district;
				
		point.pointphone = $('#pointphone').val();
		point.icome = $('#icome').val();
		
		
		point.city = pcity;
		
//		var formData = new FormData();
//		formData.append("pointStr",JSON.stringify(point));
		
		$.ajax({
			url:(isEdit?editPointUrl:addPointUrl),
			type:'POST',
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify(point),
			cache:false,
			success:function(data){
				if(data.success){
					alert('提交成功');
				}else{
					alert('提交失败'+ data.errMsg);
				}
			}
		});
		
	});
});