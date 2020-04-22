package cn.xzcp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.xzcp.bean.User;
import cn.xzcp.bean.UserMes;
import cn.xzcp.mapper.UserMapper;
import cn.xzcp.service.UserService;
import cn.xzcp.utils.ExcelUtil;

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
	public List<UserMes> getPageTStudent(UserMes user) {
		List<UserMes> list;
		list = userMapper.getPageTStudent(user);
		return list;
	}

	/**
	 * 获得某个班主任所教的所有学生的信息
	 */
	@Override
	public List<UserMes> getAllTStudent(int userId) {
		List<UserMes> list;
		list = userMapper.getAllTStudent(userId);
		return list;
	}

	/**
	 * 获得分页所有学生的个人信息
	 */
	@Override
	public List<UserMes> getPageStudent(UserMes user) {
		List<UserMes> list;
		list = userMapper.getPageStudent(user);
		return list;
	}

	/**
	 * 获得所有学生的信息
	 */
	@Override
	public List<UserMes> getAllStudent() {
		List<UserMes> list;
		list = userMapper.getAllStudent();
		return list;
	}

	/**
	 * 教师通过班级、学号、姓名组合查询，只能查询某些班级的学生信息，得到userMes对象
	 */
	@Override
	public List<UserMes> seachTUserCIN(UserMes user) {
		List<UserMes> list;
		list = userMapper.seachTUserCIN(user);
		return list;
	}

	/**
	 * 教师通过班级、学号、姓名组合查询分页，只能查询某些班级的学生信息，得到userMes对象
	 */
	@Override
	public List<UserMes> seachPageTUserCIN(UserMes user) {
		List<UserMes> list;
		list = userMapper.seachPageTUserCIN(user);
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
	public List<UserMes> seachPageUserCIN(UserMes user) {
		List<UserMes> list;
		list = userMapper.seachPageUserCIN(user);
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

	/**
	 * 通过Excel批量添加用户
	 */
	@Override
	public String ajaxUploadExcel(MultipartFile file) {

		// 获取IO流
		InputStream in = null;
		try {
			in = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return "系统导入表格出错！";
		}

		// 获取IO流的数据，[[1647, 顶顶顶, 1647, 男, 13-203], [174, 烦烦烦, ddd, 男, 12-201]]
		List<List<Object>> listob = null;
		try {
			listob = new ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
			return "系统获取表格内容出错！";
		}

		// 对表格内容进行初步检验，避免同一张表中，有些人注册了有些人没有，不能重新导入表格
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			UserMes j = null;

			// 对表格内容是否缺少，格式是否正确进行检查
			try {
				Integer.valueOf(String.valueOf(lo.get(0)));
				String.valueOf(lo.get(1));
				Integer.valueOf(String.valueOf(lo.get(2)));
				String.valueOf(lo.get(3));
				String.valueOf(lo.get(4));
			} catch (Exception e) {
				return "表格内容有误，请重新导入表格！";
			}

			// 该处检查Excel中的学号在数据库中是否已存在，如果已存在，直接return
			j = userMapper.getUser(Integer.valueOf(String.valueOf(lo.get(0))));
			if (j != null) {
				return "学号" + Integer.valueOf(String.valueOf(lo.get(0))) + "已存在";
			}
		}

		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			UserMes userMes = new UserMes();

			userMes.setUserId(Integer.valueOf(String.valueOf(lo.get(0))));
			userMes.setUserName(String.valueOf(lo.get(1)));
			userMes.setUserClassid(Integer.valueOf(String.valueOf(lo.get(2))));
			userMes.setUserSex(String.valueOf(lo.get(3)));
			userMes.setUserDormitory(String.valueOf(lo.get(4)));
			userMes.setPassword("123456");
			userMes.setUserIdentity(3);

			userMapper.addUser(userMes);
		}

		return "导入成功！";
	}

}
