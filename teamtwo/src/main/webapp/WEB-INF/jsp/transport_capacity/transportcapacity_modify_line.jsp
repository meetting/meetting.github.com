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
                <p class="tit">运力&nbsp/&nbsp路线信息修改</p>
                <hr>
                <form action="modifytransportcapacityline" method="post">
                <c:choose>
                <c:when test="${not empty road}">
                    <table>
                        <tr>
                            <td style="width: 60%;text-align: center">
                                路线编号
                            </td>
                            <td style="width: 40%">
                                <input type="text" name="roadid" value="${road.roadid }"/> 
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                起始配送点
                            </td>
                            <td >
                                <input type="text" name="startpointid" value="${road.startpointid }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                目的配送点
                            </td>
                            <td >
                                <input type="text" name="endpointid" value="${road.endpointid }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                路线距离
                            </td>
                            <td >
                                <input type="text" name="roadlength" value="${road.roadlength }"/>
                            </td>
                        </tr>                                                                                      
                        <tr>
                            <td >
                            </td>
                            <td >
                            </td>
                        </tr>
                        <tr>
                            <td >
                            </td>
                            <td style="float: right">
                                <input type="submit" value="提交">
                                <input type="reset" value="重写">
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