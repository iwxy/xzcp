"use strict";
layui.define(["layer"], function(exprots) {
	var $ = layui.jquery;
	var okUtils = {
		/**
		 * 是否前后端分离
		 */
		isFrontendBackendSeparate : true,
		/**
		 * 服务器地址
		 */
		baseUrl : "http://localhost:7050/xzcp",
		/**
		 * 获取body的总宽度
		 */
		getBodyWidth : function() {
			return document.body.scrollWidth;
		},
		/**
		 * 主要用于对ECharts视图自动适应宽度
		 */
		echartsResize : function(element) {
			var element = element || [];
			window.addEventListener("resize", function() {
				var isResize = localStorage.getItem("isResize");
				// if (isResize == "false") {
				for (let i = 0; i < element.length; i++) {
					element[i].resize();
				}
				// }
			});
		},
		/**
		 * ajax()函数二次封装
		 * 
		 * @param url
		 * @param type
		 * @param params
		 * @param load
		 * @returns {*|never|{always, promise, state, then}}
		 */
		ajax : function(url, type, params, load) {
			var deferred = $.Deferred();
			var loadIndex;
			$.ajax({
				url : okUtils.isFrontendBackendSeparate
						? okUtils.baseUrl + url
						: url,
				type : type || "get",
				data : params || {},
				dataType : "json",
				beforeSend : function() {
					if (load) {
						loadIndex = layer.load(0, {
							shade : 0.3
						});
					}
				},
				success : function(data) {
					if (data.code == 0) {
						// 业务正常
						deferred.resolve(data)
					} else {
						// 业务异常
						layer.msg(data.msg, {
							icon : 5,
							time : 2000
						});
						deferred.reject("okUtils.ajax warn: " + data.msg);
					}
				},
				complete : function() {
					if (load) {
						layer.close(loadIndex);
					}
				},
				error : function() {
					layer.close(loadIndex);
					layer.msg("服务器错误", {
						icon : 2,
						time : 2000
					});
					deferred.reject("okUtils.ajax error: 服务器错误");
				}
			});
			return deferred.promise();
		},

		// 获取跳转路径？后面的参数（一个参数）
		oneValues : function() {
			var result;
			var url = decodeURI(window.location.search); // 获取url中"?"符后的字串
			if (url.indexOf("?") != -1) {
				result = url.substr(url.indexOf("=") + 1);
			}
			return result;
		},

		// 获取跳转路径？后面的参数（多个参数）
		manyValues : function() {
			var url = decodeURI(window.location.search);
			if (url.indexOf("?") != -1) {
				var str = url.substr(1);
				strs = str.split("&");
				// key是名，value是值，传过来的参数分别被存在两个数组中
				var key = new Array(strs.length);
				var value = new Array(strs.length);
				for (i = 0; i < strs.length; i++) {
					key[i] = strs[i].split("=")[0]
					value[i] = unescape(strs[i].split("=")[1]);
				}
			}
			return value;
		},

		// 用cookie传值，这个方法能获取cookie中的值
		getCookie : function() {
			// keysplit的值为：userId=16478004,userIdentity=3
			var keysplit = document.cookie.split(';');
			// keysplit.length为2
			var result = new Array(keysplit.length);
			for (var i = 0; i < keysplit.length; i++) {
				// keysplit[0].trim为userId=16478004
				// keysplit[1].trim为userIdentity=3
				// 去掉前后空格，c为userId=16478004
				var c = keysplit[i].trim();
				// 截取c中=后面的值，返回
				result[i] = c;
			}
			return result;
		},

		/**
		 * 主要用于针对表格批量操作操作之前的检查 判断表格有多少条数据被选中，并将被选中的id组成字符串返回
		 * 
		 * @param table
		 * @returns {string}
		 */
		tableBatchCheck : function(table) {
			// layui自带的方法，可返回被选中的对象
			var checkStatus = table.checkStatus("tableId");
			// 获得有多少行被选中
			var rows = checkStatus.data.length;
			if (rows > 0) {
				var idsStr = "";
				// 获取被选中数据的id，放入字符串idsStr中，用“，”分隔
				for (var i = 0; i < checkStatus.data.length; i++) {
					idsStr += checkStatus.data[i].id + ",";
				}
				return idsStr;
			} else {
				layer.msg("未选择有效数据", {
					offset : "t",
					anim : 6
				});
			}
		},
		/**
		 * 在表格页面操作成功后弹窗提示
		 * 
		 * @param content
		 */
		tableSuccessMsg : function(content) {
			layer.msg(content, {
				icon : 1,
				time : 1000
			}, function() {
				// 刷新当前页table数据
				$(".layui-laypage-btn")[0].click();
			});
		},
		/**
		 * 获取父窗体的okTab
		 * 
		 * @returns {string}
		 */
		getOkTab : function() {
			return parent.objOkTab;
		},
		/**
		 * 格式化当前日期
		 * 
		 * @param date
		 * @param fmt
		 * @returns {void | string}
		 */
		dateFormat : function(date, fmt) {
			var o = {
				"M+" : date.getMonth() + 1,
				"d+" : date.getDate(),
				"h+" : date.getHours(),
				"m+" : date.getMinutes(),
				"s+" : date.getSeconds(),
				"q+" : Math.floor((date.getMonth() + 3) / 3),
				"S" : date.getMilliseconds()
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1)
							? (o[k])
							: (("00" + o[k]).substr(("" + o[k]).length)));
			return fmt;
		},
		number : {
			/**
			 * 判断是否为一个正常的数字
			 * 
			 * @param num
			 */
			isNumber : function(num) {
				if (num && !isNaN(num)) {
					return true;
				}
				return false;
			},
			/**
			 * 判断一个数字是否包括在某个范围
			 * 
			 * @param num
			 * @param begin
			 * @param end
			 */
			isNumberWith : function(num, begin, end) {
				if (this.isNumber(num)) {
					if (num >= begin && num <= end) {
						return true;
					}
					return false;
				}
			},
		}
	};
	exprots("okUtils", okUtils);
});
