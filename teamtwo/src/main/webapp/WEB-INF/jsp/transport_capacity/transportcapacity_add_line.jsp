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
            <div class="big2">
                <p class="tit">运力&nbsp/&nbsp增加路线</p>
                <hr>
                <form action="addtransportcapacityline" method="post">
                    <table>
                        <tr>
                            <td style="width: 60%;text-align: center">
                                路线编号
                            </td>
                            <td style="width: 40%">
                                <input type="text" name="roadid">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                起始配送点
                            </td>
                            <td >
                                <input type="text" name="startpointid">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                目的配送点
                            </td>
                            <td >
                                <input type="text" name="endpointid">
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center">
                                线路距离
                            </td>
                            <td >
                                <input type="text" name="roadlength">
                            </td>
                        </tr>

                        <tr>
                            <td >
                            </td>
                            <td style="float: right">
                                <input type="submit" value="提交">
                                <input type="reset" value="重置">
                            </td>
                        </tr>
                    </table>

                </form>
            </div>
        </div>

    </div>

</body>
</html>