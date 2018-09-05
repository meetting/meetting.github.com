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
                <p class="tit">配送点&nbsp/&nbsp配送点列表</p>
                <hr>
                <form action="#" method="post">
                    <table style="width: 70vw;text-align: center">
                    <thead>
                        <tr>
                            <th style="width: 15%">
                                选择框
                            </th>
                            <th style="width: 5%">
                                ID
                            </th>
                            <th style="width: 10%">
                                名称
                            </th>
                            <th style="width: 15%">
                                邮编
                            </th>
                            <th style="width: 20%">
                                地址
                            </th>
                            <th style="width: 13%">
                                电话
                            </th>
                            <th style="width: 13%">
                                总收入
                            </th>
                            <th style="width: 22%">
                                修改
                            </th>
                        </tr>
                        </thead>
                        <tbody id="point-list"></tbody>
                        <tfoot>
                        <tr>
                            <td>
                                <a type="button" value="增加" href="pointadd">增加</a>
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
	<script type="text/javascript" src='../resources/include/js/point_list.js' charset='utf-8'></script>
</body>
</html>