package cn.xzcp.mapper;

import java.util.List;

import cn.xzcp.bean.ClassMes;

public interface ClassMapper {

	/**
	 * 获得分页班级的信息
	 */
	List<ClassMes> getPageClass(ClassMes classMes);

	/**
	 * 获得所有班级的信息
	 */
	List<ClassMes> getAllClass();

	/**
	 * 删除班级
	 */
	void deleteClass(int classId);

	/**
	 * 添加班级
	 */
	void addClass(ClassMes classMes);

	/**
	 * 通过班级号查询，得到classMes对象
	 */
	ClassMes getClass(int classId);

	/**
	 * 修改班级信息
	 */
	void changeClass(ClassMes classMes);

	/***
	 * 得到某班主任所教的所有班级的信息，得到classMes对象
	 */
	List<ClassMes> getAllTClass(int userId);

}
