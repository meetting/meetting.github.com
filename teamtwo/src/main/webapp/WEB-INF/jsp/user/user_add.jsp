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
    <script class="resources library" src="${include}/js/area.js" type="text/javascript"></script>
   	<script class="resources library" src="${include}/js/jquery-1.8.2.js" type="text/javascript"></script>
    
    <style type="text/css">
		select{
		    height: 20px;
		    box-shadow:0px 0px 8px #707070;
		}
	</style>
</head>
<body>

    <div class="someinformation">
        <div class="pagemain">
            <div class="big1">
                <p class="tit">用户&nbsp;/&nbsp;增加用户</p>
                <hr>
                <form >
                    <table >
                        <tr>
                            <td style="width: 50%;text-align: center">
                                用户名
                            </td>
                            <td style="width: 50%">
                                <input type="text" id="username" name="username"><font style="color: red" id="checkuninfo">&nbsp;&nbsp;必填</font>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                密码
                            </td>
                            <td >
                                <input type="text" id="password" name="password"><font style="color: red" id="checkpassword">&nbsp;&nbsp;必填</font>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                确认密码
                            </td>
                            <td >
                                <input type="text" id="repassword" name="repassword"><font style="color: red" id="checkrepassword">&nbsp;&nbsp;必填</font>
                            </td>
                        </tr>
                         <tr>
                            <td style="text-align: center">
                                真实姓名
                            </td>
                            <td >
                                <input type="text" id="realname" name="realname">
                            </td>
                        </tr>
                        
                        
                        <tr>
                            <td style="text-align: center">
                                用户类型
                            </td>
                            <td >
                               <select id="roleid" name="roleid">
                                <option value ="0";>----请选择----
                                </option>
                               	<c:forEach items="${roles }" var="role" >
                               		<option value="${role.roleid}">
                               			${role.rolename}
                               		</option>	
                               	</c:forEach>
                               	
                               </select>
                               <font style="color: red" id="checkroleid">&nbsp;&nbsp;必填</font>
                           </td>
                        </tr>
                        
                         <tr>
                            <td style="text-align: center">
                                所属配送点
                            </td>
                            <td >
                                <select id="pointid" name="pointid">
                                    <option  value ="0";>--请选择--</option>
	                                <c:forEach items="${points}" var="point">
	                                	<option value="${point.pointid}">${point.pointname}</option>
	                                </c:forEach>
                                </select>
                                <!--<font style="color: red" id="checkpointid">&nbsp;&nbsp;必填</font>-->
                            </td>
                        </tr>
                        
                        <tr>
                            <td style="text-align: center">
                                地址
                            </td>
                            <td >
                                <div >
									<div>
										<select id="s_province" name="s_province"></select>&nbsp;&nbsp;
									    <select id="s_city" name="s_city" ></select>&nbsp;&nbsp;
									    <select id="s_county" name="s_county"></select>
									    
									    <!-- <font style="color: red" id="checkaddr">&nbsp;&nbsp;必填</font> -->
								    </div>
								</div>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                电话号码
                            </td>
                            <td >
                                <input type="text" id="tel" name="tel" ><font style="color: red" id="checktel"></font>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                               
                            </td>
                        </tr>
                        <tr>
                            <td >
                            </td>
                            <td style="float: right">
                                <input type="button"  value="提交" onclick="addIt()">
                                <input type="reset" value="重置">
                            </td>
                        </tr>
                    </table>

                </form>
            </div>
        </div>
    </div>
<script type="text/javascript">
_init_area();

var checkflag = 1;

	$(document).ready(function() {
	//账号文本框失去焦点后进行验证
	$("#username").on("blur",function()
	{
		var username = $("#username").val();
		if(username == "")	
		{
			$("#checkuninfo").html("&nbsp;&nbsp;必填");
			checkflag=0;
		}
		else{
			$.ajax({
		    	type: "post",
		        async: true,
		        url: "checkun",
		        data: {	"username": username
		        	  },
			   	success:function(checkinfo){
			   		 //请求成功之后的操作
			   		$("#checkuninfo").html("&nbsp;&nbsp;"+checkinfo.msg); 
			   		 
			     }
		 		 });   
			checkflag=1;
			}
	 	})
	
	//验证密码
	$("#password").on("blur",function()
	{
		var password = $("#password").val();
		
		if(password == "")	
		{
			$("#checkpassword").html("&nbsp;&nbsp;必填");
			checkflag=0;
		}
		else{
			$("#checkpassword").html("&nbsp;&nbsp;√");
			checkflag=1;
			}
	 })
	 	
	 	
	//验证确认密码
	$("#repassword").on("blur",function()
	{
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		
		
		
		if(password == repassword)	
		{
			$("#checkrepassword").html("&nbsp;&nbsp;√");
			checkflag=1;
		}
		else{
			$("#checkrepassword").html("&nbsp;&nbsp;确认密码与密码不一致！");
			checkflag=0;
			}
	 })
	 	
	 //验证用户类型是否选了
	$("#roleid").on("blur",function()
	{
		var roleid = $("#roleid").val();
		if(roleid == 0)	
		{
			checkflag=0;
			$("#checkroleid").html("&nbsp;&nbsp;必填");
		}
		else{
			
			$("#checkroleid").html("&nbsp;&nbsp;√");
			checkflag=1;
			}
	 })
	//电话验证
	$("#tel").on("blur",function()
	{
		var roleid = $("#roleid").val();
		var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;  
		//电话  
		var phone = $.trim($('#tel').val());  
		if (!phoneReg.test(phone)) {  
			$("#checktel").html("请输入有效的手机号码！");
		    checkflag = 0;
		}  
		else {  
		     
		    checkflag = 1;
		}  
	 })
	});



//添加用户
function addIt(){
	
	var username = $("#username").val();
    var password = $("#password").val();
    var repassword = $("#repassword").val();
    var realname = $("#realname").val();
    var roleid = $("#roleid").val();
    var pointid = $("#pointid").val();
    var tel = $("#tel").val();
    
    var s_province = $("#s_province").val();
    var s_city = $("#s_city").val();
    var s_county = $("#s_county").val();
    
    var addr = s_province +"/"+ s_city +"/"+ s_county;
    
    addr = addr.replace(/省份\//g, '');
    addr = addr.replace(/\/市、县级市/g, '');
    addr = addr.replace(/地级市/g, '');
    if (addr == "")
    {
   		addr = "未填写"; 	
   	}
    
    if(username==""||password==""||roleid==0||checkflag==0)
    {
    	alert("请正确填写内容");
    }
    	
    else
    {
    	$.ajax({
	    	type: "post",
	        async: false,
	        url: "doaddtuser",
	        data: {	"username": username,
	        		"password": password, 
	        		"realname": realname,
	        		"roleid": roleid,
	        		"pointid": pointid,
	        		"tel": tel,
	        		"addr": addr
	        	  },
		   	success:function(info){
		   		 //请求成功之后的操作
		     	 alert(info.msg);
		     }
	 		 })   
   	}
    
}
</script>

</body>
</html>