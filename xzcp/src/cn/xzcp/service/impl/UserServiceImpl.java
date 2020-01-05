package cn.xzcp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<UserMes> getPageTeacher(int page, int limit) {
		List<UserMes> list;
		int firstIndex = (page - 1) * limit;
		Map<String, Integer> params = new HashMap();
		// 第一个参数是从第几条开始显示
		params.put("firstIndex", firstIndex);
		// 第二个参数是要显示多少条
		params.put("limit", limit);
		list = userMapper.getPageTeacher(params);
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

}
