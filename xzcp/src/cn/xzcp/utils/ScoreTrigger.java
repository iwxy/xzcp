package cn.xzcp.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Component;

import cn.xzcp.bean.ScoreMes;
import cn.xzcp.bean.TermscoreMes;
import cn.xzcp.bean.UserMes;
import cn.xzcp.service.ScoreService;
import cn.xzcp.service.TermscoreService;
import cn.xzcp.service.UserService;

@Component
public class ScoreTrigger {
	// 分数的触发器，每月1号的00：01触发，在分数表中为每个同学添加该月的一条记录，设置该月的基础分

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "scoreService")
	ScoreService scoreService;

	@Resource(name = "termscoreService")
	TermscoreService termscoreService;

	@Test
	public void perform() {

		// 获取系统的当前时间
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);

		// 查询所有的学生，得到他们的id，便于设置基础分
		List<UserMes> list = new ArrayList();
		list = userService.getAllStudents();

		// 在score表中插入一批数据
		String scoreDate = year + "-" + month + "-" + date;
		ScoreMes scoreMes = new ScoreMes();
		for (int i = 0; i < list.size(); i++) {
			scoreMes.setScoreStudentid(list.get(i).getUserId());
			// 每月的基础分为0分
			scoreMes.setScoreScore(0);
			scoreMes.setScoreDate(scoreDate);
			scoreService.addScore(scoreMes);

		}

		// 在termscore表中插入一批数据
		TermscoreMes termscoreMes = new TermscoreMes();
		if (month == 2) {
			// 2020年2月1日，即将开始的学期是2019-2020第二学期
			int year1 = year - 1;
			String term = year1 + "-" + year + "第二学期";
			for (int i = 0; i < list.size(); i++) {
				termscoreMes.setTermscoreStudentid(list.get(i).getUserId());
				// 学期的基础分为60分
				termscoreMes.setTermscoreScore(60);
				termscoreMes.setTermscoreDate(term);
				termscoreService.addTermscore(termscoreMes);

			}

		}

		if (month == 8) {
			// 2020年8月1日，即将开始的学期是2020-2021第一学期
			int year1 = year + 1;
			String term = year + "-" + year1 + "第一学期";
			for (int i = 0; i < list.size(); i++) {
				termscoreMes.setTermscoreStudentid(list.get(i).getUserId());
				// 学期的基础分为60分
				termscoreMes.setTermscoreScore(60);
				termscoreMes.setTermscoreDate(term);
				termscoreService.addTermscore(termscoreMes);

			}

		}

	}

}