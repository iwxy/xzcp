package cn.xzcp.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.ResponseResult;
import cn.xzcp.bean.User;
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
	public ResponseResult login(int userId) {
		User data = userService.login(userId);
		return ResponseResult.ok(data);

	}

}
