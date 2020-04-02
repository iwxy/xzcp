package cn.xzcp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.ScoreMes;
import cn.xzcp.bean.TermscoreMes;
import cn.xzcp.mapper.TermscoreMapper;
import cn.xzcp.service.TermscoreService;

@Service
@Transactional
public class TermscoreServiceImpl implements TermscoreService {

	@Autowired
	private TermscoreMapper termscoreMapper;

	/**
	 * 添加学生的学期分数记录
	 */
	@Override
	public boolean addTermscore(TermscoreMes termscoreMes) {
		try {
			termscoreMapper.addTermscore(termscoreMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 添加学生记录，并修改学生的学期分数记录
	 */
	@Override
	public boolean changeTermscoreA(ScoreMes scoreMes) {

		TermscoreMes termscoreMes = new TermscoreMes();
		try {
			// 将日期改为学期，方便在数据库中进行查询（数据库只有学期）
			String date = scoreMes.getScoreDate();
			String a[] = date.split("-");
			int year = Integer.valueOf(a[0]);
			int month = Integer.valueOf(a[1]);
			if (month < 8 && month >= 2) {
				int year1 = year - 1;
				date = year1 + "-" + year + "第二学期";
			} else {
				int year1 = year + 1;
				date = year + "-" + year + "第一学期";
			}
			termscoreMes.setTermscoreDate(date);
			termscoreMes.setTermscoreStudentid(scoreMes.getScoreStudentid());

			// 获取某学生某个月的分数
			TermscoreMes termscoreMesOld = termscoreMapper.getTermscore(termscoreMes);
			// 按照记录的分值，改变学生某个学期的分数
			// 因为是新添加的记录，所以分数是加上去，本来5分，因记录+1分或-1分
			double score = termscoreMesOld.getTermscoreScore() + scoreMes.getScoreScore();
			// 输入变更后的分数
			termscoreMesOld.setTermscoreScore(score);

			termscoreMapper.changeTermscore(termscoreMesOld);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 删除学生记录，并修改学生的学期分数记录
	 */
	@Override
	public boolean changeTermscoreD(ScoreMes scoreMes) {
		TermscoreMes termscoreMes = new TermscoreMes();
		try {
			// 将日期改为学期，方便在数据库中进行查询（数据库只有学期）
			String date = scoreMes.getScoreDate();
			String a[] = date.split("-");
			int year = Integer.valueOf(a[0]);
			int month = Integer.valueOf(a[1]);
			if (month < 8 && month >= 2) {
				int year1 = year - 1;
				date = year1 + "-" + year + "第二学期";
			} else {
				int year1 = year + 1;
				date = year + "-" + year + "第一学期";
			}
			termscoreMes.setTermscoreDate(date);
			termscoreMes.setTermscoreStudentid(scoreMes.getScoreStudentid());

			// 获取某学生某个月的分数
			TermscoreMes termscoreMesOld = termscoreMapper.getTermscore(termscoreMes);
			// 按照记录的分值，改变学生某个学期的分数
			// 因为是删除记录，所以分数是减掉，本来5分，因记录-1分或+1分
			double score = termscoreMesOld.getTermscoreScore() - scoreMes.getScoreScore();
			// 输入变更后的分数
			termscoreMesOld.setTermscoreScore(score);

			termscoreMapper.changeTermscore(termscoreMesOld);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 修改学生记录，并修改学生的学期分数记录
	 */
	@Override
	public boolean changeTermscoreC(ScoreMes scoreMes) {
		TermscoreMes termscoreMes = new TermscoreMes();
		try {
			// 将日期改为学期，方便在数据库中进行查询（数据库只有学期）
			String date = scoreMes.getScoreDate();
			String a[] = date.split("-");
			int year = Integer.valueOf(a[0]);
			int month = Integer.valueOf(a[1]);
			if (month < 8 && month >= 2) {
				int year1 = year - 1;
				date = year1 + "-" + year + "第二学期";
			} else {
				int year1 = year + 1;
				date = year + "-" + year + "第一学期";
			}
			termscoreMes.setTermscoreDate(date);
			termscoreMes.setTermscoreStudentid(scoreMes.getScoreStudentid());

			// 获取某学生某个月的分数
			TermscoreMes termscoreMesOld = termscoreMapper.getTermscore(termscoreMes);
			// 按照记录的分值，改变学生某个学期的分数
			// 因为是修改记录，所以先减掉旧记录误加的分值，再加上新记录的分值
			double score = termscoreMesOld.getTermscoreScore() - scoreMes.getOldScore();
			score = score + scoreMes.getScoreScore();
			// 输入变更后的分数
			termscoreMesOld.setTermscoreScore(score);

			termscoreMapper.changeTermscore(termscoreMesOld);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 分页获得某个学生的学期分数
	 */
	@Override
	public List<TermscoreMes> getPageTermscoreS(TermscoreMes termscoreMes) {
		List<TermscoreMes> list;
		list = termscoreMapper.getPageTermscoreS(termscoreMes);
		return list;
	}

	/**
	 * 获得某个学生所有的学期分数
	 */
	@Override
	public List<TermscoreMes> getAllTermscoreS(TermscoreMes termscoreMes) {
		List<TermscoreMes> list;
		list = termscoreMapper.getAllTermscoreS(termscoreMes);
		return list;
	}

	/**
	 * 获得termscore表中所有学期的信息
	 */
	@Override
	public List<TermscoreMes> getAllDate() {
		List<TermscoreMes> list;
		list = termscoreMapper.getAllDate();
		return list;
	}

	/**
	 * 分页获得某个教师所教的所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	@Override
	public List<TermscoreMes> getPageTermscoreT(TermscoreMes termscoreMes) {
		List<TermscoreMes> list;
		list = termscoreMapper.getPageTermscoreT(termscoreMes);
		return list;
	}

	/**
	 * 获得某个教师所教的所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	@Override
	public List<TermscoreMes> getAllTermscoreT(TermscoreMes termscoreMes) {
		List<TermscoreMes> list;
		list = termscoreMapper.getAllTermscoreT(termscoreMes);
		return list;
	}

	/**
	 * 分页获得所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	@Override
	public List<TermscoreMes> getPageTermscoreI(TermscoreMes termscoreMes) {
		List<TermscoreMes> list;
		list = termscoreMapper.getPageTermscoreI(termscoreMes);
		return list;
	}

	/**
	 * 获得所有学生的学期分数，也可以通过学期、班级、学号、姓名查询
	 */
	@Override
	public List<TermscoreMes> getAllTermscoreI(TermscoreMes termscoreMes) {
		List<TermscoreMes> list;
		list = termscoreMapper.getAllTermscoreI(termscoreMes);
		return list;
	}

}
