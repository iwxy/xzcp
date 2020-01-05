package cn.xzcp.service;

import java.util.List;

import cn.xzcp.bean.ClassMes;

public interface ClassService {

	/**
	 * 通过班级号查询，得到classMes对象
	 */
	ClassMes getClass(int classId);

	/**
	 * 获得分页班级的信息
	 */
	List<ClassMes> getPageClass(int page, int limit);

	/**
	 * 获得所有班级的信息
	 */
	List<ClassMes> getAllClass();

	/**
	 * 批量删除班级，也可单个
	 */
	boolean deleteClass(String[] idsArray);

	/**
	 * 添加班级
	 */
	boolean addClass(ClassMes classMes);

	/**
	 * 修改班级信息
	 */
	public boolean changeClass(ClassMes classMes);

}
