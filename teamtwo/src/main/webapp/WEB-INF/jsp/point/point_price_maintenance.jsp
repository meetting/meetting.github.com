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
     
    <script type="text/javascript" src='../resources/include/js/jquery-1.8.2.js' charset='utf-8'></script>
    <script type="text/javascript" src='../resources/include/js/jquery.validate.js' charset='utf-8'></script>
    <script type="text/javascript" src='../resources/include/js/jquery.min.js' charset='utf-8'></script>
</head>
<body>

    <div class="someinformation">
        <div class="pagemain">
            <div class="big1">
                <p class="tit">配送点&nbsp/&nbsp价格维护</p>
                <hr>
                <form>
                    <table style="text-align: center">
                        <thead>
                        <tr>
                        	<th style="width: 7%">
                                <!-- 复选框-->
                            </th>
                            <th style="width: 7%">
                                发货配送点
                            </th>
                            <th style="width: 7%">
                                收获配送点
                            </th>
                            <th style="width: 7%">
                                首公斤
                            </th>
                            <th style="width: 7%">
                                首公斤价格
                            </th>
                            <th style="width: 7%">
                                次公斤
                            </th>
                            <th style="width: 7%">
                                次公斤价格
                            </th>
                            <th style="width: 8%">
                                首立方
                            </th>
                            <th style="width: 7%">
                                首立方价格
                            </th>
                            <th style="width: 8%">
                                次立方
                            </th>
                            <th style="width: 7%">
                                次立方价格
                            </th>
                            <th style="width: 7%">
                                审核情况
                            </th>
                            <th style="width: 7%">
                                备注
                            </th>
                            <th style="width: 7%">
                                修改
                            </th>
                        </tr>
						</thead>
						
						<tbody id="charge-list"></tbody>
                        <tfoot>
                        <tr>
                            <td>
                                <a type="button" value="增加" href="pointaddprice">增加</a>
                            </td>
                            <td>
                                <a type="button" value="删除" id="delete-check">删除</a>
                            </td>
                        </tr>
                        </tfoot>
                    </table>

                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript" src='../resources/include/js/common.js' charset='utf-8'></script>
	<script type="text/javascript" src='../resources/include/js/point_price_maintenance.js' charset='utf-8'></script>
</body>
</html>