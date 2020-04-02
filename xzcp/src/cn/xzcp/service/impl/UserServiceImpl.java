package cn.xzcp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;
import cn.xzcp.mapper.UserMapper;
import cn.xzcp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 通过学号查询，得到userMes对象
	 */
	@Override
	public UserMes getUser(int userId) {
		// TODO Auto-generated method stub
		UserMes user = userMapper.getUser(userId);
		return user;
	}

	/**
	 * 修改密码
	 */
	@Override
	public boolean changePwd(User user) {
		try {
			userMapper.changePwd(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 修改用户信息
	 */
	@Override
	public boolean changeUser(UserMes userMes) {
		try {
			userMapper.changeUser(userMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获得分页教师的个人信息
	 */
	@Override
	public List<UserMes> getPageTeacher(UserMes user) {
		List<UserMes> list;
		list = userMapper.getPageTeacher(user);
		return list;
	}

	/**
	 * 获得所有教师的信息
	 */
	@Override
	public List<UserMes> getAllTeacher() {
		List<UserMes> list;
		list = userMapper.getAllTeacher();
		return list;
	}

	/**
	 * 批量删除用户，也可单个
	 */
	@Override
	public boolean deleteUser(String[] idsArray) {
		for (int i = 0; i < idsArray.length; i++) {
			int userId = Integer.valueOf(idsArray[i]);
			try {
				userMapper.deleteUser(userId);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 添加用户
	 */
	@Override
	public boolean addUser(UserMes userMes) {
		try {
			userMapper.addUser(userMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获得分页某个班主任所教的学生的个人信息
	 */
	@Override
	public List<UserMes> getPageStudent(UserMes user) {
		List<UserMes> list;
		list = userMapper.getPageStudent(user);
		return list;
	}

	/**
	 * 获得某个班主任所教的所有学生的信息
	 */
	@Override
	public List<UserMes> getAllStudent(int userId) {
		List<UserMes> list;
		list = userMapper.getAllStudent(userId);
		return list;
	}

	/**
	 * 通过班级、学号、姓名组合查询，得到userMes对象
	 */
	@Override
	public List<UserMes> seachUserCIN(UserMes user) {
		List<UserMes> list;
		list = userMapper.seachUserCIN(user);
		return list;
	}

	/**
	 * 通过班级、学号、姓名组合查询分页，得到userMes对象
	 */
	@Override
	public List<UserMes> seachUserCINPage(UserMes user) {
		List<UserMes> list;
		list = userMapper.seachUserCINPage(user);
		return list;

	}

	/**
	 * 获得分页某个班委所在班级的所有学生的个人信息
	 */
	@Override
	public List<UserMes> getPageUClassStudent(UserMes user) {
		List<UserMes> list;
		list = userMapper.getPageUClassStudent(user);
		return list;
	}

	/**
	 * 获得某个班委所在班级的所有学生的个人信息
	 */
	@Override
	public List<UserMes> getUClassStudent(UserMes user) {
		List<UserMes> list;
		list = userMapper.getUClassStudent(user);
		return list;
	}

	/**
	 * 获得整个系统的所有学生的个人信息
	 */
	@Override
	public List<UserMes> getAllStudents() {
		List<UserMes> list;
		list = userMapper.getAllStudents();
		return list;
	}

}
