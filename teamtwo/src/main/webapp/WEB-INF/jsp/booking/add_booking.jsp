<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>风尚物流</title>

	<link rel="stylesheet" type="text/css" href="${css}/style.css" />
    <link rel="stylesheet" href="${css}/base.css"> <!--初始化文件-->
    <script src="${include}/js/jquery-1.8.2.js"></script>
    <script src="${include}/js/jquery.min.js"></script>

</head>
<body>

<div class="someinformation">
    <div class="pagemain">
        <div class="big2">
            <p class="tit">订单&nbsp/&nbsp新增订单</p>
            <hr>
            <form action="addbookinginfo" method="post">
                <table>
                     <tr style="display:none">
                        <td style="width: 60%;text-align: center">
                            顾客id
                        </td>
                        <td style="width: 40%">
                            <input type="text" name="customid" value="2" readonly>
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                           发件地 
                        </td>
                        <td style="width: 40%;">
                            <input type="text" name="startaddr">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            下单时间
                        </td>
                        <td style="width: 40%;">
                            <input type="text" id="sendtime" name="sendtime" readonly>
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            发件人姓名
                        </td>
                        <td style="width: 40%;">
                            <input type="text" name="sendname" value="${returnTuser.username }">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            发件人电话
                        </td>
                        <td style="width: 40%;">
                            <input type="text" name="sendphone">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: center">
                            收件地
                        </td>
                        <td>
                            <input type="text" name="endaddr">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            收件人姓名
                        </td>
                        <td style="width: 40%;">
                            <input type="text" name="recvname">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            收件人电话
                        </td>
                        <td style="width: 40%;">
                            <input type="text" name="recvphone">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            发货配送点
                        </td>
                        <td style="width: 40%;">
                            <select id="selectedstartpoint" name="startpointid">                                    
                                    <option value="---请选择始发地---" selected>--请选择始发地--</option>
                                    <c:forEach items="${startpointnames}" var="startpointname" begin="0" >
                                    <option value="${startpointname.startpointid}">${startpointname.pointnameaddr} </option>
                                    </c:forEach>
                                </select>      
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            收货配送点
                        </td>
                        <td style="width: 40%;">
                            <select id="selectedendpoint" name="endpointid">
                                    <option value="--请选择目的地--" selected>--请选择目的地--</option>
                            </select>   
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 60%;text-align: center">
                            计费方式
                        </td>
                        <td style="width: 40%;">
                            <input type="radio" name="countstyle" id="countstyle" value="重量计费">重量计费&nbsp;&nbsp;
                            <input type="radio" name="countstyle" id="countstyle" value="体积计费">体积计费
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            物品质量
                        </td>
                        <td style="width: 40%;">
                            <input type="text" id="weight" name="weight">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            物品体积
                        </td>
                        <td style="width: 40%;">
                            <input type="text" id="volume" name="volume">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            物品计费
                        </td>
                        <td style="width: 40%;">
                            <input type="text" name="cost" id="cost" readonly>
                        </td>
                    </tr>
                    <tr style="display:none">
                        <td style="text-align: center">
                            订单状态
                        </td>
                        <td>
                            <input type="text" name="statev" value="待审核">
                        </td>
                    </tr>
                     <tr>
                        <td style="width: 60%;text-align: center">
                            描述
                        </td>
                        <td style="width: 40%;">
                            <textarea style="border:solid 1px" rows="6" cols="40" name="describeo">
							
							</textarea>

                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td style="float: right">
                            <input type="submit" value="提交">
                            <input type="reset" value="重写">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script text="type/javascript">
$(document).ready(function() {
	    //获取当前时间
		var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	           /*  + " " + date.getHours() + seperator2 + date.getMinutes()
	            + seperator2 + date.getSeconds(); */
	    $("#sendtime").attr("value",currentdate);

 
	  $("#selectedstartpoint").on("blur",function(){			
		 var startpointid = $(this).val();		
		 $("#selectedendpoint").empty();
		 $("#selectedendpoint").append("<option value='"+"----请选择目的地----"+"'>----请选择目的地----</option>");
		 $.ajax({
			   type: "post",
			   url: "getendpointnames",
			   data:"startpointid="+startpointid,
			   async:true,
			   success: function(endpointnames){
				   for(var i=0;i<endpointnames.length;i++){	  
					   $("#selectedendpoint").append("<option value='"+endpointnames[i].endpointid+"'>"+endpointnames[i].pointnameaddr+"</option>");
				   }
			   }
		});
	  })
	  
	  $('input[type=radio][name=countstyle]').on("change",function(){
		  $("#weight").val("");
		  $("#volume").val("");
		  $("#cost").attr("value","");
	  }) 
	  
	  //此处有严重bug,如果输入好收货配送点后又倒回去重选起始配送点，便会产生逻辑错误
	  $("#weight").on("change",function(){	
		 var startpointid=  $("#selectedstartpoint").find("option:selected").val();
		 var endpointid=  $("#selectedendpoint").find("option:selected").val();
		 var weight = $("#weight").val();
		 var volume = $(this).val();
		 var countstyle=$('input[name="countstyle"]:checked').val();
		 var cost=0;
		  $.ajax({
			   type: "post",
			   url: "querychargeinfo?startpointid="+startpointid+"&endpointid="+endpointid,
			   async:true,
			   success: function(resultset){
				   if(countstyle=="重量计费"){
					   /* $("#volume").attr("readonly",true);
					   $("#weight").attr("readonly",false); */
					   if(0<weight&&weight<=resultset.firstweight)
						   cost=resultset.firstweightprice;
					   else
						   cost=resultset.firstweightprice+(weight-resultset.firstweight)*resultset.secondweightprice;
				   }
				   if(countstyle=="体积计费"){
					   /* $("#volume").attr("readonly",false);
					   $("#weight").attr("readonly",true); */
					   if(0<volume&&volume<=resultset.firstvol)
						   cost=resultset.firstvolprice;
					   else
						   cost=resultset.firstvolprice+(volume-resultset.firstvol)*resultset.secondvolprice;
				   }
				   $("#cost").attr("value",cost);
			   }
		}); 
	  })
		  
	  $("#volume").on("change",function(){	
		 var startpointid=  $("#selectedstartpoint").find("option:selected").val();
		 var endpointid=  $("#selectedendpoint").find("option:selected").val();
		 var weight = $("#weight").val();
		 var volume = $(this).val();
		 var countstyle=$('input[name="countstyle"]:checked').val();
		 var cost=0;
		  $.ajax({
			   type: "post",
			   url: "querychargeinfo?startpointid="+startpointid+"&endpointid="+endpointid,
			   async:true,
			   success: function(resultset){
				   if(countstyle=="重量计费"){
					  /*  $("#volume").attr("readonly",true);
					   $("#weight").attr("readonly",false); */
					   if(0<weight&&weight<=resultset.firstweight)
						   cost=resultset.firstweightprice;
					   else
						   cost=resultset.firstweightprice+(weight-resultset.firstweight)*resultset.secondweightprice;
				   }
				   if(countstyle=="体积计费"){
					   /* $("#volume").attr("readonly",false);
					   $("#weight").attr("readonly",true); */
					   if(0<volume&&volume<=resultset.firstvol)
						   cost=resultset.firstvolprice;
					   else
						   cost=resultset.firstvolprice+(volume-resultset.firstvol)*resultset.secondvolprice;
				   }
				   $("#cost").attr("value",cost);
			   }
		}); 
	  }) 
})

</script>
</body>

</html>