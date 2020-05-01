"use strict";
layui
		.define(
				[],
				function(exprots) {
					let okMock = {
						api : {

							// listTeacher :
							// "http://localhost:7050/xzcp/user/getAllTeacher",
							// listUClassStudent :
							// "http://localhost:7050/xzcp/user/getUClassStudent",
							// listTStudent :
							// "http://localhost:7050/xzcp/user/getAllTStudent",
							// listStudent :
							// "http://localhost:7050/xzcp/user/getAllStudent",
							// listSeachTUserCIN :
							// "http://localhost:7050/xzcp/user/seachTUserCIN",
							// listSeachUserCIN :
							// "http://localhost:7050/xzcp/user/seachUserCIN",
							// listClass :
							// "http://localhost:7050/xzcp/class/getAllClass",
							// listItem :
							// "http://localhost:7050/xzcp/item/getAllItem",
							// listIdentity :
							// "http://localhost:7050/xzcp/identity/getAllIdentity",
							// listCommitteeRecord :
							// "http://localhost:7050/xzcp/record/getAllCommitteeRecord",
							// listSeachRecordIT :
							// "http://localhost:7050/xzcp/record/seachRecordIT",
							// listStudentScore :
							// "http://localhost:7050/xzcp/score/getScoreS",
							// listSeachStudentScore :
							// "http://localhost:7050/xzcp/score/seachScoreS",
							// listStudentTermscore :
							// "http://localhost:7050/xzcp/termscore/getTermscoreS",
							// listStudentRecord :
							// "http://localhost:7050/xzcp/record/getRecordS",
							// listSeachStudentRecord :
							// "http://localhost:7050/xzcp/record/seachRecordS",
							// listInstructorRecord :
							// "http://localhost:7050/xzcp/record/getRecordI",
							// listSeachInstructorRecord :
							// "http://localhost:7050/xzcp/record/seachRecordI",
							// listInstructorScore :
							// "http://localhost:7050/xzcp/score/getScoreI",
							// listSeachInstructorScore :
							// "http://localhost:7050/xzcp/score/seachScoreI",
							// listInstructorTermscore :
							// "http://localhost:7050/xzcp/termscore/getTermscoreI",
							// listSeachInstructorTermscore :
							// "http://localhost:7050/xzcp/termscore/seachTermscoreI",
							// listTeacherRecord :
							// "http://localhost:7050/xzcp/record/getRecordT",
							// listSeachTeacherRecord :
							// "http://localhost:7050/xzcp/record/seachRecordT",
							// listTeacherScore :
							// "http://localhost:7050/xzcp/score/getScoreT",
							// listSeachTeacherScore :
							// "http://localhost:7050/xzcp/score/seachScoreT",
							// listTeacherTermscore :
							// "http://localhost:7050/xzcp/termscore/getTermscoreT",
							// listSeachTeacherTermscore :
							// "http://localhost:7050/xzcp/termscore/seachTermscoreT",

							login : "https://www.easy-mock.com/mock/5d5d0dd46cfcbd1b8627bf1d/ok-admin-v2.0/login",
							bsgrid : "http://rap2api.taobao.org/app/mock/233041/bsgrid",
							datatables : "http://rap2api.taobao.org/app/mock/233041/datatables",
							listUser : "http://rap2api.taobao.org/app/mock/233041/user/listUser",
							listRole : "http://rap2api.taobao.org/app/mock/233041/role/listRole",
							listArticle : "http://rap2api.taobao.org/app/mock/233041/article/listArticle",
							listMessage : "http://rap2api.taobao.org/app/mock/233041/message/listMessage",
							listProduct : "http://rap2api.taobao.org/app/mock/233041/product/listProduct",
							listDownload : "http://rap2api.taobao.org/app/mock/233041/download/listDownload",
							listLink : "http://rap2api.taobao.org/app/mock/233041/link/listLink",
							listTask : "http://rap2api.taobao.org/app/mock/233041/task/listTask",
							listImage : "http://rap2api.taobao.org/app/mock/233041/image/listImage",
							listBbs : "http://rap2api.taobao.org/app/mock/233041/bbs/listBbs",

							menu : {
								list : "https://easy-mock.com/mock/5d0ce725424f15399a6c2068/okadmin/menu/list"
							},
							user : {
								list : "http://rap2api.taobao.org/app/mock/233041/user/list",
							},
							role : {
								list : "http://rap2api.taobao.org/app/mock/233041/role/list"
							},
							permission : {
								list : "http://rap2api.taobao.org/app/mock/233041/permission/list",
							},
							article : {
								list : "http://rap2api.taobao.org/app/mock/233041/article/list"
							},
							task : {
								list : "http://rap2api.taobao.org/app/mock/233041/task/list"
							},
							link : {
								list : "http://rap2api.taobao.org/app/mock/233041/link/list"
							},
							product : {
								list : "http://rap2api.taobao.org/app/mock/233041/product/list"
							},
							log : {
								list : "https://easy-mock.com/mock/5d0ce725424f15399a6c2068/okadmin/log/list"
							},
							message : {
								list : "http://rap2api.taobao.org/app/mock/233041/message/list"
							},
							download : {
								list : "http://rap2api.taobao.org/app/mock/233041/download/list"
							},
							bbs : {
								list : "http://rap2api.taobao.org/app/mock/233041/bbs/list"
							}
						}
					};
					exprots("okMock", okMock);
				});
