<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
                <p class="tit">运力&nbsp/&nbsp运力表单修改</p>
                <hr>
                <form action="modifytransportcapacity" method="post">
                <c:choose>
                <c:when test="${not empty lclass}">
                    <table>
                        <tr>
                            <td style="width: 60%;text-align: center">
                                运力编号
                            </td>
                            <td style="width: 40%">
                                <input type="text" name="classid" value="${lclass.roadid }"/> 
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                路线编号
                            </td>
                            <td >
                                <input type="text" name="roadid" value="${lclass.roadid }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                车辆编号
                            </td>
                            <td >
                                <input type="text" name="automobileid" value="${lclass.automobileid }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                司机编号
                            </td>
                            <td >
                                <input type="text" name="driverid" value="${lclass.driverid }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                上行配送点
                            </td>
                            <td >
                                <input type="text" name="startpointid" value="${lclass.startpointid }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                下行配送点
                            </td>
                            <td>
                                <input type="text" name="endpointid" value="${lclass.endpointid }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                货物重量
                            </td>
                            <td >
                                <input type="text" name="weight" value="${lclass.weight }"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                上行到达时间
                            </td>
                            <td >
                            <!-- 将数据库中日期数据格式化后输出 -->
                                <input type="text" name="classendtime" value="<fmt:formatDate value="${lclass.classendtime }" pattern="yyyy-mm-dd"/>"></input>
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