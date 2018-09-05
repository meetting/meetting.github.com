//
// function addShop() {
//
//     $("#dlgShop").modal("show");
//     $("#id").val("");
//
// }
//
// /**
//  * 新增/更新学生
//  */
// function  saveStudent() {
//
//     var id=$("#id").val();
//     if(id==null||id==""){
//
//
//         $.ajax({
//             url:'/webapi/student/add',
//             contentType: 'application/json;charset=utf-8',
//             data: {"name": $("#name").val()
//                 , "password":$("#password").val()
//                 ,"loginTime":$("#loginTime").val()
//             },
//             success:function (rs) {
//
//                 loadTable();
//                 $("#dlgStudent").modal("hide");
//             }
//         })
//
//
//     }else{
//         //不是新增，是更新
//
//         $.ajax({
//             url:'/webapi/student/update',
//             contentType: 'application/json;charset=utf-8',
//             data: {
//                 "id":id,
//                 "name": $("#name").val()
//                 , "password":$("#password").val()
//                 ,"ip":$("#ip").val()
//             },
//             success:function (rs) {
//
//                 loadTable();
//                 $("#dlgStudent").modal("hide");
//             }
//         })
//     }
//
// }
//
// /**
//  * 删除学生
//  */
// function  deleteStudent() {
//     if(confirm("是否真的要删除数据吗？")){
//         var rows = $("#tbStudent").bootstrapTable('getSelections');
//         // 返回所有选择的行，当没有选择的记录时，返回一个空数组
//
//         if (rows.length == 0) {
//             alert("请勾选择要删除的数据！");
//             return;
//         }
//         var ids = new Array();
//         // 遍历所有选择的行数据，取每条数据对应的ID
//         $.each(rows, function (i, row) {
//             ids[i] = row["id"];
//         });
//         $.ajax({
//             type: 'POST',
//             data: {
//                 "ids": ids
//             },
//             url: "/webapi/student/delete",
//             success: function (r) {
//
//                 loadTable();
//
//                 return;
//             }
//         });
//
//
//
//     }//end confirm
//
// }
//
// /**
//  * 显示编辑对话框
//  */
// function showUpdateModel(id) {
//     $("#dlgStudent").modal("show");
//     $.ajax({
//         url:'/webapi/student/get/'+id
//         ,success:function (rs) {
//
//             var row=rs;
//             $("#id").val(row.id);
//             $("#name").val(row.name);
//             $("#ip").val(row.ip);
//
//         }
//
//     })
//
//
// }
function loadTable(){
    $("#tbShop").bootstrapTable('destroy');
    $('#tbShop').bootstrapTable({
        url: '/getAllShop',   //请求后台的URL（*）
        method: 'get',        //请求方式（*）
        //toolbar: '#toolbar',  //工具按钮用哪个容器
        striped: true,        //是否显示行间隔色
        //cache: false,         //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,     //是否显示分页（*）
        //sortable: true,       //是否启用排序
        //sortOrder: "asc",     //排序方式
        // queryParams: Search,  //传递参数（*）
        sidePagination: "client",     //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                //初始化加载第一页，默认第一页
        pageSize: 3,                 //每页的记录行数（*）
        pageList: [3,10, 25, 50, 100],  //可供选择的每页的行数（*）
        //search: false,                //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        //strictSearch: true,
        //showColumns: true,      //是否显示所有的列
        //showRefresh: true,     //是否显示刷新按钮
        //minimumCountColumns: 1, //最少允许的列数
        //clickToSelect: true,    //是否启用点击选中行
        height: 500,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        //uniqueId: "id",         //每一行的唯一标识，一般为主键列
        //showToggle: true,       //是否显示详细视图和列表视图的切换按钮
        //cardView: true,         //是否显示详细视图
        //detailView: false,      //是否显示父子表
        columns: [{
            checkbox: true
        }, {
            field: 'shopId',
            title: '店铺Id'
        }, {
            field: 'ownerId',
            title: '所属用户id'
        }, {
            field: 'areaId',
            title: '地域Id'
        }, {
            field: 'shopCategoryId',
            title: '店铺类别'
        },{
            field: 'shopName',
            title: '店名'
        },{
            field: 'shopDesc',
            title: '店铺描述'
        },{
            field: 'shopAddr',
            title: '店铺地址'
        },{
            field: 'phone',
            title: '店铺电话'
        },{
            field: 'shopImg',
            title: '店铺照'
        },{
            field: 'longitude',
            title: '经度'
        },{
            field: 'latitude',
            title: '纬度'
        },{
            field: 'priority',
            title: '优先级'
        },{
            field: 'createTime',
            title: '创建时间'
        },{
            field: 'lastEditTime',
            title: '最后编辑时间'
        },{
            field: 'enableStatus',
            title: '状态'
        },{
            field: 'advice',
            title: '超级管理员给店铺的提醒'
        },{
            title: '操作',
            field: 'id',
            align: 'center',
            formatter: function (value, row, index) {
                var e = '<a class="btn btn-primary " href="#" mce_href="#" title="编辑" onclick="showUpdateModel(\''
                    + row.id
                    + '\')"></a> ';

                return e;
            }
        }
        ]
    });

}

$(function () {
    loadTable();
});//end $function

