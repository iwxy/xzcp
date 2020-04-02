package cn.xzcp.service;

import java.util.List;

import cn.xzcp.bean.ScoreMes;

public interface ScoreService {

	/**
	 * 添加学生的月分数记录
	 */
	public boolean addScore(ScoreMes scoreMes);

	/**
	 * 添加学生记录，并修改学生的月分数记录
	 */
	public boolean changeScoreA(ScoreMes scoreMes) throws Exception;

	/**
	 * 删除学生记录，并修改学生的月分数记录
	 */
	public boolean changeScoreD(ScoreMes scoreMes) throws Exception;

	/**
	 * 修改学生记录，并修改学生的月分数记录
	 */
	public boolean changeScoreC(ScoreMes scoreMes) throws Exception;

	/**
	 * 分页获得某个学生的月分数，也可以通过起止时间查询
	 */
	public List<ScoreMes> getPageScoreS(ScoreMes scoreMes);

	/**
	 * 获得某个学生所有的月分数，也可以通过起止时间查询
	 */
	public List<ScoreMes> getAllScoreS(ScoreMes scoreMes);

	/**
	 * 分页获得某个教师所教的所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	public List<ScoreMes> getPageScoreT(ScoreMes scoreMes);

	/**
	 * 获得某个教师所教的所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	public List<ScoreMes> getAllScoreT(ScoreMes scoreMes);

	/**
	 * 分页获得所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	public List<ScoreMes> getPageScoreI(ScoreMes scoreMes);

	/**
	 * 获得所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	public List<ScoreMes> getAllScoreI(ScoreMes scoreMes);

}
