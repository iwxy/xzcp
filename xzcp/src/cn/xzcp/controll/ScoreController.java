package cn.xzcp.controll;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.ClassMes;
import cn.xzcp.bean.ResponseResult;
import cn.xzcp.bean.ScoreMes;
import cn.xzcp.bean.User;
import cn.xzcp.service.ClassService;
import cn.xzcp.service.ScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private ClassService classService;

	/**
	 * 获得某个学生的所有月分数
	 */
	@RequestMapping("/getScoreS")
	@ResponseBody
	public ResponseResult getScoreS(ScoreMes scoreMes, HttpSession session) {
		List<ScoreMes> data;
		try {
			scoreMes.setScoreDate("");
			scoreMes.setScoreDatel("");
			User user = (User) session.getAttribute("user");
			scoreMes.setScoreStudentid(user.getUserId());
			data = scoreService.getPageScoreS(scoreMes);
			// 一共有多少条数据
			int count = scoreService.getAllScoreS(scoreMes).size();
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
	 * 通过起止时间查询，某个学生的所有月分数
	 */
	@RequestMapping("seachScoreS")
	@ResponseBody
	public ResponseResult seachScoreS(ScoreMes scoreMes, String scoreDates, String scoreDatel, HttpSession session) {
		List<ScoreMes> data;
		try {
			scoreMes.setScoreDate(scoreDates);
			scoreMes.setScoreDatel(scoreDatel);
			User user = (User) session.getAttribute("user");
			scoreMes.setScoreStudentid(user.getUserId());
			data = scoreService.getPageScoreS(scoreMes);
			// 一共有多少条数据
			int count = scoreService.getAllScoreS(scoreMes).size();
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
	 * 获得某个教师所教的所有学生的月分数
	 */
	@RequestMapping("/getScoreT")
	@ResponseBody
	public ResponseResult getScoreT(ScoreMes scoreMes, HttpSession session) {
		List<ScoreMes> data;
		try {
			scoreMes.setScoreDate("");
			scoreMes.setScoreDatel("");
			scoreMes.setScoreStudentName("");
			User user = (User) session.getAttribute("user");
			scoreMes.setScoreTeacherid(user.getUserId());
			data = scoreService.getPageScoreT(scoreMes);
			// 一共有多少条数据
			int count = scoreService.getAllScoreT(scoreMes).size();
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
	 * 通过起止时间、班级、学号、姓名查询，获得某个教师所教的学生的月分数
	 */
	@RequestMapping("seachScoreT")
	@ResponseBody
	public ResponseResult seachScoreT(ScoreMes scoreMes, String scoreDates, String scoreDatel, HttpSession session) {
		List<ScoreMes> data;
		try {
			scoreMes.setScoreDate(scoreDates);
			scoreMes.setScoreDatel(scoreDatel);
			User user = (User) session.getAttribute("user");
			scoreMes.setScoreTeacherid(user.getUserId());
			data = scoreService.getPageScoreT(scoreMes);
			// 一共有多少条数据
			int count = scoreService.getAllScoreT(scoreMes).size();
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
	 * 获得所有学生的月分数
	 */
	@RequestMapping("/getScoreI")
	@ResponseBody
	public ResponseResult getScoreI(ScoreMes scoreMes, HttpSession session) {
		List<ScoreMes> data;
		try {
			scoreMes.setScoreDate("");
			scoreMes.setScoreDatel("");
			scoreMes.setScoreStudentName("");
			data = scoreService.getPageScoreI(scoreMes);
			// 一共有多少条数据
			int count = scoreService.getAllScoreI(scoreMes).size();
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
	 * 通过起止时间、班级、学号、姓名查询，获得所有学生的月分数
	 */
	@RequestMapping("seachScoreI")
	@ResponseBody
	public ResponseResult seachScoreI(ScoreMes scoreMes, String scoreDates, String scoreDatel, HttpSession session) {
		List<ScoreMes> data;
		try {
			scoreMes.setScoreDate(scoreDates);
			scoreMes.setScoreDatel(scoreDatel);
			data = scoreService.getPageScoreI(scoreMes);
			// 一共有多少条数据
			int count = scoreService.getAllScoreI(scoreMes).size();
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
