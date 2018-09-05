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
                <p class="tit">运力&nbsp/&nbsp列出运力</p>
                <hr>
                <c:if test="${not empty sessionScope.queryClassresult}">
                <form action="modifytransportcapacity" method="get">
                    <table style="text-align: center">
                        <tr>
                            <th style="width: 15%">
                                运力编号
                            </th>
                            <th style="width: 10%">
                                路线编号
                            </th>
                            <th style="width: 10%">
                                车辆编号
                            </th>
                            <th style="width: 15%">
                                司机编号
                            </th>
                            <th style="width: 15%">
                                上行配送点
                            </th>
                            <th style="width: 13%">
                                下行配送点
                            </th>
                            <th style="width: 13%">
                                货物重量
                            </th>
                            <th style="width: 13%">
                                上行到达时间
                            </th>
                            <th style="width: 22%">
                                修改
                            </th>
                        </tr>
                        <c:forEach items="${sessionScope.queryClassresult}" var="lclass" begin="0">
                        <tr>
                            <td>
                                <c:out value="${lclass.classid }"/>       
                            </td>
                            <td>
                                <c:out value="${lclass.roadid }"/>                                
                            </td>
                            <td>
                                <c:out value="${lclass.automobileid }"/>                              
                            </td>
                            <td>
                                <c:out value="${lclass.driverid }"/>                               
                            </td>
                            <td>
                                <c:out value="${lclass.startpointid }"/>                             
                            </td>
                            <td>
                                <c:out value="${lclass.endpointid }"/>                    
                            </td>
                            <td>
                                <c:out value="${lclass.weight }"/>                               
                            </td>
                            <td>
                            <!-- 将数据库中的时间格式化后输出 -->
                            <fmt:formatDate type="DATE" value="${lclass.classendtime }" pattern="yyyy-mm-dd"/>                         
                            </td>
                            <td >
                                <a href="modifytransportcapacity?classid=${lclass.classid }"><input type="button"value="修改"></a>
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