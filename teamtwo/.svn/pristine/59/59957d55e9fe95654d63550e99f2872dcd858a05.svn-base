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
                <p class="tit">运力&nbsp/&nbsp寻找路线</p>
                <hr>
                <form action="#" method="post">
                    <table>
                        <tr>
                            <td style="width: 60%;text-align: center">
                                查询：
                            </td>
                            <td style="width: 40%">
                                <select id="selectedstyle">
                                <option>----请选择查询信息----</option>
                                <option>路线id</option>
                                <option>起始配送点</option>
                                <option>目的配送点</option>
                                <option>路线长度</option>
                                </select>           
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                内容：
                            </td>
                            <td >
                                <input type="text" id="inputinfo">
                            </td>
                        </tr>
                        <tr>
                            <td >
                            </td>
                            <td style="float:right">
                                <input type="button" onclick="findlinestyle()" value="确定">
                            </td>
                        </tr>
                    </table>

                </form>
                
                <c:if test="${not empty seeklineinfo}">
                <form action="#" method="post">
                    <table style="text-align: center">
                        <tr>
                            <th style="width: 20%">
                                路线编号
                            </th>
                            <th style="width: 30%">
                                起始配送点
                            </th>
                            <th style="width: 26%">
                                目的配送点
                            </th>
                            <th style="width: 24%">
                                路线距离
                            </th>                     
                        </tr>
                        <c:forEach items="${seeklineinfo}" var="info" begin="0">
                        <tr>
                          <td>
                            <c:out value="${info.roadid }"/>
                          </td>
                          <td>
                            <c:out value="${info.startpointname }"/>
                          </td>
                          <td>
                            <c:out value="${info.endpointname}"/>
                          </td>
                          <td>
                            <c:out value="${info.roadlength }"/>
                          </td>                     
                        </tr>   
                        
                         <%-- <tr>
                        <c:forEach items="${info}" var="map" begin="0">
                            <td >
                                 <c:out value="${map.value }"/>      
                            </td>                        
                        </c:forEach>                         
                        </tr> --%>
                        
                        </c:forEach>
                    </table>

                </form>
                </c:if>
            </div>
        </div>
</div>

<script type="text/javascript">
 function findlinestyle(){
	 var selectedstyle=document.getElementById("selectedstyle").value;
	 var inputinfo=document.getElementById("inputinfo").value;
	 if(selectedstyle=="路线id"){
		 window.location.href="seektransportcapacitylinebyid?roadid="+inputinfo;
	 }
	 if(selectedstyle=="起始配送点"){
		 window.location.href="seektransportcapacitylinebystartpointname?startpointname="+inputinfo;
	 }
	 if(selectedstyle=="目的配送点"){
		 window.location.href="seektransportcapacitylinebyendpointname?endpointname="+inputinfo;
	 }
	 if(selectedstyle=="路线长度"){
		 window.location.href="seektransportcapacitylinebyroadlength?roadlength="+inputinfo;
	 }
 }
</script>
</body>
</html>