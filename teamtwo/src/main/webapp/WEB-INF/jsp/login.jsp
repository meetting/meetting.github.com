<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
	<script type="${include}/js/javascript" src="jquery-1.8.2.js"></script>
    <script type="${include}/js/javascript" src="jquery.validate.js"></script>
    <style>
        html,body{
            margin: 0;
            padding: 0;
            height: 100%;
        }
        body{
            color: #555;
            /*font-size: 15px ;*/
            line-height: 1.7;
            /*设置字体样式*/
            font-family: 'Helvetica Neue',helvetica,'PingFang SC','Hiragino Sans GB',"microsoft yahei",arial,sans-serif;
            /*页面的整个背景图像*/
            background:url("${images}/advertisement4.jpg") no-repeat center center fixed;
            /*使背景整个平铺在页面上*/
            /*-webkit-background-size: cover;*/
            background-size: cover;
            /*background-color: #ffff00;*/
            -webkit-font-smoothing:subpixel-antialiased;
            /*background-color: rgb(250,250,250);*/
        }

        /*.clearfix:before, .clearfix:after{*/
        /*display:table;*/
        /*content:"";*/
        /*}*/
        /*.clearfix:after{*/
        /*clear: both;*/
        /*}*/

        @media(min-width: 740px) {
            .index-main{
                margin-bottom: -102px;
            }
        }


        /*.index-main{
            min-height: 100%;

            width:300px;
            height: 300px;
            position:absolute;
            left:50%;
            top:30%;
            margin:-100px 0 0 -150px;
        }*/


        /*设置整个登录的框文字居中*/

        .index-main-body{
            height: 450px;
            width: 600px;
			border-radius:200px;
            position: absolute;
            left:50%;
            top:50%;
            margin-left: -300px;
            margin-top: -225px;
        }

        /*标题居中*/
        .index-header{
            text-align: center;
        }

        .hide-text{
            font-style: normal;
            line-height: 0;
			font-size:60px;
            color: #cc96d3;
            /*font-family: a;*/
        }

        h1,h2{
            color: rgba(204, 150, 211, 0.82);
            -webkit-transition: all 1.5s ease;
            transition: all 1.5s ease;
        }
        h1,h2:hover{
            color: #fff;
            -webkit-animation: Glow 1.5s ease infinite alternate;
            animation: Glow 1.5s ease infinite alternate;
        }
        @-webkit-keyframes Glow {
            from {
                text-shadow: 0 0 10px #fff,
                0 0 20px #fff,
                0 0 30px #fff,
                0 0 40px #9f77a6,
                0 0 70px #9f77a6,
                0 0 80px #9f77a6,
                0 0 100px #9f77a6,
                0 0 150px #9f77a6;
            }
            to {
                text-shadow: 0 0 5px #fff,
                0 0 10px #fff,
                0 0 15px #fff,
                0 0 20px #9f77a6,
                0 0 35px #9f77a6,
                0 0 40px #9f77a6,
                0 0 50px #9f77a6,
                0 0 75px #9f77a6;
            }
        }
        @keyframes Glow {
            from {
                text-shadow: 0 0 10px #fff,
                0 0 20px #fff,
                0 0 30px #fff,
                0 0 40px #9f77a6,
                0 0 70px #9f77a6,
                0 0 80px #9f77a6,
                0 0 100px #9f77a6,
                0 0 150px #9f77a6;
            }
            to {
                text-shadow: 0 0 5px #fff,
                0 0 10px #fff,
                0 0 15px #fff,
                0 0 20px #9f77a6,
                0 0 35px #9f77a6,
                0 0 40px #9f77a6,
                0 0 50px #9f77a6,
                0 0 75px #9f77a6;
            }
        }

        .index-header.subtitle{
            margin: 230px 0 20px;
            font-weight: 400;
            font-size: 18px;
            line-height: 1;
        }

        .sign-flow{
            text-align: center;
        }

        /*.clearfix:before,.clearfix:after{
            display: table;
            content: "";
        }*/

        .index-tab-navs{
            margin-bottom: 10px;
            font-size: 18px;
            text-align: center;
        }
        .index-tab-navs .navs-slider {
            position:relative;
            display: inline-block;
        }
        .index-tab-navs a.active{
            opacity: 1;
            color: #9f77a6;
        }
        .index-tab-navs a{
            float: left;
            width: 4em;
            line-height: 35px;
            opacity: .7;
            transition: opacity .15s,color .15s;
        }

        .sign-flow a{
            color: inherit;
        }

        a{
            text-decoration: none;
        }
        a:-webkit-any-link{
            /*color: -webkit-link;*/
            /*text-decoration: underline;*/
            cursor: auto;
        }
        .index-tab-navs .navs-slider[data-active-index="1"] .navs-slider-bar{
            left:4em;
        }
        /*登录按钮的设计*/
        .index-tab-navs .navs-slider .navs-slider-bar{
            position: absolute;
            /*left: 0;*/
            bottom: 0;
            margin: 0 .8em;
            width: 2.4em;
            height: 2px;
            background-color: rgb(159, 119, 166);
            text-align: center;
        }

        /*.sign-flow,.view,.group-inputs{*/
        /*padding:1px 0;*/
        /*border:1px solid #d5d5d5;*/
        /*border-radius: 3px;*/
        /*}*/

        .sign-flow.view{
            float: none;
            margin: auto;
            width: 300px;
            text-align: left;
        }

        @media (max-width: 740px) {
            .sign-flow .view{
                float: none;
                margin: 0 auto;
                width:248px;

            }
        }

        /*form{
            display: block;
            margin-top: 0em;
        }*/

        button,input,select,textarea{
            margin: 0;
            font-family: inherit;
            font-size: 100%;
        }

        /*.sign-flow.view,.input-wrapper+.input-wrapper{*/
        /*border-top:1px solid #e8e8e8;*/
        /*}*/

        /*文本框的修饰*/
        .sign-flow.view,.input-wrapper input{
            padding:0.5em .8em;
            width:60%;
            box-sizing: border-box;
            
        }

        .sign-button{
            background: #9f77a6;
            box-shadow:none;
            border: 0;
            border-radius: 10px;
            line-height:41px;
            color: #fff;
        }
        .sign-button{
            padding: 0;
            width:70%;
            font-size: 15px;
            text-align: center;
            text-shadow: 0 1px 1px rgba(0,0,0,.2);
        }
        .sign-flow.view,.signin-misc-wrapper,.signin-switch-button{
            padding: 0;
            font-size: 14px;
            color: #9f77a6;
            background-color: transparent;
            border:0;
            cursor: pointer;
            outline: 0;
        }
        .framework{
		    width:300px;
			height:300px;
			border-radius:20px;
			background-color:#f9f9f9;
			margin:0 auto;
		}

    </style>
    
