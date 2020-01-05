package cn.xzcp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.ClassMes;
import cn.xzcp.mapper.ClassMapper;
import cn.xzcp.service.ClassService;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassMapper classMapper;

	/**
	 * 通过班级号查询，得到classMes对象
	 */
	@Override
	public ClassMes getClass(int classId) {
		// TODO Auto-generated method stub
		ClassMes classes = classMapper.getClass(classId);
		return classes;
	}

	/**
	 * 获得分页班级的信息
	 */
	@Override
	public List<ClassMes> getPageClass(int page, int limit) {
		List<ClassMes> list;
		int firstIndex = (page - 1) * limit;
		Map<String, Integer> params = new HashMap();
		// 第一个参数是从第几条开始显示
		params.put("firstIndex", firstIndex);
		// 第二个参数是要显示多少条
		params.put("limit", limit);
		list = classMapper.getPageClass(params);
		return list;
	}

	/**
	 * 获得所有班级的信息
	 */
	@Override
	public List<ClassMes> getAllClass() {
		List<ClassMes> list;
		list = classMapper.getAllClass();
		return list;
	}

	/**
	 * 批量删除班级
	 */
	@Override
	public boolean deleteClass(String[] idsArray) {
		for (int i = 0; i < idsArray.length; i++) {
			int classId = Integer.valueOf(idsArray[i]);
			try {
				classMapper.deleteClass(classId);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 添加班级
	 */
	@Override
	public boolean addClass(ClassMes classMes) {
		try {
			classMapper.addClass(classMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 修改班级信息
	 */
	@Override
	public boolean changeClass(ClassMes classMes) {
		try {
			classMapper.changeClass(classMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
