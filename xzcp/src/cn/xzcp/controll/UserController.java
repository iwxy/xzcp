package cn.xzcp.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.xzcp.bean.ClassMes;
import cn.xzcp.bean.IdentityMes;
import cn.xzcp.bean.ResponseResult;
import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;
import cn.xzcp.service.ClassService;
import cn.xzcp.service.IdentityService;
import cn.xzcp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ClassService classService;

	/**
	 * 登录 通过学号查询
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResponseResult login(User user, HttpSession session) {
		UserMes data = userService.getUser(user.getUserId());
		if (data == null) {
			return ResponseResult.build(1, "该用户不存在");
		} else if (data.getPassword().equals(user.getPassword())) {
			session.setAttribute("user", data);
			return ResponseResult.build(0, "登录成功", data);
		} else {
			return ResponseResult.build(1, "密码错误", data);
		}

	}

	/**
	 * 退出登录，清除session域
	 */
	@RequestMapping("/exit")
	@ResponseBody
	public ResponseResult exit(HttpSession session) {
		session.invalidate();
		return ResponseResult.build(0, "退出成功");

	}

	/**
	 * 通过学号查询，得到userMes对象
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public ResponseResult getUser(UserMes user) {
		UserMes data = userService.getUser(user.getUserId());
		if (data == null) {
			return ResponseResult.build(1, "该用户不存在");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}
	}

	/**
	 * 修改密码
	 */
	@RequestMapping("/changePwd")
	@ResponseBody
	public ResponseResult changePwd(User user) {

		boolean b = userService.changePwd(user);
		if (b) {
			return ResponseResult.build(0, "修改成功！");
		} else {
			return ResponseResult.build(1, "修改失败！");
		}

	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping("/changeUser")
	@ResponseBody
	public ResponseResult changeUser(UserMes userMes) {

		boolean b = userService.changeUser(userMes);
		if (b) {
			return ResponseResult.build(0, "修改成功！");
		} else {
			return ResponseResult.build(1, "修改失败！");
		}

	}

	/**
	 * 获得所有教师的个人信息
	 */
	@RequestMapping("/getAllTeacher")
	@ResponseBody
	public ResponseResult getAllTeacher(UserMes user) {
		List<UserMes> data;
		data = userService.getPageTeacher(user);
		// 一共有多少条教师数据
		int count = userService.getAllTeacher().size();
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", count, data);
		}

	}

	/**
	 * 批量删除用户，也可单个
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public ResponseResult deleteUser(String idsStr) {
		String idsArray[] = idsStr.split(",");
		boolean b = userService.deleteUser(idsArray);
		if (b) {
			return ResponseResult.build(0, "删除成功！");
		} else {
			return ResponseResult.build(1, "删除失败！");
		}

	}

	/**
	 * 添加教师
	 */
	@RequestMapping("/addTeacher")
	@ResponseBody
	public ResponseResult addTeacher(UserMes userMes) {
		// 这个方法不能通用，因为设定了身份是教师
		userMes.setUserIdentity(2);
		userMes.setUserClassid(0);
		userMes.setUserDormitory("0");
		boolean b = userService.addUser(userMes);
		if (b) {
			return ResponseResult.build(0, "添加成功！");
		} else {
			return ResponseResult.build(1, "添加失败！");
		}

	}

	/**
	 * 获得某个班主任所教的所有学生的个人信息
	 */
	@RequestMapping("/getAllTStudent")
	@ResponseBody
	public ResponseResult getAllTStudent(UserMes user, HttpSession session) {
		List<UserMes> data;
		try {
			User users = (User) session.getAttribute("user");
			user.setUserId(users.getUserId());
			data = userService.getPageTStudent(user);
			// 一共有多少条教师数据
			int count = userService.getAllTStudent(user.getUserId()).size();
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
	 * 获得某个班主任所教的所有学生的个人信息
	 */
	@RequestMapping("/getAllStudent")
	@ResponseBody
	public ResponseResult getAllStudent(UserMes user) {
		List<UserMes> data;
		try {
			data = userService.getPageStudent(user);
			// 一共有多少条教师数据
			int count = userService.getAllStudent().size();
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
	 * 得到所有班委的信息
	 */
	@RequestMapping("/getAllCommittee")
	@ResponseBody
	public ResponseResult getAllCommittee() {
		List<IdentityMes> data;
		data = identityService.getAllIdentity();
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}

	}

	/**
	 * 添加用户
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public ResponseResult addUser(UserMes userMes) {

		boolean b = userService.addUser(userMes);
		if (b) {
			return ResponseResult.build(0, "添加成功！");
		} else {
			return ResponseResult.build(1, "添加失败！");
		}

	}

	/**
	 * 通过Excel批量添加用户
	 */
	@RequestMapping("/excelStudent")
	@ResponseBody
	public ResponseResult excelStudent(HttpServletRequest request) {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		if (file.isEmpty()) {
			return ResponseResult.build(1, "文件不存在！");
		}
		String msg = userService.ajaxUploadExcel(file);
		if (msg.equals("导入成功！")) {
			return ResponseResult.build(0, msg);
		} else {
			return ResponseResult.build(1, msg);
		}

	}

	/**
	 * 教师通过班级、学号、姓名组合查询，只能查询某些班级的学生信息，得到userMes对象
	 */
	@RequestMapping("/seachTUserCIN")
	@ResponseBody
	public ResponseResult seachTUserCIN(UserMes user, HttpSession session) {
		List<UserMes> data;

		try {
			User user1 = (User) session.getAttribute("user");
			user.setUserTeacherid(user1.getUserId());
			data = userService.seachPageTUserCIN(user);
			// 一共有多少条教师数据
			int count = userService.seachTUserCIN(user).size();
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
	 * 通过班级、学号、姓名组合查询，得到userMes对象
	 */
	@RequestMapping("/seachUserCIN")
	@ResponseBody
	public ResponseResult seachUserCIN(UserMes user) {
		List<UserMes> data;

		try {
			data = userService.seachPageUserCIN(user);
			// 一共有多少条教师数据
			int count = userService.seachUserCIN(user).size();
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
	 * 获得某个班委所在班级的所有学生的个人信息
	 */
	@RequestMapping("/getUClassStudent")
	@ResponseBody
	public ResponseResult getUClassStudent(UserMes user, HttpSession session) {
		List<UserMes> data;
		try {
			UserMes users = (UserMes) session.getAttribute("user");
			user.setUserClassid(users.getUserClassid());
			data = userService.getPageUClassStudent(user);
			// 一共有多少条教师数据
			int count = userService.getUClassStudent(user).size();
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
