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

    <script src="${include}/js/laydate/laydate.js"></script> <!--主样式-->
    <script src="${include}/js/timejs.js"></script>

	<script class="resources library" src="${include}/js/jquery-1.8.2.js" type="text/javascript"></script>
	<script class="resources library" src="${include}/js/highcharts.js" type="text/javascript"></script>
</head>
<body>

    <div class="someinformation">
        <div class="pagemain">
            <div class="big2">
                <p class="tit">报表&nbsp;/&nbsp;报表显示</p>
                <hr>
                <form action="#" method="post">
                    <table style="text-align: center ;width: 70vw">
                        <tr>
                            <td style="width: 10%;text-align: center">
                                查询：
                            </td>
                            <td style="width: 20%">
                                <select id="timesort" onchange="ts()">
                                    <option value="0" selected>—请选择查询条件—</option>
                                    <option value="1">按所选日期所在月份</option>
                                    <option value="2">按所选日期所在季度</option>
                                    <option value="3">按所选日期所在年份</option>
                                </select>
                            </td>
                           
                            <td  style="align="left";width: 64%">
                                 <!--时间控件： <input type="text" id="time_journaling_show"> -->
                                 
                                 <select id="year" style="display: none;">
                                    <option value="0" selected>&nbsp;请选择年份</option>
                                    <option value="2014">&nbsp;—&nbsp;&nbsp;2014&nbsp;&nbsp;—</option>
                                    <option value="2015">&nbsp;—&nbsp;&nbsp;2015&nbsp;&nbsp;—</option>
                                    <option value="2016">&nbsp;—&nbsp;&nbsp;2016&nbsp;&nbsp;—</option>
                                    <option value="2017">&nbsp;—&nbsp;&nbsp;2017&nbsp;&nbsp;—</option>
                                    <option value="2018">&nbsp;—&nbsp;&nbsp;2018&nbsp;&nbsp;—</option>
                                    <option value="2019">&nbsp;—&nbsp;&nbsp;2019&nbsp;&nbsp;—</option>
                                    <option value="2020">&nbsp;—&nbsp;&nbsp;2020&nbsp;&nbsp;—</option>
                                    <option value="2021">&nbsp;—&nbsp;&nbsp;2021&nbsp;&nbsp;—</option>
                               	 </select>
                               	 <select id="month" style="display: none;">
                                    <option value="0" selected>&nbsp;请选择月份</option>
                                    <option value="01">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;1&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="02">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="03">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="04">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;4&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="05">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="06">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="07">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="08">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;8&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="09">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;&nbsp;9&nbsp;&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="10">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="11">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;—</option>
                                    <option value="12">&nbsp;&nbsp;—&nbsp;&nbsp;&nbsp;12&nbsp;&nbsp;&nbsp;—</option>
                               	 </select >
                               	 <select id="quarter" style="display: none;">
                                    <option value="0" selected>&nbsp;&nbsp;请选择季度</option>
                                    <option value="1">—第一季度—</option>
                                    <option value="2">—第二季度—</option>
                                    <option value="3">—第三季度—</option>
                                    <option value="4">—第四季度—</option>
                               	 </select>
                                
                            </td>
                             <td  style="width: 6%">
                                <input  id="sr" type="button" value="查询" onclick="search()">
                            </td>
                        </tr>
                    </table>
                    
                    <hr>
                    <br>
                    
                    <table id="showtable" style="text-align: center;width: 70vw;">
                        <thead>
                        <tr>
             	           <th style="width: 15%">
                                配送点编号
                            </th>
                            <th style="width: 20%">
                                配送点
                            </th>
                            <th style="width: 25%">
                                配送货物总质量（KG)
                            </th>
                            <th style="width: 20%">
                                总体积（CM<sup>3</sup>）
                            </th>
                            <th style="width: 20%">
                                配送收入
                            </th>
                         </tr>
                     </thead>
                        <tbody id="searchresult">		
								
						</tbody>	
                    </table>
                    
                    <!-- 测试表格 -->
                   <table id="datatable" border="1" style="display: none">
					    <thead>
					        <tr>
					             <th>配送点</th>
					             <th>总收入</th>
					        </tr>
					    </thead>
					    <tbody id = "sshow">
					        <tr>
					            <th>A</th>
					            <td>50</td>
					        </tr>
					        <tr>
					            <th>B</th>
					            <td>100</td>
					        </tr>
					        <tr>
					            <th>c</th>
					            <td>150</td>
					        </tr>
					    </tbody>
					</table>


                    <!-- 测试表格结束 -->
                    
                    <br>
                    <p style="color: red;text-align: center;" id="ha"></p>
                    <font style="color: red;float: right" id="ttt"></font>
                    <br>
                    <br>
                    <input style="float: right;width: 100px;" type="button" value="导出EXCEL" onclick="method1('showtable')" />
                    <br>
                    <br>
                    <hr>
                    <br>
                    图像显示:
                    <div id="container" style="width: 100%; height: 280px"></div>

                </form>
            </div>
        </div>
    </div>
    
