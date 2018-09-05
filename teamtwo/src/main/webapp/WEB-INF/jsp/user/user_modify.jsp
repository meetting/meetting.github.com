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
    <script class="resources library" src="${include}/js/jquery-1.8.2.js" type="text/javascript"></script>

	<script class="resources library" src="${include}/js/area.js" type="text/javascript"></script>
	
	<style type="text/css">
	select{
	    height: 20px;
	    box-shadow:0px 0px 8px #707070;
	}
	textarea
	{
	    box-shadow:0px 0px 8px #707070;
	}
	</style>
</head>
<body>

    <div class="someinformation">
        <div class="pagemain">
            <div class="big1">
                <p class="tit">用户&nbsp;/&nbsp;修改用户<个人信息></p>
                <hr>
                <form >
                    <table >
                        <tr>
                            <td style="width: 40%;text-align: center">
                              用户类型
                            </td>
                            <td style="width: 10%">
                            </td>
                            <td style="width: 50%">
                                <p style="font-size: 14px;">${myInfo.rolename }</p>
                            </td>
                            
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                账号
                            </td>
                            <td>  <font style="color: red;font-size: 12px;" id="checkusername"></font></td>
                            <td>
                                <input type="text" id="newusername" name="newusername" style="display: none;width:40px;" value="${myInfo.username }">
                              
                                <input type="text" id="username" name="username" value="${myInfo.username }" onfocus="mun()">
                                
                            </td>
                        </tr>
                        
                        <tr>
                            <td style="text-align: center">
                                密码
                            </td>
                            <td></td>
                            <td >
                                <input type="text" id="password" name="password" value="${myInfo.password }">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                真实姓名
                            </td>
                            <td></td>
                            <td >
                                <input type="text" id="realname" name="realname" value="${myInfo.realname }">
                            </td>
                        </tr>
                       
                         <tr>
                            <td style="text-align: center">
                                所属配送点
                            </td>
                            <td></td>
                            <td >
                                <select id="pointid" name="pointid" >
									<c:forEach items="${points}" var="point">
											<c:choose>
												<c:when test="${point.pointid==myInfo.pointid}">
													<option value="${point.pointid }" selected="selected" style="text-align: center;">
														${point.pointname }
													</option>
												</c:when>
												<c:otherwise>
													<option value="${point.pointid }" style="text-align: center;">
														${point.pointname }
													</option>
												</c:otherwise>
											</c:choose>
									</c:forEach>
								</select>  
										                 
                            </td>
                        </tr>
                         <tr>
                            <td style="text-align: center">
                                地址
                            </td>
                            <td>
                            	<input style="height: 20px;"type="button" id="moaddr" name="moaddr" value="点击修改" onclick="modifyaddr()">	
                           		<input style="height: 20px;display: none" type="button" id="nomoaddr" name="nomoaddr" value="取消" onclick="nomodifyaddr()">
                            </td>
                            <td >
                                <input style="width: 250px" type="text" id="addr" name="addr" value="${myInfo.addr }">
                             	
                             
                             	<div id="addrmodify" style="display: none">
									<div>
										<select id="s_province" name="s_province"></select>&nbsp;
									    <select id="s_city" name="s_city" ></select>&nbsp;
									    <select id="s_county" name="s_county"></select>
								    </div>
									
								</div>
								
                            </td>
                            
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                电话号码
                            </td>
                            <td></td>
                            <td >
                                <input type="text" id="tel" name="tel" value="${myInfo.tel }">
                            	<font style="color: red" id="checktel"></font>
                            </td>
                        </tr>
                       <!-- <tr>
                            <td style="height: 60px;text-align: center">
                                修改记录
                            </td>
                            <td></td>
                            <td>
                                <textarea cols="45"rows="5" readonly="readonly"></textarea>
                            </td>
                        </tr>
                        <tr>
                        </tr>
                         --> 
                         <tr>
                            <td >
                            </td>
                            <td >
                            </td>
                            <td style="float: right">
                                <input type="button"  value=" 保  存 " onclick="modifyIt()" >
                                <input type="reset" value=" 重  置 " onclick="nomodifyaddr()">
                            </td>
                        </tr>
                    </table>

                </form>
            </div>
        </div>
    </div>



