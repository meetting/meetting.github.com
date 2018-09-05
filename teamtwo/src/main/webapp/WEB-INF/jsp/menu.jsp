<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>菜单</title>
    <link rel="stylesheet" type="text/css" href="${css}/style.css" />
    <script src="${include }/js/adapter.js"></script> <!--rem适配js-->

    <link rel="stylesheet" href="${css }/base.css"> <!--初始化文件-->
    <link rel="stylesheet" href="${css }/menu.css"> <!--主样式-->
    
    <script src="${include }/js/menu.js"></script> <!--控制js-->
    <script class="resources library" src="${include}/js/jquery-1.8.2.js" type="text/javascript"></script>
</head>
<body>
<div id="menu">
    <!--隐藏菜单-->
    <div id="ensconce">
        <h2>
            <img src="${images}/show.png" alt="">
            <br>
            后台管理
        </h2>
    </div>

    <!--显示菜单-->
    <div id="open">
        <div class="navH">
            后&nbsp;台&nbsp;管&nbsp;理
            <span><img class="obscure" src="${images}/obscure.png" alt=""></span>
        </div>
        <div class="navBox">
            <ul>
            	<c:if test="${returnTuser.rolename == '配送点管理员' || returnTuser.rolename == '客户'}">
                <li>
                    <h2 class="obtain">订单<i></i></h2>
                    <div class="secondary">
                        <c:if test="${returnTuser.rolename == '配送点管理员' || returnTuser.rolename == '客户'}">
                        <c:if test="${returnTuser.rolename == '客户'}">
                        <a target="mainFrame" href="addbookinginfo"><h3>新增订单</h3></a>
                        </c:if>
                        <a target="mainFrame" href="querybookinginfo"><h3>查看订单</h3></a>
                        <a target="mainFrame" href="modifybookinginfo"><h3>修改订单</h3></a>
                        </c:if>
                    </div>
                </li>
           		</c:if>
           		<c:if test="${returnTuser.rolename == '配送点管理员' || returnTuser.rolename == '总公司管理员'}">
                <li>
                    <h2 class="obtain">运力<i></i></h2>
                    <div class="secondary">
                    	<c:if test="${returnTuser.rolename == '总公司管理员'}">
                        <a target="mainFrame" href="addtransportcapacity"><h3>增加运力</h3></a>
                        </c:if>
                        <a target="mainFrame" href="querytransportcapacity"><h3>列出运力</h3></a>
                        <a target="mainFrame" href="modifytransportcapacity"><h3>运力表单修改</h3></a>
                        <c:if test="${returnTuser.rolename == '总公司管理员'}">
                        <a target="mainFrame" href="transportcapacity_add_vehicle"><h3>增加车辆</h3></a>
                        </c:if>
                        <a target="mainFrame" href="queryvehicle"><h3>车辆列表</h3></a>
                        <a target="mainFrame" href="modifytransportcapacity_vehicle"><h3>修改车辆</h3></a>
                        <c:if test="${returnTuser.rolename == '总公司管理员'}">
                        <a target="mainFrame" href="addtransportcapacityline"><h3>增加路线</h3></a>
                        </c:if>
                        <a target="mainFrame" href="findtransportcapacityline"><h3>查看路线</h3></a>
                        <a target="mainFrame" href="modifytransportcapacityline"><h3>修改路线</h3></a>
                        <a target="mainFrame" href="seektransportcapacityline"><h3>寻找路线</h3></a>
                    </div>
                </li>
                </c:if>
                <c:if test="${returnTuser.rolename == '配送点管理员' || returnTuser.rolename == '总公司管理员'}">
                <li>
                    <h2 class="obtain">交接单<i></i></h2>
                    <div class="secondary">
                    	<c:if test="${returnTuser.rolename == '配送点管理员'}">
                        <a target="mainFrame" href="addjiaojiebiao"><h3>生成交接单</h3></a>
                        </c:if>
                        <a target="mainFrame" href="findjiaojiebiao"><h3>查询交接单</h3></a>
                    </div>
                </li>
                </c:if>
                <li>
                    <h2 class="obtain">配送管理<i></i></h2>
                    <div class="secondary">
                    <c:if test="${returnTuser.rolename == '总公司管理员'}">
                        <a target="mainFrame" href="pointadmin/pointadd"><h3>配送点信息录入</h3></a>
                        <a target="mainFrame" href="pointadmin/pointlist"><h3>配送点列表</h3></a>
                        <a target="mainFrame" href="point_seek_range"><h3>配送范围查看</h3></a>
                         
                        <a target="mainFrame" href="pointadmin/pointpricemaintenance"><h3>价格维护</h3></a>
                        <a target="mainFrame" href="pointadmin/pointaddprice"><h3>价格增加</h3></a>
                        <a target="mainFrame" href="pointadmin/pointseekprice"><h3>价格查找</h3></a>
                        </c:if>
                    </div>
                </li>
                <c:if test="${returnTuser.rolename == '总公司管理员' || returnTuser.rolename == '配送点管理员' }">
                <li>
                    <h2 class="obtain">审核<i></i></h2>
                    <div class="secondary">
                        <c:if test="${returnTuser.rolename == '总公司管理员'}">
                        <a target="mainFrame" href="pointadmin/checkprice"><h3>配送价格</h3></a>
                        <a target="mainFrame" href="pointadmin/checkpricecheck"><h3>配送价格审核</h3></a>
                        </c:if>
                    </div>
                </li>
                </c:if>
                <c:if test="${returnTuser.rolename == '配送点管理员' || returnTuser.rolename == '客户' || returnTuser.rolename == '总公司管理员'}">
                <li>
                    <h2 class="obtain">用户<i></i></h2>
                    <div class="secondary">
                    	<c:if test="${returnTuser.rolename == '总公司管理员'}">
                        <a target="mainFrame" href="useradd"><h3>增加用户</h3></a>
                        </c:if>
                        <c:if test="${returnTuser.rolename == '总公司管理员'}">
                        <a target="mainFrame" href="userfind"><h3>查看用户</h3></a>
                        </c:if>
                        <a target="mainFrame" href="usermodify"><h3>修改用户</h3></a>
                    </div>
                </li>
                </c:if>
                <c:if test="${returnTuser.rolename == '配送点管理员' || returnTuser.rolename == '总公司管理员'}">
                <li>
                    <h2 class="obtain">报表<i></i></h2>
                    <div class="secondary">
                        <a target="mainFrame" href="JournalingShow"><h3>报表显示</h3></a>
                    </div>
                </li>
                </c:if>
                <li>
                    <a onclick="userexit()" ><h2 class="obtain">退出<i></i></h2></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
function userexit()
{
	
	var uexit = confirm("是否确认退出？");
	if(uexit == true)
		{
		window.open('loginout','_top')
		}
	else
		{
			
		}

}

</script>


</body>
</html>