<script type="text/javascript">
function aa(){ 
var chart;
Highcharts.visualize = function(table, options) {
    options.series = [];
    var l= options.series.length; 
    options.series[l] = {
      name: '比例',
      data: []
    };

    $('tbody tr', table).each( function(i) {
        var tr = this;
        var th = $('th', tr).text();
        var td =parseFloat($('td', tr).text());
        options.series[0].data.push({name:th,y:td});
    });
    chart = new Highcharts.Chart(options);
}

$(document).ready(function() {         
   var table = $("#datatable"),
   options = {
         chart: {
            renderTo: 'container',
            defaultSeriesType: 'pie'
         },
         title: {
            text: '统计数据'
         },
         tooltip: {
            formatter: function() {
               return '<b>'+ this.series.name +'</b><br/>'+
               this.point.name +' '+ this.y;
            }
         },
         plotOptions: {
             pie: {
                 allowPointSelect: true,
                 cursor: 'pointer'
             }
         }
      };
   Highcharts.visualize(table, options);
});

}
</script>


<script type="text/javascript">
  function ttt()
  {
	  var date = new Date();
      var seperator1 = "-";
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var strDate = date.getDate();
      if (month >= 1 && month <= 9) {
          month = "0" + month;
      }
      if (strDate >= 0 && strDate <= 9) {
          strDate = "0" + strDate;
      }
      var currentdate = year + seperator1 + month + seperator1 + strDate;
      alert(currentdate); 
  }
  
  function ts(){	
  	var timesort = $("#timesort").val();
	//还没选
  	if(timesort == 0)
  	{  
  		$("#year").attr("style","display: none;");  
  		$("#month").attr("style","display: none;");  
  		$("#quarter").attr("style","display: none;");
  		$("#year").val(0);
  		$("#month").val(0);
  		$("#quarter").val(0);
  		
  	}
  	//按月份查询
	if(timesort == 1)
  	{  
  		
		$("#year").attr("style","display: inline-block;");  
  		$("#month").attr("style","display: inline-block;");  
  		$("#quarter").attr("style","display: none;");
  		$("#year").val(0);
  		$("#month").val(0);
  		$("#quarter").val(0);
  	}
  	//按季度查询
  	if(timesort == 2)
  	{  
  		$("#year").attr("style","display: inline-block;");  
  		$("#month").attr("style","display: none;"); 
  		$("#quarter").attr("style","display: inline-block;");
  		$("#year").val(0);
  		$("#month").val(0);
  		$("#quarter").val(0);
  	}
  	//按年份查询
  	if(timesort == 3)
  	{  
  		$("#year").attr("style","display: inline-block;");  
  		$("#month").attr("style","display: none;");
  		$("#quarter").attr("style","display: none;");
  		$("#year").val(0);
  		$("#month").val(0);
  		$("#quarter").val(0);
  	}
  }
  
  function search()
  {
	  	$("#ha").html(""); 
	  	$("#ttt").html("");
	  	var timesort = $("#timesort").val();
	  	var y = $("#year").val();
		var m = $("#month").val();
		var q = $("#quarter").val();
		//==========================获取当前时间==================================
		var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
		//=====================================================================
		
		//还没选
	  	if(timesort == 0)
	  	{  
	  		alert("请选择报表查询方式");
	  	}
	  	//按月份查询
		if(timesort == 1)
	  	{  
	  		if(y == 0||m == 0)
	  		{
	  			alert("请选择完整条件！");		
	  		}
	  		else
	  		{
	  			//拼接月份格式
	  			var startMonth = y+"-"+m;
	  			//执行查询方法
	  			$.ajax({
			    	type: "post",
			        async: false,
			        url: "selectbymonth",
			        data: {	"startMonth": startMonth
			        	  },
			        	  success:function(jourResults){
						   		 
						        var html="";
						   		 for(var i = 0;i<jourResults.length;i++)
									{
										html+="<tr><td>"+jourResults[i].pointid+
										"</td><td>"+jourResults[i].pointname+
										"</td><td>"+jourResults[i].w+
										"</td><td>"+jourResults[i].v+
										"</td><td>"+jourResults[i].c+
										"</td></tr>";
									}
						   		 var html2="";
							   		for(var i = 0;i<jourResults.length;i++)
									{
						   			html2+="<tr><th>"+jourResults[i].pointname+
									"</th><td>"+jourResults[i].c+
									"</td></tr>";
									}
						   		 if(html=="")
						   			{
						   			$("#ha").html("未查到信息"); 
						   			}
						   		 else{
								   		$("#ttt").html("报表生成时间："+currentdate);
							   		 }
						   		$("#searchresult").html(html);
						   		$("#sshow").html(html2);
						   		aa();
						    }
	  			})
	  		}
	  	}
	  	//按季度查询
	  	if(timesort == 2)
	  	{  
	  		if(y == 0||q == 0)
	  		{
	  			alert("请选择完整条件");		
	  		}
	  		else
	  		{
	  			//拼接季度格式
	  			var startt = "";
	  			var endt = "";
	  			if(q==1){
	  				//第一季度
	  				startt = y+"-01";
	  				endt = y+"-03";
	  			}
	  			if(q==2){
	  				//第二季度
	  				startt = y+"-04";
	  				endt = y+"-06";
	  			}
	  			if(q==3){
	  				//第三季度
	  				startt = y+"-07";
	  				endt = y+"-09";
	  			}
	  			if(q==4){
	  				//第四季度
	  				startt = y+"-10";
	  				endt = y+"-12";
	  			}
	  			//执行查询方法
	  			$.ajax({
			    	type: "post",
			        async: false,
			        url: "selectbyquarter",
			        data: {	"startt": startt,
			        		"endt": endt
			        	  },
			        	  success:function(jourResults){
						   		 //请求成功之后的操作
						   		 var html="";
						   		 for(var i = 0;i<jourResults.length;i++)
									{
						   			html+="<tr><td>"+jourResults[i].pointid+
									"</td><td>"+jourResults[i].pointname+
									"</td><td>"+jourResults[i].w+
									"</td><td>"+jourResults[i].v+
									"</td><td>"+jourResults[i].c+
									"</td></tr>";
									}
						   		 var html2="";
							   		for(var i = 0;i<jourResults.length;i++)
									{
						   			html2+="<tr><th>"+jourResults[i].pointname+
									"</th><td>"+jourResults[i].c+
									"</td></tr>";
									}
						   		if(html=="")
					   			{
					   				$("#ha").html("未查到信息"); 
					   			}
					   		else{
						   		$("#ttt").html("报表生成时间："+currentdate);
					   		 }
				   		$("#searchresult").html(html);
				   		$("#sshow").html(html2);
				   		aa();
						    }
	  			})
	  		}
	  	}
	  	//按年份查询
	  	if(timesort == 3)
	  	{  
	  		var flag = 0;
	  		if(y == 0)
	  		{
	  			alert("请选择完整条件");		
	  		}
	  		else
	  		{
	  			//执行查询方法
	  			$.ajax({
			    	type: "post",
			        async: false,
			        url: "selectbyyear",
			        data: {	"startYear": y
			        	  },
				   	success:function(jourResults){
				   		 //请求成功之后的操作
				   		 
				   		 var html="";
				   		 for(var i = 0;i<jourResults.length;i++)
							{
				   			html+="<tr><td>"+jourResults[i].pointid+
							"</td><td>"+jourResults[i].pointname+
							"</td><td>"+jourResults[i].w+
							"</td><td>"+jourResults[i].v+
							"</td><td>"+jourResults[i].c+
							"</td></tr>";
							}
				   		var html2="";
				   		for(var i = 0;i<jourResults.length;i++)
						{
			   			html2+="<tr><th>"+jourResults[i].pointname+
						"</th><td>"+jourResults[i].c+
						"</td></tr>";
						}
				   		
				   		 if(html=="")
				   			{
				   				$("#ha").html("未查到信息"); 
				   			}
				   		else{
					   		$("#ttt").html("报表生成时间："+currentdate);
					   		
				   		 }
				   		
			   		$("#searchresult").html(html);
			   		$("#sshow").html(html2);
			   		aa();
				    }
	  			
	  			})
	  			
	  			
	  		}
	  		
	  	}  	
  }
   </script>
    
    
    <script type="text/javascript" language="javascript">
        var idTmr;
        function  getExplorer() {
            var explorer = window.navigator.userAgent ;
            //ie
            if (explorer.indexOf("MSIE") >= 0) {
                return 'ie';
            }
            //firefox
            else if (explorer.indexOf("Firefox") >= 0) {
                return 'Firefox';
            }
            //Chrome
            else if(explorer.indexOf("Chrome") >= 0){
                return 'Chrome';
            }
            //Opera
            else if(explorer.indexOf("Opera") >= 0){
                return 'Opera';
            }
            //Safari
            else if(explorer.indexOf("Safari") >= 0){
                return 'Safari';
            }
        }
        function method1(tableid) {//整个表格拷贝到EXCEL中
            if(getExplorer()=='ie') {
                var curTbl = document.getElementById(tableid);
                var oXL = new ActiveXObject("Excel.Application");

                //创建AX对象excel
                var oWB = oXL.Workbooks.Add();
                //获取workbook对象
                var xlsheet = oWB.Worksheets(1);
                //激活当前sheet
                var sel = document.body.createTextRange();
                sel.moveToElementText(curTbl);
                //把表格中的内容移到TextRange中
                sel.select;
                //全选TextRange中内容
                sel.execCommand("Copy");
                //复制TextRange中内容
                xlsheet.Paste();
                //粘贴到活动的EXCEL中
                oXL.Visible = true;
                //设置excel可见属性

                try {
                    var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
                } catch (e) {
                    print("Nested catch caught " + e);
                } finally {
                    oWB.SaveAs(fname);

                    oWB.Close(savechanges = false);
                    //xls.visible = false;
                    oXL.Quit();
                    oXL = null;
                    //结束excel进程，退出完成
                    //window.setInterval("Cleanup();",1);
                    idTmr = window.setInterval("Cleanup();", 1);
                }
            } else {
                tableToExcel('showtable')
            }
        }
        function Cleanup() {
            window.clearInterval(idTmr);
            CollectGarbage();
        }

        /*
            template ： 定义文档的类型，相当于html页面中顶部的<!DOCTYPE> 声明。（个人理解，不确定）
            encodeURIComponent:解码
            unescape() 函数：对通过 escape() 编码的字符串进行解码。
            window.btoa(window.encodeURIComponent(str)):支持汉字进行解码。
            \w ：匹配包括下划线的任何单词字符。等价于’[A-Za-z0-9_]’
            replace()方法：用于在字符串中用一些字符替换另一些字符，或替换一个与正则表达式匹配的子串。
            {(\w+)}：匹配所有 {1个或更多字符} 形式的字符串；此处匹配输出内容是 “worksheet”
            正则中的() ：是为了提取匹配的字符串。表达式中有几个()就有几个相应的匹配字符串。
            讲解(/{(\w+)}/g, function(m, p) { return c[p]; } ：
                /{(\w+)}/g 匹配出所有形式为“{worksheet}”的字符串；
                function参数：  m  正则所匹配到的内容，即“worksheet”；
                                p  正则表达式中分组的内容,即“(\w+)”分组中匹配到的内容，为“worksheet”；
                c ：为object，见下图3
                c[p] : 为“worksheet”

        */
        var tableToExcel = (function() {
            var uri = 'data:application/vnd.ms-excel;base64,',
            template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
            base64 = function(s) {
                return window.btoa(unescape(encodeURIComponent(s)))
            },
            // 下面这段函数作用是：将template中的变量替换为页面内容ctx获取到的值
            format = function(s, c) {
                    return s.replace(/{(\w+)}/g,
                                    function(m, p) {
                                        return c[p];
                                    }
                    )
            };
            return function(table, name) {
                if (!table.nodeType) {
                    table = document.getElementById(table)
                }
                // 获取表单的名字和表单查询的内容
                var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML};
                // format()函数：通过格式操作使任意类型的数据转换成一个字符串
                // base64()：进行编码
                window.location.href = uri + base64(format(template, ctx))
            }
        })()
    </script>
    
</body>
</html>