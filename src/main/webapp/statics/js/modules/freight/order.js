$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'freight/list',
        datatype: "json",
        height: 385,
        colNames: ['id','请求ID','客户类型','发货仓库名称','运输到达省份','运输到达城市','运输到达区县','运输到达详细地址','系统计算运费','实际运费','创建人','创建时间','修改人','修改时间'],
        colModel: [
            {name: 'id', index: 'id', width: 50, key: true },
            {name: 'requestId', index: 'request_id', width: 80 },
            {name: 'customerType', index: 'customer_type', width: 80 },
            {name: 'warehouseName', index: 'warehouse_name', width: 80 },
            {name: 'toProvince', index: 'to_province', width: 80 },
            {name: 'toCity', index: 'to_city', width: 80 },
            {name: 'toArea', index: 'to_area', width: 80 },
            {name: 'address', index: 'address', width: 80 },
            {name: 'expectFee', index: 'expect_fee', width: 80 },
            {name: 'actualFee', index: 'actual_fee', width: 80 },
            {name: 'createUser', index: 'create_user', width: 80 },
            {name: 'createTime', index: 'create_time', width: 80 },
            {name: 'updateUser', index: 'update_user', width: 80 },
            {name: 'updateTime', index: 'update_time', width: 80 }
        ],
        rowNum: 10,
        rowList : [10,30,50],
        pager: "#jqGridPager",
        viewrecords: true,
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        }

        // subGrid: true,
        // subGridRowExpanded: function(subgrid_id, row_id){
        //     var subgrid_table_id, pager_id;
        //     subgrid_table_id = subgrid_id + "_t";
        //     pager_id = "p_" + subgrid_table_id;
        //     $("#" + subgrid_id).html("<table id = '"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
        //     $("#" + subgrid_table_id).jqGrid(
        //         {
        //             url: baseURL + "freight/list/detail/" + row_id,
        //             dataType: "json",
        //             colModel: [
        //                 { label: 'id', name: 'id', index: 'id', width: 50, key: true },
        //                 { label: '订单ID', name: 'orderId', index: 'order_id', width: 80 },
        //                 { label: 'sku', name: 'sku', index: 'sku', width: 80 },
        //                 { label: '是否赠品', name: 'isGift', index: 'is_gift', width: 80 },
        //                 { label: '商品名称', name: 'name', index: 'name', width: 80 },
        //                 { label: '商品单价', name: 'unitPrice', index: 'unit_price', width: 80 },
        //                 { label: '数量', name: 'number', index: 'number', width: 80 },
        //                 { label: '商品重量', name: 'weight', index: 'weight', width: 80 },
        //                 { label: '宽度', name: 'width', index: 'width', width: 80 },
        //                 { label: '高度', name: 'height', index: 'height', width: 80 },
        //                 { label: '长度', name: 'length', index: 'length', width: 80 }
        //             ],
        //             rowNum:10,
        //             pager: pager_id,
        //             jsonReader : {
        //                 root: "pagedetail.list",
        //                 page: 1,
        //                 total: 2,
        //                 records: 2
        //             },
        //             prmNames : {
        //                 page:"page",
        //                 rows:"limit",
        //                 order: "order",
        //                 order_id: row_id
        //             },
        //         });
        //     $("#" + subgrid_table_id).jqGrid('navGrid',"#" + pager_id, {
        //         edit:false,
        //         add:false,
        //         del:false
        //     });
        // },
        // subGridRowColapsed: function(subgrid_id,row_id){
        //
        // }

        // gridComplete:function(){
        //     //隐藏grid底部滚动条
        //     $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        // }
    });
    $("#jqGrid").jqGrid('navGrid', '#jqGridPager', {
        add : false,
        edit : false,
        del : false
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            customerType: null,
            warehouseName:null
        },
        showList: true,
        title: null,
        freight: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.freight = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.freight.id == null ? "freight/save" : "freight/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.freight),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "freight/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function(id){
            $.get(baseURL + "freight/info/"+id, function(r){
                vm.freight = r.freight;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'customerType': vm.q.customerType,'warehouseName':vm.q.warehouseName},
                page:page
            }).trigger("reloadGrid");
        }
    }
});