$(function(){
	
	var ListUrl = '/teamtwo/pointadmin/listpointnopage';
	var len = $('table tr');
	getlist();
	function getlist(e){
		$.ajax({
			url:ListUrl,
			type:'GET',
			dataType:"json",
			success:function(data){
				if(data.success){
					handleList(data.pointList);
					handleUser(data.user);
				}
			}
		});
		
		function handleUser(data){
			//显示当前用户
		}
		
		//动态添加配送点信息
		function handleList(data){
			var pointhtml = '';
			data.map(function(item,index){
				pointhtml += '<tr><td><input type="checkbox" class="check-true" id="'+item.pointid+'"></td><td>'
					+ item.pointid + '</td><td>'
					+ item.pointname + '</td><td>'
					+ item.pointstamp + '</td><td>'
					+ item.pointaddr + '</td><td>'
					+ item.pointphone + '</td><td>'
					+ item.icome + '</td><td><a class="button modify" href="/teamtwo/pointadmin/pointadd?pointid='+ item.pointid +'">修改</a></td></tr>';	
			});
			
			$('#point-list').html(pointhtml);
		}
	}
	
	//移除配送点
	var deleteUrl = '/teamtwo/pointadmin/removepoint';
	//删除点击事件
	$("#delete-check").click(function(e){

		var target = e.currentTarget;
		var checkedbox = $(".check-true:checked");
		var pointidList = new Array();

		if(checkedbox.length == 0){
			alert("请选择要删除的行。");
		}else{
			if(confirm('确定删除这'+checkedbox.length+'条配送点信息？')){
					checkedbox.map(function(index,item){
						pointidList[index] = item.id;
					});
					
					$.ajax({
						url : deleteUrl,
						type : 'POST',
						traditional : true,
						data : {
							pointidList : pointidList
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