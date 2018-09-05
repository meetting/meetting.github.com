$(function(){
	var pointid = getQueryString('pointid');
	var pointInfoUrl = '/teamtwo/pointadmin/getpointbyid?pointid=';
	var ListUrl = '/teamtwo/chargeadmin/listcharge';
	getlist();
	function getlist(e){
		$.ajax({
			url:ListUrl,
			type:'GET',
			dataType:"json",
			success:function(data){
				if(data.success){
					handleList(data.chargeList);
				}
			}
		});
		
		
		//动态添加配送点信息
		function handleList(data){
			var chargethtml = '';
			var startAddr = '';
			var endAddr ='';
			
			
			data.map(function(item,index){
	
				
				$.getJSON(pointInfoUrl+item.startpoint,function(data){
					if(data.success){
						var point = data.point;
						startAddr = point.pointaddr;
					}
				});
				
				$.getJSON(pointInfoUrl+item.endpotint,function(data){
					if(data.success){
						var point = data.point;
						endAddr = point.pointaddr;
					}
				});

				chargethtml += '<tr><td><input type="checkbox" class="check-true" id="'+item.chargeid+'"></td><td>'
					+ item.startpoint + '</td><td>'
					+ item.endpoint + '</td><td>'
					+ item.firstweight + '公斤以下</td><td>'
					+ item.firstweightprice + '元</td><td>'
					+ item.secondweight + '公斤以上</td><td>'
					+ item.secondweightprice + '元</td><td>'
					+ item.firstvol + '立方米以下</td><td>'
					+ item.firstvolprice + '元</td><td>'
					+ item.secondvol + '立方米以上</td><td>'
					+ item.secondvolprice + '元</td><td>'
					+ chargeStatus(item.chargestate) + '</td><td>'
					+ chargeRemarks(item.chargestate) + '</td><td><a class="button modify" href="/teamtwo/pointadmin/pointaddprice?chargeid='+ item.chargeid +'">修改</a></td></tr>';	
			
				function namePoint(pointid){
					
					$.getJSON(pointInfoUrl+pointid,function(data){
						if(data.success){
							var point = data.point;
							var pointaddr = point.pointaddr;
						}
					});
				}
				
			});
			
			$('#charge-list').html(chargethtml);
		}
		
		
		
		function chargeStatus(status){
			if(status == 1){
				return '通过';
			}else{
				return '未通过';
			}
		}
		function chargeRemarks(status){
			if(status == 0){
				return '审核中';
			}else if(status == -1){
				return '配送价格不合理';
			}else if(status == 1){
				return '审核通过';
			}
		}
		
	}
	
	
	//移除收费标准
	var deleteUrl = '/teamtwo/chargeadmin/removecharge';
	//删除点击事件
	$("#delete-check").click(function(e){

		var target = e.currentTarget;
		var checkedbox = $(".check-true:checked");
		var chargeidList = new Array();

		if(checkedbox.length == 0){
			alert("请选择要删除的行。");
		}else{
			if(confirm('确定删除这'+checkedbox.length+'条配送点信息？')){
					checkedbox.map(function(index,item){
						chargeidList[index] = item.id;
					});
					
					$.ajax({
						url : deleteUrl,
						type : 'POST',
						traditional : true,
						data : {
							chargeidList : chargeidList
						},
						dataType : 'json',
						success : function(data){
							if(data.success){
								getlist("删除成功");
							}else{
								alert("删除失败")
							}
						}
					});
			}
				
		}

	});
	

});