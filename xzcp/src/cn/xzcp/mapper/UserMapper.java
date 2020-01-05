package cn.xzcp.mapper;

import java.util.List;
import java.util.Map;

import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;

public interface UserMapper {

	/**
	 * 通过学号查询，得到userMes对象
	 */
	UserMes getUser(int userId);

	/**
	 * 修改密码
	 */
	void changePwd(User user);

	/**
	 * 修改用户信息
	 */
	void changeUser(UserMes userMes);

	/**
	 * 获得分页教师的个人信息
	 */
	List<UserMes> getPageTeacher(Map<String, Integer> params);

	/**
	 * 获得所有教师的个人信息
	 */
	List<UserMes> getAllTeacher();

	/**
	 * 删除用户
	 */
	void deleteUser(int userId);

	/**
	 * 添加用户
	 */
	void addUser(UserMes userMes);

}