<script type="text/javascript">
_init_area();

var addr = $("#addr").val(); 
var addrflag = 0;
var checkflag = 1;

function mun()
{  
	$("#username").attr("style","display:none;");  
	$("#newusername").attr("style","display:block;");  
}

$(document).ready(function() {
	//账号文本框失去焦点后进行验证
	$("#newusername").on("blur",function()
	{
		var username = $("#username").val();
		var newusername = $("#newusername").val();
		
		if(newusername == "")	
		{
			$("#checkuninfo").html("&nbsp;&nbsp;不可为空");
			checkflag=0;
		}
		else{
			$.ajax({
		    	type: "post",
		        async: true,
		        url: "checkun",
		        data: {	"username": newusername
		        	  },
			   	success:function(checkinfo){
			   		 //请求成功之后的操作
			   		$("#checkusername").html(checkinfo.msg); 
			   		if(username == newusername)
					{
						$("#checkusername").html("");
						checkflag=1;
					}
			   	}
		 		 });   
			if(username == newusername)
			{
				$("#checkusername").html("");
				checkflag=1;
			}
			
			if(checkinfo.status==1)
	   		{
	   			 
	   			  checkflag = 1;
	   		}
	   		 else
	   		{
	   			  checkflag = 0;
	   		}
				
			}
	 	})
	 	
	 //电话验证
	 $("#tel").on("blur",function()
	 			{
	 				var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;  
	 				//电话  
	 				var phone = $.trim($('#tel').val());  
	 				if (!phoneReg.test(phone)) {  
	 					$("#checktel").html("请输入有效的手机号码！");
	 				    checkflag = 0;
	 				}  
	 				else {  
	 					$("#checktel").html("");
	 				    checkflag = 1;
	 				}  
	 			 })
	 	
	 });
	 			
	 			



//修改地址
function modifyaddr()
{  
	addrflag = 1;
	$("#addr").attr("style","display:none;");  
	$("#addrmodify").attr("style","display:block;");  
	$("#moaddr").attr("style","height: 20px;display:none;");  
	$("#nomoaddr").attr("style","height: 20px;display:block;");
}
//取消修改地址
function nomodifyaddr()
{  
	addrflag = 0;
	$("#addr").attr("style","width: 250px;display:block;");  
	$("#addrmodify").attr("style","display:none;");  
	$("#moaddr").attr("style","height: 20px;display:block;");  
	$("#nomoaddr").attr("style","height: 20px;display:none;");
	
	$("#s_province").val("省份");
    $("#s_city").val("市、县级市");
    $("#s_county").val("地级市");
}
//修改用户信息
function modifyIt()
{
	var okusername = $("#newusername").val();
	var password = $("#password").val();
	var realname = $("#realname").val();
	var pointid = $("#pointid").val();
	var tel = $("#tel").val();
	
	var r = confirm("是否修改信息？");
	
	if(r == true)
	{
		if(checkflag == 1)
		{
			if(addrflag == 1)
			{
				var s_province = $("#s_province").val();
			    var s_city = $("#s_city").val();
			    var s_county = $("#s_county").val();
			    addr = s_province +"/"+ s_city +"/"+ s_county;
			    addr = addr.replace(/省份\//g, '');
			    addr = addr.replace(/\/市、县级市/g, '');
			    addr = addr.replace(/地级市/g, '');
			    if (addr == "")
			    {
			   		addr = "未填写"; 	
			   	}
			}
			
			
		    $.ajax({
				    	type: "post",
				        async: false,
				        url: "doModifyTuser",
				        data: {	"username": okusername,
				        		"password": password, 
				        		"realname": realname,
				        		"pointid": pointid,
				        		"tel": tel,
				        		"addr": addr
				        	  },
					   	success:function(info){
					   		 //请求成功之后的操作
					     	alert(info.msg);
					     	document.location.reload();
					     }
		  	 		 })   	
		}
		else{}
	}
	else
	{
		//什么都不做
	}
	
}



</script>
</body>
</html>