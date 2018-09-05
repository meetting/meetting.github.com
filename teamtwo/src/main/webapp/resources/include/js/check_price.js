$(function(){
	
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
			data.map(function(item,index){
				if(item.chargestate == 0){
					chargethtml += '<tr id="'+item.chargeid+'"><td>'
					+ item.startpoint + '</td><td>'
					+ item.endpoint + '</td><td>'
					+ item.firstweight + '公斤以下</td><td>'
					+ item.firstweightprice + '元</td><td>'
					+ item.secondweight + '公斤以上</td><td>'
					+ item.secondweightprice + '元</td><td>'
					+ item.firstvol + '立方米以下</td><td>'
					+ item.firstvolprice + '元</td><td>'
					+ item.secondvol + '立方米以上</td><td>'
					+ item.secondvolprice + '元</td><td><a class="button modify" href="/teamtwo/pointadmin/checkpricecheck?chargeid='+ item.chargeid +'">审核</a></td></tr>';	
				}
				
			});
			
			$('#price-check').html(chargethtml);
		}
		
		function namePoint(pointid){
			$.getJSON(pointInfoUrl+pointid,function(data){
				if(data.success){
					var point = data.point;
					return point.pointaddr;
				}
			});
		}
		
		
	}
});