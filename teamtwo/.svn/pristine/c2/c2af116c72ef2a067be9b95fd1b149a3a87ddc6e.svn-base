$(function(){
    
	var chargeid = getQueryString('chargeid');
	var chargestatus = 0;
	//通过id，未完成
	var chargeInfoUrl = '/teamtwo/chargeadmin/getchargebyid?chargeid='+chargeid;
	
	var pointInfoUrl = '/teamtwo/pointadmin/getpointbyid?pointid=';
	var checkResultUrl = '/teamtwo/chargeadmin/passcharge?chargeid=';
	
	getChargeInfo(chargeid);
	//获取信息
	function getChargeInfo(chargeid){
		$.getJSON(chargeInfoUrl,function(data){
			if(data.success){
				var charge = data.charge;
				
				$('#startpoint').val(namePoint(charge.startpoint));
				$('#endpoint').val(namePoint(charge.endpoint));
				$('#firstweight').val(charge.firstweight);
				$('#firstweightprice').val(charge.firstweightprice);
				$('#secondweight').val(charge.secondweight);
				$('#secondweightprice').val(charge.secondweightprice);
				$('#firstvol').val(charge.firstvol);
				$('#firstvolprice').val(charge.firstvolprice);
				$('#secondvol').val(charge.firstvolprice);
				$('#secondvolprice').val(charge.secondvolprice);
				
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
	
//	if($("#pass").click){
//		chargestatus = 1;
//	}else if($("#nopass").click){
//		chargestatus = -1;
//	}
//	
	$("#pass").click(function(){
		chargestatus = 1;
		var charge = {};
		$.ajax({
			url:checkResultUrl+chargeid,
			type:'POST',
			contentType: "application/json; charset=utf-8",
			data:{
				chargestatus : chargestatus
			},
			cache:false,
			success:function(data){
				if(data.success){
					alert('审核成功');
				}else{
					alert('审核失败'+ data.errMsg);
				}
			}
		});
		
	});
	
	$("#nopass").click(function(){
		chargestatus = -1;
		var charge = {};
		$.ajax({
			url:checkResultUrl+chargeid,
			type:'POST',
			contentType: "application/json; charset=utf-8",
			data:{
				chargestatus : chargestatus
			},
			cache:false,
			success:function(data){
				if(data.success){
					alert('审核成功');
				}else{
					alert('审核失败'+ data.errMsg);
				}
			}
		});
		
	});
});