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
    <link rel="stylesheet" href="${css}/bootstrap.min.css">

    <script src="${include}/js/laydate/laydate.js"></script> <!--主样式-->
    <script src="${include}/js/timejs.js"></script>
    <script src="${include}/js/jquery-1.8.2.js"></script>
    <script src="${include}/js/jquery.min.js"></script>
    <script src="${include}/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="someinformation">
        <div class="pagemain">
            <div class="big2">
                <p class="tit">交接单&nbsp/&nbsp生成交接单</p>
                <hr>
                <form action="jiaojiebiao_add" method="post">
                    <table style="width: 50vw;">
                        <tr>
                            <td style="width: 25%;text-align: center">
                                始发地
                            </td>                           
                            <td style="width: 25%">                        
                                <select id="selectedstartpoint" name="startpointid">                                    
                                    <option value="--请选择始发地--" selected>--请选择始发地--</option>
                                    <c:forEach items="${startpointnames}" var="startpointname" begin="0" >
                                    <option value="${startpointname.startpointid}">${startpointname.pointnameaddr} </option>
                                    </c:forEach>
                                </select>                           
                            </td>
                            <td style="width: 25%;text-align: center">
                                目的地
                            </td>
                            <td style="width: 25%">
                                <select id="selectedendpoint" name="endpointid">
                                    <option value="--请选择目的地--" selected>--请选择目的地--</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center;width: 25%" >
                               日期
                            </td>
                            <td style="text-align: center;width: 25%">
                                <input type="text" name="jointime">
                            </td>
                            <td style="text-align: center;width: 25%">
                                运输车号
                            </td>
                            <td style="text-align: center;width: 25%">
                                <input type="text" name="automobileid">
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>
                        <tr>
                            <td >
                            </td>
                            <td>
                            </td>
                            <td >
                            </td>
                            <td style="float: right">
                                <input type="submit" value="提交">
                                <input type="reset" value="重写">
                            </td>
                        </tr>

                    </table>

                </form>
                
                <c:if test="${not empty joinlist}">
                <form action="#" method="get">
                    <table style="text-align: center;width: 70vw;">
                        <tr >
                            <th style="width: 10%;text-align: center;" >
                                交接单编号
                            </th>
                            <th style="width: 20%;text-align: center;">
                                发货配送点
                            </th>
                            <th style="width: 20%;text-align: center;">
                                收货配送点
                            </th>
                            <th style="width: 20%;text-align: center;">
                                日期
                            </th>
                            <th style="width: 10%;text-align: center;">
                                运输车号
                            </th>                        
                            <th style="width: 20%;text-align: center;">
                                绑定
                            </th>
                        </tr>
                        <c:forEach items="${joinlist}" var="map" begin="0">
                        <tr>
                            <td>
                                <c:out value="${map.joinid}"/>       
                            </td>
                            <td>
                                <c:out value="${map.startpointname }"/>                                
                            </td>
                            <td>
                                <c:out value="${map.endpointname }"/>                              
                            </td>
                            <td>
                                <!-- 将数据库中的时间格式化后输出 -->
                                <fmt:formatDate type="DATE" value="${map.jointime }" pattern="yyyy-mm-dd"/>                                         
                            </td>                    
                            <td>
                                <c:out value="${map.automobileid }"/>  
                            </td>    
                            <td>
                            <!-- Button trigger modal -->
                               <a class="binder" zidingyiattr="${map.joinid}" ><button type="button" class="btn btn-primary btn-lg">
                                   绑定
                                </button></a>
                            </td>                       
                        </tr> 
                        </c:forEach>
                    </table>                  
                </form>
                </c:if>
            </div>
        </div>
    </div>
    
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">绑定交接单</h4>
      </div>
      <div class="modal-body">
        <form>		 
	        <div class="row">
	          <input id="joinid" type="hidden" value=""></input>
			  <div class="col-md-6">
			  班次号<br>
			    <select id="classidscheck" class="selectpicker" data-live-search="true"></select>
			  </div>
			  <div class="col-md-6">
			  订单号<br>
			    <select id="orderidscheck" class="selectpicker" data-live-search="true"></select>
			  </div>
			</div>		 	
		 <!--  <button type="submit" class="btn btn-default">Submit</button> -->
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="insertbindinfo" type="button" class="btn btn-primary">Save</button>
      </div>
    </div>
  </div>
</div>
				
				
 <script type="text/javascript">
    $(document).ready(function() {
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
		  
		  //模态框打开触发事件
		  $('.binder').on('click', function () {
			  //给隐藏的Input框添加自定义属性值
			  $("#joinid").attr("zidingyiattr",$(this).attr("zidingyiattr"));
			  $("#classidscheck").empty();
			  $("#classidscheck").append("<option value='----请选择班次号----'>----请选择班次号----</option>");
			  $.ajax({
				   type: "post",
				   url: "getclassids",
				   success: function(classids){
					   for(var i=0;i<classids.length;i++){	  						  
						   $("#classidscheck").append("<option value='"+classids[i].classid+"'>"+classids[i].classid+"</option>");		  
					   }  
				   }		       
			});
			  
			  $("#orderidscheck").empty();
			  $("#orderidscheck").append("<option value='----请选择订单号----'>----请选择订单号----</option>");
			  $.ajax({
				   type: "post",
				   url: "getorderids",
				   success: function(orderids){	   
					   for(var i=0;i<orderids.length;i++){	  
						   $("#orderidscheck").append("<option value='"+orderids[i].orderid+"'>"+orderids[i].orderid+"</option>");	
					   }  
				   }		       
			})
				 
			$('#myModal').modal('show');   
		  })
		  
		  $("#insertbindinfo").on("click",function(){		
			  var joinid=$("#joinid").attr("zidingyiattr");
			  var classid=$("#classidscheck").val();
			  var orderid=$("#orderidscheck").val();
			  $.ajax({
				   type: "post",
				   url: "insertbindinfos?joinid="+joinid+"&classid="+classid+"&orderid="+orderid,
				   //data:{joinid:joinid,classid:classid,orderid:orderid},//"joinid="+joinid+"&classid="+classid+"&orderid="+orderid,//
				   async:true,
				   //dataType:"json",//设置传回来的数据类型
				   contentType:"application/json",//这里设置发往服务端的数据类型
				   success: function(info){
					   alert("插入数据成功！");
					   
				   },
				   error: function(info){
					   alert("插入数据失败!");
				   }
			}); 
			  
			  $('#myModal').modal('hide');     
		  })
		 
	})
    
</script>
</body>
</html>