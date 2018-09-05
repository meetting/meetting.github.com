<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>风尚物流</title>
	<link rel="stylesheet" type="text/css" href="${css}/style.css" />
    <link rel="stylesheet" href="${css}/base.css"> <!--初始化文件-->
</head>
<body>
    <div class="someinformation">
        <div class="pagemain">
            <div class="big1">
                <p class="tit">审核&nbsp/&nbsp订单</p>
                <hr>
                <c:if test="${not empty sessionScope.queryCheckOrderResult}">
            <form action="#" method="post">
                <table style="text-align: center;">
                    <tr>
                        <th style="width: 6%">
                            订单编号
                        </th>
                        <th style="width: 6%">
                          顾客id
                        </th>
                        <th style="width: 6%">
                          下单时间
                        </th>
                        <th style="width: 6%">
                           发件地
                        </th>
                        <th style="width: 6%">
                            发件人姓名
                        </th>
                        <th style="width: 6%">
                            发件人电话
                        </th>
                        <th style="width: 6%">
                         收件地                  
                        </th>
                        <th style="width: 6%">
                          收件人姓名
                        </th>
                        <th style="width: 6%">
                            收件人电话
                        </th>
                        <th style="width: 6%">
                            所属配送点
                        </th>
                        <th style="width: 6%">
                          物品质量
                        </th>
                        <th style="width: 6%">
                         物品体积
                        </th>
                        <th style="width: 6%">
                            物品计费
                        </th>
                        <th style="width: 6%">
                            订单状态
                        </th>
                        <th style="width: 6%">
                            描述
                        </th>
                        <th style="width: 6%">
                            修改
                        </th>

                    </tr>
                    <c:forEach items="${sessionScope.queryCheckOrderResult}" var="result" begin="0">
                    <tr>
                        <td >
                            <c:out value="${result.orderid }"/>  
                        </td>
                        <td >
                            <c:out value="${result.customid }"/>  
                        </td>
                        <td>
                            <c:out value="${result.startaddr }"/>  
                        </td>
                        <td >
                           <!-- 将数据库中的时间格式化后输出 -->
                            <fmt:formatDate type="DATE" value="${result.sendtime }" pattern="yyyy-mm-dd"/>      
                        </td>
                        <td>
                           <c:out value="${result.sendname }"/>  
                        </td>
                        <td >
                            <c:out value="${result.sendphone }"/>  
                        </td>
                         <td >
                            <c:out value="${result.endaddr }"/>  
                        </td>
                         <td >
                            <c:out value="${result.recvname }"/>  
                        </td>
                         <td >
                            <c:out value="${result.recvphone }"/>  
                        </td>
                        <td >
                            <c:out value="${result.pointname }"/>  
                        </td>
                        <td >
                            <c:out value="${result.weight }"/>  
                        </td>
                        <td >
                            <c:out value="${result.volume }"/>  
                        </td>
                        <td >
                            <c:out value="${result.cost }"/>  
                        </td>
                        <td >
                            <c:out value="${result.statev }"/>  
                        </td>
                        <td >
                            <c:out value="${result.describeo }"/>  
                        </td>
                        <td >
                            <a href="modifycheckorderinfotopass?orderid=${result.orderid }"><input style="border:solid 1px" type="button"value="通过"></a>
                            <a href="modifycheckorderinfotonopass?orderid=${result.orderid }"><input style="border:solid 1px" type="button"value="否决"></a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </form>
            </c:if>
            </div>
        </div>

    </div>
</body>
</html>