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


</head>
<body>

    <div class="someinformation">
        <div class="pagemain">
            <div class="big2">
                <p class="tit">运力&nbsp/&nbsp修改车辆</p>
                <hr>          
                <form action="modifytransportcapacity_vehicle" method="post">
                <c:choose>
                <c:when test="${not empty automobile}">
                    <table>
                        <tr>
                            <td style="width: 60%;text-align: center">
                                车辆编号
                            </td>
                            <td >
                                <input type="text" name="automobileid" value="${automobile.automobileid }">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                最大载重
                            </td>
                            <td >
                                <input type="text" name="cartweight"value="${automobile.cartweight }">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                最大容积
                            </td>
                            <td >
                                <input type="text" name="carvolume"value="${automobile.carvolume }">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                车辆状态
                            </td>
                            <td >
                                <input type="text" name="cartate" value="${automobile.cartate }">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                所属配送点
                            </td>
                            <td >
                                <input type="text" name="pointid" value="${automobile.pointid }">
                            </td>
                        </tr>

                        <tr>
                            <td >
                            </td>
                            <td style="float: right">
                                <input type="button" value="确定">
                            </td>
                        </tr>
                    </table>
                    </c:when>
                    <c:otherwise>
                    请先在列表中选择数据！
                    </c:otherwise>
                    </c:choose>

                </form>
            </div>
        </div>
</div>

</body>
</html>