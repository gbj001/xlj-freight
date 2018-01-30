$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'freight/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '请求ID', name: 'requestId', index: 'request_id', width: 80 }, 			
			{ label: '运输始发地', editoptions:{name: 'fromCity', index: 'from_province'}, width: 80 },
			{ label: '运输开始城市', name: 'fromCity', index: 'from_city', width: 80 },
			{ label: '运输开始区县', name: 'fromArea', index: 'from_area', width: 80 },
			{ label: '运输到达省份', name: 'toProvince', index: 'to_province', width: 80 }, 			
			{ label: '运输到达城市', name: 'toCity', index: 'to_city', width: 80 },
			{ label: '运输到达区县', name: 'toArea', index: 'to_area', width: 80 },
			{ label: '运输到达详细地址', name: 'address', index: 'address', width: 80 },
			{ label: '系统计算运费', name: 'expectFee', index: 'expect_fee', width: 80 }, 			
			{ label: '实际运费', name: 'actualFee', index: 'actual_fee', width: 80 }, 			
			{ label: '创建人', name: 'createUser', index: 'create_user', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '修改人', name: 'updateUser', index: 'update_user', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }			
        ],
		viewrecords: false,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
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
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
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
                page:page
            }).trigger("reloadGrid");
		}
	}
});