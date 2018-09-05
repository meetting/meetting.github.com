<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <div class="big1">
                <p class="tit">交接表&nbsp/&nbsp查询交接表</p>
                <hr>
                <form action="#" method="post">
                    <table >
                        <tr>
                            <td style="width: 20%;text-align: center">
                                交接单号
                            </td>
                            <td style="width: 15%">
                                <select id="joinid" name="">
                                <option value="请选择交接单号">--请选择交接单号--</option>
                                <c:forEach items="${OrderByJoinIds}" var="id" begin="0">
                                <option value="${id }">${id }</option>
                                </c:forEach>
                                </select>
                            </td>
                            <td style="width: 15%;text-align: center">
                                始发地
                            </td>
                            <td style="width: 15%">
                                <input id="startpointname" type="text" name="" value="  ">
                            </td>
                            <td style="width: 20%;text-align: center">
                                目的地
                            </td>
                            <td style="width: 15%">
                                <input id="endpointname" type="text" name="" value="  ">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                日期
                            </td>
                            <td >
                                <input id="jointime" type="text" name="" value="  ">
                            </td>
                            <td style="text-align: center">
                               车辆编号
                            </td>
                            <td>
                                <input id="automobileid" type="text" name="" value="  ">
                            </td>
                            <td style="width: 20%;text-align: center">
                                承运人签名：
                            </td>
                            <td>
                            </td>
                        </tr>
                    </table>
                    <hr>
                    <table >
                        <tr>
                            <td style="width: 60%">
                                订单号(列出的是已绑定订单，勾选订单号可删除)：
                            </td>
                            <td style="width: 40%">
                                接收人签名：
                            </td>
                        </tr>
                        <tr>
                            <td  id="orderids" style="width: 60%;">
                               
                            </td>
                            <td style="width: 40%">
                                <input type="hidden" name="" value="zhanwei" ></input>
                            </td>
                        </tr>
                    </table>
                    <hr>
                    <input id="deleteorderid" type="button" style="float: right;width:100px;" value="删除订单号">
                    <input type="hidden" style="float: right;width:100px;" value="打印交接单">
                </form>
            </div>
        </div>
    </div>
    
 <script type="text/javascript">
 $(document).ready(function() {
	  $("#joinid").on("change",function(){	
		 var joinid = $(this).val();
		 $("#startpointname").attr("value"," ");
		 $("#endpointname").attr("value"," ");
		 $("#jointime").attr("value"," ");
		 $("#automobileid").attr("value"," "); 
		  $.ajax({
			   type: "post",
			   url: "getjoininfo",
			   data:"joinid="+joinid,
			   async:true,
			   success: function(joininfo){
				   $("#startpointname").attr("value",joininfo.startpointname);
				   $("#endpointname").attr("value",joininfo.endpointname);
				   $("#jointime").attr("value",joininfo.jointime);
				   $("#automobileid").attr("value",joininfo.automobileid); 
				   
				   //这里有一个bug：显示的订单号只有一个,且还应显示绑定的班次id，应该有多个，相应的删除方法也由bug，若要更改，应用orderbyjoinid进行唯一标识
				   $("#orderids").empty();
				   if(joininfo.orderid)
				   $("#orderids").append("<input id='orderid' type='checkbox' value='"+joininfo.orderid+"' >"+joininfo.orderid+"</input><br>"); 
			   }
		});  
		  
		   $("#deleteorderid").on("click",function(){	
				 var orderid=$("#orderid").val();
				      $.ajax({
					   type: "post",
					   contentType:"application/json",
					   url: "deletejoinorderid?joinid="+joinid+"&orderid="+orderid, 
					   async:true,
					   success: function(){
						   alert("删除成功！");
						   $("#orderids").empty();
					   } 
				});   
			  }) 
	  })
	  
	 
 })
 </script>
</body>
</html>