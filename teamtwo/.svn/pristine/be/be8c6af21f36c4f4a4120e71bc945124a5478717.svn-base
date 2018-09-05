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
                <p class="tit">车辆&nbsp/&nbsp列出车辆</p>
                <hr>
                <c:if test="${not empty sessionScope.queryMobileresult}">
                <form action="modifytransportcapacity_vehicle" method="get">
                    <table style="text-align: center">
                        <tr>
                            <th style="width: 15%">
                                车辆编号
                            </th>
                            <th style="width: 17%">
                                载重
                            </th>
                            <th style="width: 16%">
                                体积
                            </th>
                            <th style="width: 15%">
                                状态
                            </th>
                            <th style="width: 15%">
                                配送点编号
                            </th>                      
                            <th style="width: 22%">
                                修改
                            </th>
                        </tr>
                        <c:forEach items="${sessionScope.queryMobileresult}" var="automobile" begin="0">
                        <tr>
                            <td>
                                <c:out value="${automobile.automobileid }"/>       
                            </td>
                            <td>
                                <c:out value="${automobile.cartweight }"/>                                
                            </td>
                            <td>
                                <c:out value="${automobile.carvolume }"/>                              
                            </td>
                            <td>
                                <c:out value="${automobile.cartate }"/>                               
                            </td>
                            <td>
                                <c:out value="${automobile.pointid}"/>                             
                            </td>                           
                            <td >
                                <a href="modifytransportcapacity_vehicle?automobileid=${automobile.automobileid }"><input type="button"value="修改"></a>
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