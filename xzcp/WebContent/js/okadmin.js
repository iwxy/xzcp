var objOkTab = "";
layui
		.use(
				[ "element", "layer", "okUtils", "okTab", "okLayer",
						"jQContextMenu" ],
				function() {
					var okUtils = layui.okUtils;
					var $ = layui.jquery;
					var layer = layui.layer;
					var okLayer = layui.okLayer;

					// 通过url（?userId=16478004）传值
					// var userId = okUtils.oneValues();
					// alert("参数为：" + userId);
					// 获取多个参数
					// var paras = okUtils.manyValues();
					// var userId = paras[0];
					// var userName = paras[1];
					// var userIdentity = paras[2];

					// var getUser = "userId=" + userId;

					// 通过cookie传参
					var params = okUtils.getCookie();
					var userId = params[0];

					var getUser = "userId=" + userId;

					okUtils
							.ajax("/user/getUser", "post", getUser, true)
							.done(
									function(response) {
										var user;
										var url;
										user = response.data;
										if (user.userIdentity == 1) {
											url = "../data/instructornavs.json";
										} else if (user.userIdentity == 2) {
											url = "../data/teachernavs.json";
										} else if (user.userIdentity == 3) {
											url = "../data/studentnavs.json";
										} else {
											url = "../data/committeenavs.json";
										}

										$("span.userName").html(user.userName);

										var okTab = layui.okTab({
											// 菜单请求路径
											url : url,
											// 允许同时选项卡的个数
											openTabNum : 30,
											// 如果返回的结果和navs.json中的数据结构一致可省略这个方法
											parseData : function(data) {
												return data;
											}
										});
										objOkTab = okTab;

										/**
										 * 左侧导航渲染完成之后的操作
										 */
										okTab
												.render(function() {
													/** tab栏的鼠标右键事件* */
													$("body .ok-tab")
															.contextMenu(
																	{
																		width : 'auto',
																		itemHeight : 30,
																		menu : [
																				{
																					text : "定位所在页",
																					icon : "ok-icon ok-icon-location",
																					callback : function() {
																						okTab
																								.positionTab();
																					}
																				},
																				{
																					text : "关闭当前页",
																					icon : "ok-icon ok-icon-roundclose",
																					callback : function() {
																						okTab
																								.tabClose(1);
																					}
																				},
																				{
																					text : "关闭其他页",
																					icon : "ok-icon ok-icon-roundclose",
																					callback : function() {
																						okTab
																								.tabClose(2);
																					}
																				},
																				{
																					text : "关闭所有页",
																					icon : "ok-icon ok-icon-roundclose",
																					callback : function() {

																						okTab
																								.tabClose(3);
																					}
																				} ]
																	});
												});

										/**
										 * 添加新窗口
										 */
										$("body")
												.on(
														"click",
														"#navBar .layui-nav-item a, #userInfo a",
														function() {
															// 如果不存在子级
															if ($(this)
																	.siblings().length == 0) {
																okTab
																		.tabAdd($(this));
															}
															// 关闭其他展开的二级标签
															$(this)
																	.parent(
																			"li")
																	.siblings()
																	.removeClass(
																			"layui-nav-itemed");
															if (!$(this).attr(
																	"lay-id")) {
																var topLevelEle = $(
																		this)
																		.parents(
																				"li.layui-nav-item");
																var childs = $(
																		"#navBar > li > dl.layui-nav-child")
																		.not(
																				topLevelEle
																						.children("dl.layui-nav-child"));
																childs
																		.removeAttr("style");
															}
														});

										/**
										 * 左侧菜单展开动画
										 */
										$("#navBar")
												.on(
														"click",
														".layui-nav-item a",
														function() {
															if (!$(this).attr(
																	"lay-id")) {
																var superEle = $(
																		this)
																		.parent();
																var ele = $(
																		this)
																		.next(
																				'.layui-nav-child');
																var height = ele
																		.height();
																ele
																		.css({
																			"display" : "block"
																		});
																// 是否是展开状态
																if (superEle
																		.is(".layui-nav-itemed")) {
																	ele
																			.height(0);
																	ele
																			.animate(
																					{
																						height : height
																								+ "px"
																					},
																					function() {
																						ele
																								.css({
																									height : "auto"
																								});
																					});
																} else {
																	ele
																			.animate(
																					{
																						height : 0
																					},
																					function() {
																						ele
																								.removeAttr("style");
																					});
																}
															}
														});

										/**
										 * 左边菜单显隐功能
										 */
										$(".ok-menu")
												.click(
														function() {
															$(
																	".layui-layout-admin")
																	.toggleClass(
																			"ok-left-hide");
															$(this)
																	.find("i")
																	.toggleClass(
																			"ok-menu-hide");
															localStorage
																	.setItem(
																			"isResize",
																			false);
															setTimeout(
																	function() {
																		localStorage
																				.setItem(
																						"isResize",
																						true);
																	}, 1200);
														});

										/**
										 * 移动端的处理事件
										 */
										$("body")
												.on(
														"click",
														".layui-layout-admin .ok-left a[data-url], .ok-make",
														function() {
															if ($(
																	".layui-layout-admin")
																	.hasClass(
																			"ok-left-hide")) {
																$(
																		".layui-layout-admin")
																		.removeClass(
																				"ok-left-hide");
																$(".ok-menu")
																		.find(
																				'i')
																		.removeClass(
																				"ok-menu-hide");
															}
														});

										/**
										 * tab左右移动
										 */
										$("body")
												.on(
														"click",
														".okNavMove",
														function() {
															var moveId = $(this)
																	.attr(
																			"data-id");
															var that = this;
															okTab.navMove(
																	moveId,
																	that);
														});

										/**
										 * 刷新当前tab页
										 */
										$("body").on("click", ".ok-refresh",
												function() {
													okTab.refresh(this);
												});

										/**
										 * 关闭tab页
										 */
										$("body").on(
												"click",
												"#tabAction a",
												function() {
													var num = $(this).attr(
															"data-num");
													okTab.tabClose(num);
												});

										/**
										 * 全屏/退出全屏
										 */
										$("body")
												.on(
														"keydown",
														function(event) {
															event = event
																	|| window.event
																	|| arguments.callee.caller.arguments[0];
															// 按 Esc
															if (event
																	&& event.keyCode === 27) {
																console
																		.log("Esc");
																$("#fullScreen")
																		.children(
																				"i")
																		.eq(0)
																		.removeClass(
																				"okicon-screen-restore");
															}
															// 按 F11
															if (event
																	&& event.keyCode == 122) {
																$("#fullScreen")
																		.children(
																				"i")
																		.eq(0)
																		.addClass(
																				"okicon-screen-restore");
															}
														});

										$("body")
												.on(
														"click",
														"#fullScreen",
														function() {
															if ($(this)
																	.children(
																			"i")
																	.hasClass(
																			"okicon-screen-restore")) {
																screenFun(2)
																		.then(
																				function() {
																					$(
																							this)
																							.children(
																									"i")
																							.eq(
																									0)
																							.removeClass(
																									"okicon-screen-restore");
																				});
															} else {
																screenFun(1)
																		.then(
																				function() {
																					$(
																							this)
																							.children(
																									"i")
																							.eq(
																									0)
																							.addClass(
																									"okicon-screen-restore");
																				});
															}
														});

										/**
										 * 全屏和退出全屏的方法
										 * 
										 * @param num
										 *            1代表全屏 2代表退出全屏
										 * @returns {Promise}
										 */
										function screenFun(num) {
											num = num || 1;
											num = num * 1;
											var docElm = document.documentElement;

											switch (num) {
											case 1:
												if (docElm.requestFullscreen) {
													docElm.requestFullscreen();
												} else if (docElm.mozRequestFullScreen) {
													docElm
															.mozRequestFullScreen();
												} else if (docElm.webkitRequestFullScreen) {
													docElm
															.webkitRequestFullScreen();
												} else if (docElm.msRequestFullscreen) {
													docElm
															.msRequestFullscreen();
												}
												break;
											case 2:
												if (document.exitFullscreen) {
													document.exitFullscreen();
												} else if (document.mozCancelFullScreen) {
													document
															.mozCancelFullScreen();
												} else if (document.webkitCancelFullScreen) {
													document
															.webkitCancelFullScreen();
												} else if (document.msExitFullscreen) {
													document.msExitFullscreen();
												}
												break;
											}

											return new Promise(function(res,
													rej) {
												res("返回值");
											});
										}

										/**
										 * 弹窗皮肤
										 */
										$("#alertSkin")
												.click(
														function() {
															okLayer
																	.open(
																			"皮肤动画",
																			"system/alertSkin.html",
																			"50%",
																			"45%",
																			function(
																					layero) {
																			},
																			function() {
																			});
														});

										/**
										 * 退出操作
										 */
										$("#logout")
												.click(
														function() {
															okLayer
																	.confirm(
																			"确定要退出吗？",
																			function(
																					index) {
																				window.location = "../login.html";
																			});
														});

									}).fail(function(error) {
								console.log(error)
							});

				});
