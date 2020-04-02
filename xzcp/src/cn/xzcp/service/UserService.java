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
	public List<UserMes> getPageTeacher(UserMes user);

	/**
	 * 批量删除用户，也可单个
	 */
	public boolean deleteUser(String[] idsArray);

	/**
	 * 添加用户
	 */
	public boolean addUser(UserMes userMes);

	/**
	 * 获得某个班主任所教的所有学生的信息
	 */
	public List<UserMes> getAllStudent(int userId);

	/**
	 * 获得分页某个班主任所教的学生的个人信息
	 */
	public List<UserMes> getPageStudent(UserMes user);

	/**
	 * 通过班级、学号、姓名组合查询，得到userMes对象
	 */
	public List<UserMes> seachUserCIN(UserMes user);

	/**
	 * 通过班级、学号、姓名组合查询，得到userMes对象
	 */
	public List<UserMes> seachUserCINPage(UserMes user);

	/**
	 * 获得某个班委所在班级的所有学生的个人信息
	 */
	public List<UserMes> getUClassStudent(UserMes user);

	/**
	 * 获得分页某个班委所在班级的所有学生的个人信息
	 */
	public List<UserMes> getPageUClassStudent(UserMes user);

	/**
	 * 获得整个系统的所有学生的个人信息
	 */
	public List<UserMes> getAllStudents();

}