</head>
<body class="yu auth">
<div class = "index-main">
    <div class="index-main-body">
        <div class="index-header">
            <h1 class="logo hide-text">风&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;物&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;流</h1>
            <%--<h2 class="subtitle">风尚物流公司</h2>--%>
            <br><br>
        </div>
		<div class="framework">
        <div class="desk-front sign-flow clearfix sign-flow-simple">

            <div class="index-tab-navs">
                <div class="navs-slider" data-active-index= "1">
                    <!--<a href="#signup" class>注册</a>-->
                    <a href="#signin" class="active"style="font-size: 25px;margin-top: 10px">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</a>
                    <!--<span class="navs-slider-bar"></span>-->
                </div>
            </div>
			<div class="view view-signin" data-za-module = "SignInForm">
			
			<form action="login" method="post" >
               	
						    <div class="group-inputs">
               		<hr>
                    <table width="100%" >

                        <tr>
						    <div class="account input-wrapper">
    							<span><input type="text" name="username" id="username" aria-label="账号" placeholder="账号" required/><font style="color: red" id="infotitle"></font></span>
    					    </div>
  						</tr>
                        <tr>
                            <br>
                        </tr>
                        <tr>
						    <div class="verification input-wrapper">
    							<span><input type="password" name="password" id="password" aria-label="密码" placeholder="密码" required><font style="color: red"></font></span>
							</div>
 			 			</tr>
                        <tr>
                            ${info.msg }<br>
                        </tr>
						<tr>
						    <div class="button-wrapper command" >
                            <button class="sign-button submit" type="submit" onclick="return validate1();" style="cursor:pointer">登录</button>
                            </div>
                        </tr>
                        <tr>
                        	<!-- <p style="float: right;font-size: 8px;color: #e86046"><a href="#" ><u>还没有账号？<br>赶快注册一个吧！</u></a></p> -->
                        </tr>
					</table>
               	</div>
                      
           </form>
				
			</div>    
			

        </div>
		</div>
    </div>
</div>


<script type="text/javascript">
 $(document).ready(function() {
	 validators();
});

function validators(){
	$.validator.addMethod("selectNone", function(value, element) {
		var returnVal = true;
		if (value == "请选择") {
			returnVal = false;
		}
		return returnVal;
	}, "必须选择一项");
	$("#formProductUp").validate({
			rules : {
				proTitle : "required",
				//if($("proTitle").val()==""){
					//$("infotitle").text("标题必填");
				//}
				tag1 : {
					selectNone : true
				},
				tag2 : {
					selectNone : true
				},
				level : {
					selectNone : true
				},
				unit : {
					selectNone : true
				},
				filler : "required",
				file : {
					required : true
				},
				r1 : {
					required : true
				},
				c1 : {
					required : true
				},
				myemail: {  
					required: true,  
                    email: true
				},
				pass1: {  
					required: true,  
					minlength: 6 
				}, 
    			pass2: {  
					required: true,  
					minlength: 6,  
					equalTo: "#pass1"  
				} 


			},
			messages : {
 				proTitle : "&nbsp;标题必填",
				tag1 :  "&nbsp;请选择类型",
				tag2 :  "&nbsp;请选择分类",
				unit : "&nbsp;请选择单位",
				filler :  "&nbsp;填报人必填",
				file :  "&nbsp;必须选文件",
				r1: "&nbsp;必须选",
				c1: "&nbsp;必须选",
				myemail: {  
				   required: "请输入Email地址",  
                   email: "请输入正确的email地址"  
				},
				pass1: {  
					required: "请输入密码",  
					minlength: "密码不能小于6个字符"  
				},  
				pass2: {  
					required: "请输入确认密码",  
					minlength: "确认密码不能小于6个字符",  
					equalTo: "两次输入密码不一致不一致"  
				} 
			},
			errorPlacement : function(error, element) {
				var place = $(element.parent("span").find("font"));
				place.text('');
				error.appendTo(place);
			}

		});
	}
</script>
<script language="JavaScript" type="text/javascript">
        //    前端就是用（javascript来做）检测账号密码是否符合条件
        function validate() {
            var userName = document.getElementById("userName").value;
            var password = document.getElementById("password").value;
            if(userName.length<3 || userName.length>6 || password.length<6 || password.length>20){
                alert("用户名3到6位，密码6到20位，不要太懒了！！")
                return false;
            }else if(userName == 1234567 && password == 1234567){
                //跳转到首页

            }
            return true;
        }
    </script>

<script type="text/template" class="oauth-register-template">

</script>
</body>
</html>