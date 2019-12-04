layui.use([ 'form', 'layer', 'upload', 'laydate', 'okAddlink', 'okUtils',
		'okLayer' ], function() {
	var form = layui.form;
	var layer = layui.layer;
	var upload = layui.upload;
	var $ = layui.jquery;
	var laydate = layui.laydate;
	var $form = $('form');
	var okUtils = layui.okUtils;
	var okLayer = layui.okLayer;
	var okAddlink = layui.okAddlink.init({
		province : 'select[name=province]',
		city : 'select[name=city]',
		area : 'select[name=area]',
	});

	// $("div.userClass").hide();

	// laydate.render({
	// elem : '#uDate', // 指定元素
	// max : "2019-1-1",
	// value : '2017-09-10',
	// });

	// 通过cookie传参
	var params = okUtils.getCookie();
	var userId = params[0];

	var getUser = "userId=" + userId;

	okUtils.ajax("/user/getUser", "post", getUser, true).done(
			function(response) {
				var user = response.data;

				$("#userId").val(user.userId);
				$("#userName").val(user.userName);
				$("#userClassName").val(user.userClassName);
				$("#userIdentityName").val(user.userIdentityName);
				$("#userDormitory").val(user.userDormitory);
				$("#userPhone").val(user.userPhone);
				var arr = user.userAddress.split(',');
				// alert(arr[0]);
				// alert(arr[1]);
				// $("#province").val(arr[0]);
				$("#province option[value='0'] ").text(arr[0]);
				$("#city option[value='0'] ").text(arr[1]);
				$("#area option[value='0'] ").text(arr[2]);
				$("#userAddress").val(arr[3]);

				if (user.userSex == "男") {
					$("#userSexnan").attr("checked", 'checked');
				} else {
					$("#userSexnv").attr("checked", 'checked');
				}

				if (user.userIdentity == 1 || user.userIdentity == 2) {
					$(".userClassName").hide();
					$(".userDormitory").hide();
					$(".userId").text("教工号");
				}

				okAddlink.render();// 渲染三级联动省市区

				// 这里加一个如果点击省，第一个potion变成请选择

				form.on("submit(changeUser)", function(data) {

					var province = $("#province").find("option:selected")
							.text();
					var city = $("#city").find("option:selected").text();
					var area = $("#area").find("option:selected").text();
					var address = data.field.userAddress;
					if (province == "请选择省") {
						okLayer.redCryMsg("请选择省！", function() {
						});
						return false;
					}
					if (city == "请选择市") {
						okLayer.redCryMsg("请选择市！", function() {
						});
						return false;
					}
					if (area == "请选择县/区") {
						okLayer.redCryMsg("请选择县/区！", function() {
						});
						return false;
					}
					data.field.userAddress = province + "," + city + "," + area
							+ "," + address;
					okUtils.ajax("/user/changeUser", "post", data.field, true)
							.done(function(response) {

								okLayer.greenTickMsg(response.msg, function() {

								});

							}).fail(function(error) {
								console.log(error)
							});

					return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
				})

			}).fail(function(error) {
		console.log(error)
	});

});
