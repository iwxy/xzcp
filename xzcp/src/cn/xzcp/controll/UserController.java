package cn.xzcp.controll;

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
	public ResponseResult login(User user) {
		System.out.println(user);
		UserMes data = userService.getUser(user.getUserId());
		if (data == null) {
			return ResponseResult.build(1, "该用户不存在");
		} else if (data.getPassword().equals(user.getPassword())) {
			return ResponseResult.build(0, "登录成功", data);
		} else {
			return ResponseResult.build(1, "密码错误", data);
		}

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

	/*
	 * @Test public void test() { User user = new User(); user.setUserId(16478001);
	 * login(user); }
	 */

}
