package cn.xzcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.User;
import cn.xzcp.mapper.UserMapper;
import cn.xzcp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(int userId) {
		// TODO Auto-generated method stub
		User user = userMapper.login(userId);
		return user;
	}

}
