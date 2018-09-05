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
            <div class="big2">
                <p class="tit">配送点&nbsp/&nbsp价格查找</p>
                <hr>
                <form action="#" method="post">
                    <table style="text-align: center">
                        <tr>
                            <td style="width: 60%">
                                发货配送点：
                            </td>
                            <td style="width: 40%">
                                <select id="startpoint"></select>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                收货配送点：
                            </td>
                            <td >
                                <select id="endpoint"></select>
                            </td>
                        </tr>
                        <tr>
                            <td >
                            </td>
                            <td style="float: right">
                                <input type="button"  id="submit" value="确定">
                            </td>
                        </tr>
                    </table>

                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript" src='../resources/include/js/common.js' charset='utf-8'></script>
	<script type="text/javascript" src='../resources/include/js/point_seek_price.js' charset='utf-8'></script>
</body>
</html>