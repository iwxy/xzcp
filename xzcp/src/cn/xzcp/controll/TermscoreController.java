package cn.xzcp.controll;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.ClassMes;
import cn.xzcp.bean.ResponseResult;
import cn.xzcp.bean.TermscoreMes;
import cn.xzcp.bean.User;
import cn.xzcp.service.ClassService;
import cn.xzcp.service.TermscoreService;

@Controller
@RequestMapping("/termscore")
public class TermscoreController {

	@Autowired
	private TermscoreService termscoreService;

	@Autowired
	private ClassService classService;

	/**
	 * 获得某个学生的所有学期分数
	 */
	@RequestMapping("/getTermscoreS")
	@ResponseBody
	public ResponseResult getTermscoreS(TermscoreMes termscoreMes, HttpSession session) {
		List<TermscoreMes> data;
		try {
			User user = (User) session.getAttribute("user");
			termscoreMes.setTermscoreStudentid(user.getUserId());
			data = termscoreService.getPageTermscoreS(termscoreMes);
			// 一共有多少条数据
			int count = termscoreService.getAllTermscoreS(termscoreMes).size();
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
	 * 获得termscore表中所有学期的信息
	 */
	@RequestMapping("/getAllDate")
	@ResponseBody
	public ResponseResult getAllDate() {
		List<TermscoreMes> data;
		try {
			data = termscoreService.getAllDate();
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
	 * 获得某个教师所教的所有学生的学期分数
	 */
	@RequestMapping("/getTermscoreT")
	@ResponseBody
	public ResponseResult getTermscoreT(TermscoreMes termscoreMes, HttpSession session) {
		List<TermscoreMes> data;
		try {
			termscoreMes.setTermscoreDate("");
			termscoreMes.setTermscoreStudentName("");
			User user = (User) session.getAttribute("user");
			termscoreMes.setTermscoreTeacherid(user.getUserId());
			data = termscoreService.getPageTermscoreT(termscoreMes);
			// 一共有多少条数据
			int count = termscoreService.getAllTermscoreT(termscoreMes).size();
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
	 * 通过学期、班级、学号、姓名查询，获得某个教师所教的学生的学期分数
	 */
	@RequestMapping("seachTermscoreT")
	@ResponseBody
	public ResponseResult seachTermscoreT(TermscoreMes termscoreMes, HttpSession session) {
		List<TermscoreMes> data;
		try {
			User user = (User) session.getAttribute("user");
			termscoreMes.setTermscoreTeacherid(user.getUserId());
			data = termscoreService.getPageTermscoreT(termscoreMes);
			// 一共有多少条数据
			int count = termscoreService.getAllTermscoreT(termscoreMes).size();
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
	 * 获得所有学生的学期分数
	 */
	@RequestMapping("/getTermscoreI")
	@ResponseBody
	public ResponseResult getTermscoreI(TermscoreMes termscoreMes, HttpSession session) {
		List<TermscoreMes> data;
		try {
			termscoreMes.setTermscoreDate("");
			termscoreMes.setTermscoreStudentName("");
			data = termscoreService.getPageTermscoreI(termscoreMes);
			// 一共有多少条数据
			int count = termscoreService.getAllTermscoreI(termscoreMes).size();
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
	 * 通过学期、班级、学号、姓名查询，获得某个教师所教的学生的学期分数
	 */
	@RequestMapping("seachTermscoreI")
	@ResponseBody
	public ResponseResult seachTermscoreI(TermscoreMes termscoreMes, HttpSession session) {
		List<TermscoreMes> data;
		try {
			data = termscoreService.getPageTermscoreI(termscoreMes);
			// 一共有多少条数据
			int count = termscoreService.getAllTermscoreI(termscoreMes).size();
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
