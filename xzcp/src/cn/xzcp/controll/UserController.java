package cn.xzcp.controll;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.ResponseResult;
import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;
import cn.xzcp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

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
	public ResponseResult getAllTeacher(int page, int limit) {
		List<UserMes> data;
		data = userService.getPageTeacher(page, limit);
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

}
