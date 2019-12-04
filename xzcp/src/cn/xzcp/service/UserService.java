package cn.xzcp.service;

import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;

public interface UserService {

	/**
	 * 通过学号查询，得到userMes对象
	 */
	public UserMes getUser(int userId);

	/**
	 * 修改密码
	 */
	public boolean changePwd(User user);

	/**
	 * 修改用户信息
	 */
	public boolean changeUser(UserMes userMes);

}
