package cn.xzcp.service;

import java.util.List;

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

	/**
	 * 获得所有教师的信息
	 */
	public List<UserMes> getAllTeacher();

	/**
	 * 获得分页教师的个人信息
	 */
	public List<UserMes> getPageTeacher(int page, int limit);

	/**
	 * 批量删除用户，也可单个
	 */
	public boolean deleteUser(String[] idsArray);

	/**
	 * 添加用户
	 */
	public boolean addUser(UserMes userMes);

}
