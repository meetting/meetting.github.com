$(function(){
    
	var chargeid = getQueryString('chargeid');
	var isEdit = chargeid?true:false;
	//增加页面初始化城市下拉列表
	var initUrl = '/teamtwo/pointadmin/listpoint';
	var addChargeUrl = '/teamtwo/chargeadmin/addcharge';
	//通过id，未完成
	var chargeInfoUrl = '/teamtwo/chargeadmin/getchargebyid?chargeid='+chargeid;
	var editChargeUrl = '/teamtwo/chargeadmin/modifycharge';
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
	
	
	//获取配送点的信息
	function getChargeInfo(chargeid){
		$.getJSON(chargeInfoUrl,function(data){
			if(data.success){
				var charge = data.charge;
				
				$('#firstweight').val(charge.firstweight);
				$('#firstweightprice').val(charge.firstweightprice);
				$('#secondweight').val(charge.secondweight);
				$('#secondweightprice').val(charge.secondweightprice);
				$('#firstvol').val(charge.firstvol);
				$('#firstvolprice').val(charge.firstvolprice);
				$('#secondvol').val(charge.firstvolprice);
				$('#secondvolprice').val(charge.secondvolprice);
				//不可更改
				var startpointHtml = '<option value="'
					+ charge.startpoint + '"slelected>'
					+ charge.startpoint + '</option>';
				
				var endpointHtml = '<option value="'
					+ charge.endpoint + '"slelected>'
					+ charge.endpoint + '</option>';
			
				//将信息动态加载到页面中
				$('#startpoint').html(startpointHtml);
				$('#startpoint').attr('disabled','disabled');
				$('#endpoint').html(endpointHtml);
				$('#endpoint').attr('disabled','disabled');
				
			}else{
				alert(data.errMsg);
			}
		});
		
		function namePoint(pointid){
			$.getJSON(pointInfoUrl+pointid,function(data){
				if(data.success){
					var point = data.point;
					return point.pointaddr;
				}
			});
		}
		
	}
	
	$("#submit").click(function(){
		
		var charge = {};
		if(isEdit){
			charge.chargeid = chargeid;
		}
		
		charge.startpoint =$('#startpoint').find("option:selected").val();
		charge.endpoint =$('#endpoint').find("option:selected").val();
		charge.firstweight = $('#firstweight').val();
		charge.firstweightprice = $('#firstweightprice').val();
		charge.secondweight = $('#secondweight').val();
		charge.secondweightprice = $('#secondweightprice').val();
		charge.firstvol = $('#firstvol').val();
		charge.firstvolprice = $('#firstvolprice').val();
		charge.secondvol = $('#secondvol').val();
		charge.secondvolprice = $('#secondvolprice').val();
		
		$.ajax({
			url:(isEdit?editChargeUrl:addChargeUrl),
			type:'POST',
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify(charge),
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