package cn.xzcp.controll;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.ClassMes;
import cn.xzcp.bean.ItemMes;
import cn.xzcp.bean.RecordMes;
import cn.xzcp.bean.ResponseResult;
import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;
import cn.xzcp.service.ClassService;
import cn.xzcp.service.ItemService;
import cn.xzcp.service.RecordService;
import cn.xzcp.service.UserService;

@Controller
@RequestMapping("/record")
public class RecordController {

	@Autowired
	private RecordService recordService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	@Autowired
	private ClassService classService;

	/**
	 * 得到某班委管理的所有考评项的信息
	 */
	@RequestMapping("/getCommitteeAllItem")
	@ResponseBody
	public ResponseResult getCommitteeAllItem(int userId) {
		UserMes userMes = userService.getUser(userId);
		List<ItemMes> data;
		data = itemService.getCommitteeAllItem(userMes.getUserIdentity());
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}

	}

	/**
	 * 添加记录
	 */
	@RequestMapping("/addRecord")
	@ResponseBody
	public ResponseResult addRecord(RecordMes recordMes, String recordDates) throws Exception {
		recordMes.setRecordDate(recordDates);
		boolean b = recordService.addRecord(recordMes);
		if (b) {
			return ResponseResult.build(0, "添加成功！");
		} else {
			return ResponseResult.build(1, "添加失败！");
		}

	}

	/**
	 * 获得某个班委所记录的所有考评记录
	 */
	@RequestMapping("/getAllCommitteeRecord")
	@ResponseBody
	public ResponseResult getAllCommitteeRecord(RecordMes recordMes, HttpSession session) {
		List<RecordMes> data;
		try {
			recordMes.setRecordDate("");
			User user = (User) session.getAttribute("user");
			recordMes.setRecordCommitteeid(user.getUserId());
			data = recordService.getPageCommitteeRecord(recordMes);
			// 一共有多少条数据
			int count = recordService.getAllCommitteeRecord(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 批量删除记录，也可单个
	 */
	@RequestMapping("/deleteRecord")
	@ResponseBody
	public ResponseResult deleteRecord(String idsStr) throws Exception {
		String idsArray[] = idsStr.split(",");
		boolean b = recordService.deleteRecord(idsArray);
		if (b) {
			return ResponseResult.build(0, "删除成功！");
		} else {
			return ResponseResult.build(1, "删除失败！");
		}

	}

	/**
	 * 通过学号、时间组合查询，得到recordMes对象
	 */
	@RequestMapping("/seachRecordIT")
	@ResponseBody
	public ResponseResult seachRecordIT(RecordMes recordMes, String recordDates, HttpSession session) {
		List<RecordMes> data;

		try {
			recordMes.setRecordDate(recordDates);
			User user = (User) session.getAttribute("user");
			recordMes.setRecordCommitteeid(user.getUserId());
			data = recordService.getPageCommitteeRecord(recordMes);
			// 一共有多少条教师数据
			int count = recordService.getAllCommitteeRecord(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 通过recordId查询，得到recordMes对象
	 */
	@RequestMapping("/getRecordById")
	@ResponseBody
	public ResponseResult getRecordById(RecordMes record) {
		RecordMes data = recordService.getRecordById(record.getRecordId());
		if (data == null) {
			return ResponseResult.build(1, "该记录不存在");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}
	}

	/**
	 * 修改考评记录的信息
	 */
	@RequestMapping("/changeRecord")
	@ResponseBody
	public ResponseResult changeRecord(RecordMes recordMes, String recordDates) throws Exception {

		recordMes.setRecordDate(recordDates);
		boolean b = recordService.changeRecord(recordMes);
		if (b) {
			return ResponseResult.build(0, "修改成功！");
		} else {
			return ResponseResult.build(1, "修改失败！");
		}

	}

	/**
	 * 获得某个学生的所有记录
	 */
	@RequestMapping("/getRecordS")
	@ResponseBody
	public ResponseResult getRecordS(RecordMes recordMes, HttpSession session) {
		List<RecordMes> data;
		try {
			recordMes.setRecordDate("");
			recordMes.setRecordDatel("");
			User user = (User) session.getAttribute("user");
			recordMes.setRecordStudentid(user.getUserId());
			data = recordService.getPageRecordS(recordMes);
			// 一共有多少条数据
			int count = recordService.getAllRecordS(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 通过起止时间查询，某个学生的所有记录
	 */
	@RequestMapping("seachRecordS")
	@ResponseBody
	public ResponseResult seachRecordS(RecordMes recordMes, String recordDates, String recordDatel,
			HttpSession session) {
		List<RecordMes> data;
		try {
			recordMes.setRecordDate(recordDates);
			recordMes.setRecordDatel(recordDatel);
			User user = (User) session.getAttribute("user");
			recordMes.setRecordStudentid(user.getUserId());
			data = recordService.getPageRecordS(recordMes);
			// 一共有多少条数据
			int count = recordService.getAllRecordS(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 获得所有学生的所有记录
	 */
	@RequestMapping("/getRecordI")
	@ResponseBody
	public ResponseResult getRecordI(RecordMes recordMes, HttpSession session) {
		List<RecordMes> data;
		try {
			recordMes.setRecordDate("");
			recordMes.setRecordDatel("");
			recordMes.setRecordStudentName("");
			data = recordService.getPageRecordI(recordMes);
			// 一共有多少条数据
			int count = recordService.getAllRecordI(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 通过班级，起止时间，学号，姓名，考评项查询，所有学生的所有记录
	 */
	@RequestMapping("seachRecordI")
	@ResponseBody
	public ResponseResult seachRecordI(RecordMes recordMes, String recordDates, String recordDatel,
			HttpSession session) {
		List<RecordMes> data;
		try {
			recordMes.setRecordDate(recordDates);
			recordMes.setRecordDatel(recordDatel);
			data = recordService.getPageRecordI(recordMes);
			// 一共有多少条数据
			int count = recordService.getAllRecordI(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 获得所有班级的信息
	 */
	@RequestMapping("/getAllClass")
	@ResponseBody
	public ResponseResult getAllClass() {
		List<ClassMes> data;
		try {
			data = classService.getAllClass();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 获得所有班级的信息
	 */
	@RequestMapping("/getAllItem")
	@ResponseBody
	public ResponseResult getAllItem() {
		List<ItemMes> data;
		try {
			data = itemService.getAllItem();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 得到某班主任所教的所有班级的信息
	 */
	@RequestMapping("/getAllTClass")
	@ResponseBody
	public ResponseResult getAllTClass(HttpSession session) {
		List<ClassMes> data;
		try {
			User user = (User) session.getAttribute("user");
			int userId = user.getUserId();
			data = classService.getAllTClass(userId);
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 获得某班主任所教的所有学生的所有记录
	 */
	@RequestMapping("/getRecordT")
	@ResponseBody
	public ResponseResult getRecordT(RecordMes recordMes, HttpSession session) {
		List<RecordMes> data;
		try {
			recordMes.setRecordDate("");
			recordMes.setRecordDatel("");
			recordMes.setRecordStudentName("");
			User user = (User) session.getAttribute("user");
			recordMes.setRecordTeacherid(user.getUserId());
			data = recordService.getPageRecordT(recordMes);
			// 一共有多少条数据
			int count = recordService.getAllRecordT(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

	/**
	 * 通过班级，起止时间，学号，姓名，考评项查询，某班主任所教的所有学生的所有记录
	 */
	@RequestMapping("seachRecordT")
	@ResponseBody
	public ResponseResult seachRecordT(RecordMes recordMes, String recordDates, String recordDatel,
			HttpSession session) {
		List<RecordMes> data;
		try {
			recordMes.setRecordDate(recordDates);
			recordMes.setRecordDatel(recordDatel);
			User user = (User) session.getAttribute("user");
			recordMes.setRecordTeacherid(user.getUserId());
			data = recordService.getPageRecordT(recordMes);
			// 一共有多少条数据
			int count = recordService.getAllRecordT(recordMes).size();
			if (data.size() == 0) {
				return ResponseResult.build(1, "无数据");
			} else {
				return ResponseResult.build(0, "查询成功", count, data);
			}
		} catch (Exception e) {
			return ResponseResult.build(1, "服务器错误，请重新登录！");
		}

	}

}
