package cn.xzcp.service.impl;

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

}
