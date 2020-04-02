package cn.xzcp.mapper;

import java.util.List;

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
	List<UserMes> getPageTeacher(UserMes user);

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

	/**
	 * 获得分页某个班主任所教的学生的个人信息
	 */
	List<UserMes> getPageStudent(UserMes user);

	/**
	 * 获得某个班主任所教的所有学生的个人信息
	 */
	List<UserMes> getAllStudent(int userId);

	/**
	 * 通过班级、学号、姓名组合查询，得到userMes对象
	 */
	List<UserMes> seachUserCIN(UserMes user);

	/**
	 * 通过班级、学号、姓名组合查询分页，得到userMes对象
	 */
	List<UserMes> seachUserCINPage(UserMes user);

	/**
	 * 获得分页某个班委所在班级的所有学生的个人信息
	 */
	List<UserMes> getPageUClassStudent(UserMes user);

	/**
	 * 获得某个班委所在班级的所有学生的个人信息
	 */
	List<UserMes> getUClassStudent(UserMes user);

	/**
	 * 获得整个系统的所有学生的个人信息
	 */
	List<UserMes> getAllStudents();

}
