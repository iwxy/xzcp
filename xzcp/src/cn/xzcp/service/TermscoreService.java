package cn.xzcp.service;

import java.util.List;

import cn.xzcp.bean.ScoreMes;
import cn.xzcp.bean.TermscoreMes;

public interface TermscoreService {

	/**
	 * 添加学生的学期分数记录
	 */
	public boolean addTermscore(TermscoreMes termscoreMes);

	/**
	 * 添加学生记录，并修改学生的学期分数记录
	 */
	public boolean changeTermscoreA(ScoreMes scoreMes);

	/**
	 * 删除学生记录，并修改学生的学期分数记录
	 */
	public boolean changeTermscoreD(ScoreMes scoreMes);

	/**
	 * 修改学生记录，并修改学生的学期分数记录
	 */
	public boolean changeTermscoreC(ScoreMes scoreMes);

	/**
	 * 分页获得某个学生的学期分数
	 */
	public List<TermscoreMes> getPageTermscoreS(TermscoreMes termscoreMes);

	/**
	 * 获得某个学生所有的学期分数
	 */
	public List<TermscoreMes> getAllTermscoreS(TermscoreMes termscoreMes);

	/**
	 * 获得termscore表中所有学期的信息
	 */
	public List<TermscoreMes> getAllDate();

	/**
	 * 分页获得某个教师所教的所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	public List<TermscoreMes> getPageTermscoreT(TermscoreMes termscoreMes);

	/**
	 * 获得某个教师所教的所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	public List<TermscoreMes> getAllTermscoreT(TermscoreMes termscoreMes);

	/**
	 * 分页获得所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	public List<TermscoreMes> getPageTermscoreI(TermscoreMes termscoreMes);

	/**
	 * 获得所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	public List<TermscoreMes> getAllTermscoreI(TermscoreMes termscoreMes);

}
