layui.use([ 'form', 'layer', 'okUtils', 'okLayer' ], function() {
	var form = layui.form;
	var layer = layui.layer;
	var $ = layui.jquery;
	var $form = $('form');
	var okUtils = layui.okUtils;
	var okLayer = layui.okLayer;

	// 通过cookie传参
	var params = okUtils.getCookie();
	var userId = params[0];

	var getUser = "userId=" + userId;

	okUtils.ajax("/user/getUser", "post", getUser, true).done(
			function(response) {
				var user = response.data;

				$("#userId").val(user.userId);
				$("#userName").val(user.userName);

				if (user.userIdentity == 1 || user.userIdentity == 2) {
					$(".userId").text("教工号");
				}

				// 添加验证规则verify
				form.verify({
					pass : [ /^[\S]{6,16}$/, '密码必须6到16位，且不能出现空格' ],
					oldPwd : function(value, item) {
						if (value != user.password) {
							return "密码错误，请重新输入！";
						}
					},
					confirmPwd : function(value, item) {
						if (!new RegExp($("#oldPwd").val()).test(value)) {
							return "两次输入密码不一致，请重新输入！";
						}
					},

				});

				// 修改密码
				form.on("submit(changePwd)", function(data) {
					// 提交中,请等候显示2000毫秒
					// var index = layer.msg('提交中，请稍候', {
					// icon : 16,
					// time : false,
					// shade : 0.8
					// });
					// setTimeout(function() {
					// layer.close(index);
					//						
					// layer.msg("密码修改成功！");
					// $(".pwd").val('');
					// }, 2000);

					okUtils.ajax("/user/changePwd", "post", data.field, true)
							.done(function(response) {

								okLayer.greenTickMsg(response.msg, function() {

								})

							}).fail(function(error) {
								console.log(error)
							});

					return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
				})

			}).fail(function(error) {
		console.log(error)
	});

});
