package cn.xzcp.mapper;

import java.util.List;

import cn.xzcp.bean.ScoreMes;

public interface ScoreMapper {

	/**
	 * 添加学生的月分数记录
	 */
	void addScore(ScoreMes scoreMes);

	/**
	 * 通过scoreStudentid,scoreDate查询，得到scoreMes对象
	 */
	ScoreMes getScore(ScoreMes scoreMes);

	/**
	 * 通过scoreId修改分数
	 */
	void changeScore(ScoreMes scoreMes);

	/**
	 * 分页获得某个学生的月分数，也可以通过起止时间查询
	 */
	List<ScoreMes> getPageScoreS(ScoreMes scoreMes);

	/**
	 * 获得某个学生所有的月分数，也可以通过起止时间查询
	 */
	List<ScoreMes> getAllScoreS(ScoreMes scoreMes);

	/**
	 * 分页获得某个教师所教的所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	List<ScoreMes> getPageScoreT(ScoreMes scoreMes);

	/**
	 * 获得某个教师所教的所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	List<ScoreMes> getAllScoreT(ScoreMes scoreMes);

	/**
	 * 分页获得所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	List<ScoreMes> getPageScoreI(ScoreMes scoreMes);

	/**
	 * 获得所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	List<ScoreMes> getAllScoreI(ScoreMes scoreMes);

}
