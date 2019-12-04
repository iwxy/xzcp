package cn.xzcp.mapper;

import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;

public interface UserMapper {

	/**
	 * 通过学号查询，得到userMes对象
	 */
	public UserMes getUser(int userId);

	/**
	 * 修改密码
	 */
	public void changePwd(User user);

	/**
	 * 修改用户信息
	 */
	public void changeUser(UserMes userMes);

}
