package cn.xzcp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.ScoreMes;
import cn.xzcp.mapper.ScoreMapper;
import cn.xzcp.service.ScoreService;
import cn.xzcp.service.TermscoreService;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;

	@Autowired
	private TermscoreService termscoreService;

	/**
	 * 添加学生的月分数记录
	 */
	@Override
	public boolean addScore(ScoreMes scoreMes) {
		try {
			scoreMapper.addScore(scoreMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 添加学生记录，并修改学生的月分数记录
	 */
	@Transactional
	@Override
	public boolean changeScoreA(ScoreMes scoreMes) throws Exception {
		// 将日期改为1日，方便在数据库中进行查询（数据库只有1日）
		String date = scoreMes.getScoreDate();
		String a[] = date.split("-");
		date = a[0] + "-" + a[1] + "-" + "01";
		scoreMes.setScoreDate(date);

		// 获取某学生某个月的分数
		ScoreMes scoreMesOld = scoreMapper.getScore(scoreMes);
		// 按照记录的分值，改变学生某个月的分数
		// 因为是新添加的记录，所以分数是加上去，本来5分，因记录+1分或-1分
		double score = scoreMesOld.getScoreScore() + scoreMes.getScoreScore();
		// 输入变更后的分数
		scoreMesOld.setScoreScore(score);

		termscoreService.changeTermscoreA(scoreMes);
		scoreMapper.changeScore(scoreMesOld);

		return true;
	}

	/**
	 * 删除学生记录，并修改学生的月分数记录
	 */
	@Transactional
	@Override
	public boolean changeScoreD(ScoreMes scoreMes) throws Exception {
		// 将日期改为1日，方便在数据库中进行查询（数据库只有1日）
		String date = scoreMes.getScoreDate();
		String a[] = date.split("-");
		date = a[0] + "-" + a[1] + "-" + "01";
		scoreMes.setScoreDate(date);

		// 获取某学生某个月的分数
		ScoreMes scoreMesOld = scoreMapper.getScore(scoreMes);
		// 按照记录的分值，改变学生某个月的分数
		// 因为是删除记录，所以分数是减掉，本来5分，因记录-1分或+1分
		double score = scoreMesOld.getScoreScore() - scoreMes.getScoreScore();
		// 输入变更后的分数
		scoreMesOld.setScoreScore(score);

		termscoreService.changeTermscoreD(scoreMes);
		scoreMapper.changeScore(scoreMesOld);

		return true;
	}

	/**
	 * 修改学生记录，并修改学生的月分数记录
	 */
	@Transactional
	@Override
	public boolean changeScoreC(ScoreMes scoreMes) throws Exception {
		// 将日期改为1日，方便在数据库中进行查询（数据库只有1日）
		String date = scoreMes.getScoreDate();
		String a[] = date.split("-");
		date = a[0] + "-" + a[1] + "-" + "01";
		scoreMes.setScoreDate(date);

		// 获取某学生某个月的分数
		ScoreMes scoreMesOld = scoreMapper.getScore(scoreMes);
		// 按照记录的分值，改变学生某个月的分数
		// 因为是修改记录，所以先减掉旧记录误加的分值，再加上新记录的分值
		double score = scoreMesOld.getScoreScore() - scoreMes.getOldScore();
		score = score + scoreMes.getScoreScore();
		// 输入变更后的分数
		scoreMesOld.setScoreScore(score);

		termscoreService.changeTermscoreC(scoreMes);
		scoreMapper.changeScore(scoreMesOld);

		return true;
	}

	/**
	 * 分页获得某个学生的月分数，也可以通过起止时间查询
	 */
	@Override
	public List<ScoreMes> getPageScoreS(ScoreMes scoreMes) {
		List<ScoreMes> list;
		list = scoreMapper.getPageScoreS(scoreMes);
		return list;
	}

	/**
	 * 获得某个学生所有的月分数，也可以通过起止时间查询
	 */
	@Override
	public List<ScoreMes> getAllScoreS(ScoreMes scoreMes) {
		List<ScoreMes> list;
		list = scoreMapper.getAllScoreS(scoreMes);
		return list;
	}

	/**
	 * 分页获得某个教师所教的所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	@Override
	public List<ScoreMes> getPageScoreT(ScoreMes scoreMes) {
		List<ScoreMes> list;
		list = scoreMapper.getPageScoreT(scoreMes);
		return list;
	}

	/**
	 * 获得某个教师所教的所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	@Override
	public List<ScoreMes> getAllScoreT(ScoreMes scoreMes) {
		List<ScoreMes> list;
		list = scoreMapper.getAllScoreT(scoreMes);
		return list;
	}

	/**
	 * 分页获得所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	@Override
	public List<ScoreMes> getPageScoreI(ScoreMes scoreMes) {
		List<ScoreMes> list;
		list = scoreMapper.getPageScoreI(scoreMes);
		return list;
	}

	/**
	 * 获得所有学生的月分数，也可以通过起止时间、班级、学号、姓名查询
	 */
	@Override
	public List<ScoreMes> getAllScoreI(ScoreMes scoreMes) {
		List<ScoreMes> list;
		list = scoreMapper.getAllScoreI(scoreMes);
		return list;
	}

}
