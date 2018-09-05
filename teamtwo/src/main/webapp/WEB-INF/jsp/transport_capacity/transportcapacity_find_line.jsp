<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <p class="tit">运力&nbsp/&nbsp查看路线</p>
                <hr>
                <c:if test="${not empty sessionScope.queryRoadresult}">
                <form action="modifytransportcapacityline" method="post">
                    <table style="text-align: center">
                        <tr>
                            <th style="width: 10%">
                                路线编号
                            </th>
                            <th style="width: 15%">
                                起始配送点
                            </th>
                            <th style="width: 13%">
                                目的配送点
                            </th>
                            <th style="width: 13%">
                                路线距离
                            </th>
                            <th style="width: 22%">
                                修改
                            </th>
                        </tr>
                        <c:forEach items="${sessionScope.queryRoadresult}" var="road" begin="0">
                        <tr>
                            <td >
                                 <c:out value="${road.roadid }"/>      
                            </td>
                            <td >
                                 <c:out value="${road.startpointid }"/>      
                            </td>
                            <td>
                                 <c:out value="${road.endpointid }"/>      
                            </td>
                            <td >
                                 <c:out value="${road.roadlength }"/>      
                            </td>
                            <td >
                                <a href="modifytransportcapacityline?roadid=${road.roadid }"><input type="button"value="修改"></a>
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