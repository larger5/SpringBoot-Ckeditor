CKEDITOR.replace('content')
//初始化博文首页标题
$.ajax({
	type: "get",
	//http://localhost/diary/getall
	url: "http://localhost/diary/getall",
	data: {
		user_id: 1
	},
	success: function(data) {
		console.log(data)
		for(var i = 0; i < data.length; i++) {
			//解析结果数据,将解析得到的结果数据填充到#cun中
			var title = data[i].title;
			var time = "[" + data[i].dateToString + "]";
			var f = $('<font color=#CDCDCD>' + time + '</font>')
			var href="http://localhost/diary/get/"+data[i].diaryId;//简单使用 ckeditor！
			var a = $('<a></a>').append(title).attr("href",href); //万能组合
			var b = $("<a href='#' class='btn btn-danger btn-xs'>删除</a>"); //万能组合
			var diaryId=data[i].diaryId//巨坑：这个必须var并且放在函数外面
			b.click(function() { //万能组合
				delDiary(diaryId); //万能组合
			}); //万能组合
			$("#cun").append(f).append(a).append(b).append("<hr>");
		}
	}
})
//初始化博主个人信息
$.ajax({
	type: "get",
	//http://localhost/user/usermsg
	url: "http://localhost/user/usermsg",
	data: {
		user_id: 1
	},
	success: function(data) {
		console.log(data)
		$("#personal").append("<img src=" + data.imageName + "/>")
			.append("<br/><blockquote class='blockquote-reverse'><p>" + data.mood + "</p><footer><cite title='Source Title'></cite></footer></blockquote>")
	}
})
//初始化博文类型类别信息
$.ajax({
	type: "get",
	//http://localhost/diarytype/typeandcount
	url: "http://localhost/diarytype/typeandcount",
	data: {
		user_id: 1
	},
	success: function(data) {
		console.log(data)
		for(var i = 0; i < data.length; i++) {
			//解析结果数据,将解析得到的结果数据填充到#cun中
			$("#Diarytype").append("<a href='#'>" + data[i].typeName + "(" + data[i].diaryCount + ")" + "</a><hr/>")
		}
	}
})
//初始化博文日期类别信息
$.ajax({
	type: "get",
	//http://localhost/diary/getdate
	url: "http://localhost/diary/getdate",
	data: {
		user_id: 1
	},
	success: function(data) {
		console.log(data)
		for(var i = 0; i < data.length; i++) {
			//解析结果数据,将解析得到的结果数据填充到#cun中
			$("#Datetype").append("<a href='#'>" + data[i].dateToString + "(" + data[i].diaryCount + ")" + "</a><hr/>")
		}
	}
})
//删除日志备用函数，//万能组合
function delDiary(id) {
	$.ajax({
		//http://localhost/diary/delete?id=6
		url: "http://localhost/diary/delete?id=" + id,
		type: "get",
		success: function(result) {
			alert('删除成功')
		}
	});
}
