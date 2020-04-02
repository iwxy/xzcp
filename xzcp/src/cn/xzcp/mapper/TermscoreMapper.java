package cn.xzcp.mapper;

import java.util.List;

import cn.xzcp.bean.TermscoreMes;

public interface TermscoreMapper {

	/**
	 * 添加学生的学期分数记录
	 */
	void addTermscore(TermscoreMes termscoreMes);

	/**
	 * 通过termscoreStudentid,termscoreDate查询，得到termscoreMes对象
	 */
	TermscoreMes getTermscore(TermscoreMes termscoreMes);

	/**
	 * 通过termscoreId修改分数
	 */
	void changeTermscore(TermscoreMes termscoreMes);

	/**
	 * 分页获得某个学生的学期分数
	 */
	List<TermscoreMes> getPageTermscoreS(TermscoreMes termscoreMes);

	/**
	 * 获得某个学生所有的学期分数
	 */
	List<TermscoreMes> getAllTermscoreS(TermscoreMes termscoreMes);

	/**
	 * 获得termscore表中所有学期的信息
	 */
	List<TermscoreMes> getAllDate();

	/**
	 * 分页获得某个教师所教的所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	List<TermscoreMes> getPageTermscoreT(TermscoreMes termscoreMes);

	/**
	 * 获得某个教师所教的所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	List<TermscoreMes> getAllTermscoreT(TermscoreMes termscoreMes);

	/**
	 * 分页获得所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	List<TermscoreMes> getPageTermscoreI(TermscoreMes termscoreMes);

	/**
	 * 获得所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	List<TermscoreMes> getAllTermscoreI(TermscoreMes termscoreMes);

}
