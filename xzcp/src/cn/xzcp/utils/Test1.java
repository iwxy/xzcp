package cn.xzcp.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.xzcp.bean.UserMes;
import cn.xzcp.controll.UserController;
import cn.xzcp.service.UserService;
import cn.xzcp.service.impl.UserServiceImpl;

public class Test1 {

	@Test
	public void test1() {

		List<UserMes> list = new ArrayList();
		UserService userService = new UserServiceImpl();
		System.out.println(userService);

		UserController userController = new UserController();
		System.out.println(userController);
		System.out.println(userController.getAllCommittee());

		System.out.println(userService.getAllStudent(16478803));

		list = userService.getAllStudent(16478803);
		System.out.println(list.get(0).getUserName());

	}

}
