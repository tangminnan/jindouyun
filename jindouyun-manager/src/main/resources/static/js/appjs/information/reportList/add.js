$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	
	var reportName = $('input[name="reportName"]').val();
	if(reportName.length<=0 || reportName == null){
		return alert("报告名称不能为空！！！");
	}
	
	var choosecontent = new Array();
	$(".choosecontent").each(function (index, val) {
		var choosess = {
				sort:$(val).find("input[name = 'sort']").val()?$(val).find("input[name = 'sort']").val():" ",
				title:$(val).find("input[name = 'title']").val()?$(val).find("input[name = 'title']").val():" ",
				content:$(val).find("#content").val()?$(val).find("#content").val():" ",
		}
		choosecontent.push(choosess);
	})
	console.info(choosecontent);
	
	var report = {
		reportNum : $('input[name="reportNum"]').val(),
		reportName : $('input[name="reportName"]').val(),
		reportList: choosecontent,
	}
	
	
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/reportList/save",
		contentType: "application/json",
		dataType: "json",
		data : JSON.stringify(report),
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			
		},
		messages : {
			name : {
				required : icon + "请输入编号"
			},
			
		}
	})
}