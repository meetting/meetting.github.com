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
                <p class="tit">审核&nbsp/&nbsp配送价格审核</p>
                <hr>
                <form>
                    <table >
                        <tr>
                            <td style="width: 60%;text-align: center">
                                发货配送点
                            </td>
                            <td style="width: 40%">
                                <input type="text" id = "startpoint">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                收获配送点
                            </td>
                            <td >
                                 <input type="text" id = "endpoint">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                首公斤
                            </td>
                            <td >
                                <input type="text" id="firstweight" name="firstweight">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                首公斤价格
                            </td>
                            <td >
                                <input type="text" id="firstweightprice" name="firstweightprice">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                次公斤
                            </td>
                            <td >
                                <input type="text" id="secondweight" name="secondweight">
                            </td>
                        </tr>


                        <tr>
                            <td style="text-align: center">
                                次公斤价格
                            </td>
                            <td >
                                <input type="text" id="secondweightprice" name="secondweightprice">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                首立方
                            </td>
                            <td >
                                <input type="text" id="firstvol" name="firstvol">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                首立方价格
                            </td>
                            <td >
                                <input type="text" id="firstvolprice" name="firstvolprice">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                次立方
                            </td>
                            <td >
                                <input type="text" id="secondvol" name="secondvol">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                次立方价格
                            </td>
                            <td >
                                <input type="text" id="secondvolprice" name="secondvolprice">
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td style="float: right">
                                <input type="button"value="通过" id="pass">
                                <input type="button"value="不通过" id="nopass">
                            </td>
                        </tr>

                    </table>

                </form>
            </div>
        </div>
</div>
<script type="text/javascript" src='../resources/include/js/common.js' charset='utf-8'></script>
<script type="text/javascript" src='../resources/include/js/check_price_check.js' charset='utf-8'></script>
</body>
</html>