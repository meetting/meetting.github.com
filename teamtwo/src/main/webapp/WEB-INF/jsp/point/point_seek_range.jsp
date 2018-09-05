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
    <script src="${include}/js/adapter.js"></script> <!--rem适配js-->

    <link rel="stylesheet" href="${css}/base.css"> <!--初始化文件-->
    <link rel="stylesheet" href="${css}/menu.css"> <!--主样式-->

	<script class="resources library" src="${include}/js/jquery-1.8.2.js" type="text/javascript"></script>
</head>
<body>
    <div class="someinformation">
        <div class="pagemain">
            <div class="big2">
                <p class="tit">配送点&nbsp;/&nbsp;配送范围查看</p>
                <hr>
                <form action="#" method="post">
                   <div  style=" width: 55vw; height: 50px;">
                           	<font style="font-size: 20px;"><b>请选择要查找的配送点：</b></font>     
                           	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           	<select id="pointid" name="pointid" style="height: 30px;">
                                    <option  value ="0";>--请选择--</option>
	                                <c:forEach items="${points}" var="point">
	                                	<option value="${point.pointid}">${point.pointname}</option>
	                                </c:forEach>
                            </select>
                           	<input id="sb" type="button" style="float: right" value="查 询" onclick="searchit()">
                    </div> 
 					 <table id="showtable" style="text-align: center;width: 70vw;">
                        <thead>
                        <tr>
             	           <th style="width: 20%">
                                配送点编号
                            </th>
                            <th style="width: 20%">
                                配送点名称
                            </th>
                            <th style="width: 30%">
                             可达配送点编号
                            </th>
                            <th style="width: 30%">
                                可达配送点名称
                            </th>
                            
                         </tr>
                     </thead>
                        <tbody id="tbd">		
								
						</tbody>	
                    </table>
                    <br>
                    <br>
                    <br>
                    <p style="color: red;text-align: center;" id="ha"></p>
                </form>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    function searchit()
    {
    	$("#tbd").html(""); 
    	$("#ha").html(""); 
    	var pointid = $("#pointid").val();
    	
    	//还没选
	  	if(pointid == 0)
	  	{  
	  		alert("请选择要查询的配送点！");
	  	}
	  	//按pointid查询
	  		else
	  		{
	  			$.ajax({
			    	type: "post",
			        async: false,
			        url: "sbpointid",
			        data: {	"pointid": pointid
			        	  },
			        	  success:function(Results){
						   		 
						        var html="";
						   		 for(var i = 0;i<Results.length;i++)
									{
										html+="<tr><td>"+Results[i].startpointid+
										"</td><td>"+Results[i].startpointname+
										"</td><td>"+Results[i].endpointid+
										"</td><td>"+Results[i].endpointname+
										"</td></tr>";
									}
						   		 if(html=="")
						   			{
						   			$("#ha").html("该配送点暂无配送范围信息！"); 
						   			}
						   		$("#tbd").html(html);
						   		
						    }
	  			})
	  		}
	  	
    	
    	
    
    }
    
    
    </script>
    
    
</body>
</html>