package cn.xzcp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.ItemMes;
import cn.xzcp.bean.RecordMes;
import cn.xzcp.bean.ScoreMes;
import cn.xzcp.mapper.RecordMapper;
import cn.xzcp.service.ItemService;
import cn.xzcp.service.RecordService;
import cn.xzcp.service.ScoreService;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordMapper recordMapper;

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private ItemService itemService;

	/**
	 * 添加记录
	 */
	@Transactional
	@Override
	public boolean addRecord(RecordMes recordMes) throws Exception {
		ItemMes itemMes = itemService.getItem(recordMes.getRecordItemid());
		ScoreMes scoreMes = new ScoreMes();
		scoreMes.setScoreStudentid(recordMes.getRecordStudentid());
		scoreMes.setScoreScore(itemMes.getItemScore() * recordMes.getRecordTimes());
		scoreMes.setScoreDate(recordMes.getRecordDate());
		scoreService.changeScoreA(scoreMes);

		recordMapper.addRecord(recordMes);
		return true;
	}

	/**
	 * 分页获得某班委所记录的所有考评记录，也可以通过学号、时间组合查询
	 */
	@Override
	public List<RecordMes> getPageCommitteeRecord(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getPageCommitteeRecord(recordMes);
		return list;
	}

	/**
	 * 获得某班委所记录的所有考评记录，也可以通过学号、时间组合查询
	 */
	@Override
	public List<RecordMes> getAllCommitteeRecord(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getAllCommitteeRecord(recordMes);
		return list;
	}

	/**
	 * 批量删除记录，也可单个
	 */
	@Transactional
	@Override
	public boolean deleteRecord(String[] idsArray) throws Exception {
		for (int i = 0; i < idsArray.length; i++) {
			int recordId = Integer.valueOf(idsArray[i]);
			RecordMes recordMes = recordMapper.getRecordById(recordId);
			ItemMes itemMes = itemService.getItem(recordMes.getRecordItemid());
			ScoreMes scoreMes = new ScoreMes();
			scoreMes.setScoreStudentid(recordMes.getRecordStudentid());
			scoreMes.setScoreScore(itemMes.getItemScore() * recordMes.getRecordTimes());
			scoreMes.setScoreDate(recordMes.getRecordDate());
			scoreService.changeScoreD(scoreMes);

			recordMapper.deleteRecord(recordId);
		}
		return true;
	}

	/**
	 * 通过recordId查询，得到recordMes对象
	 */
	@Override
	public RecordMes getRecordById(int recordId) {
		RecordMes recordMes = recordMapper.getRecordById(recordId);
		return recordMes;
	}

	/**
	 * 修改考评记录的信息
	 */
	@Transactional
	@Override
	public boolean changeRecord(RecordMes recordMes) throws Exception {
		ScoreMes scoreMes = new ScoreMes();
		// 修改考评记录时，先获取旧的记录，将旧记录的分值存下来
		RecordMes recordMesOld = recordMapper.getRecordById(recordMes.getRecordId());
		ItemMes itemMesOld = itemService.getItem(recordMesOld.getRecordItemid());
		scoreMes.setOldScore(itemMesOld.getItemScore());
		// 获取新记录的分值
		ItemMes itemMes = itemService.getItem(recordMes.getRecordItemid());

		scoreMes.setScoreStudentid(recordMes.getRecordStudentid());
		scoreMes.setScoreScore(itemMes.getItemScore() * recordMes.getRecordTimes());
		scoreMes.setScoreDate(recordMes.getRecordDate());
		scoreService.changeScoreC(scoreMes);

		recordMapper.changeRecord(recordMes);

		return true;
	}

	/**
	 * 分页获得某个学生的记录，也可以通过起止时间查询
	 */
	@Override
	public List<RecordMes> getPageRecordS(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getPageRecordS(recordMes);
		return list;
	}

	/**
	 * 获得某个学生所有的记录，也可以通过起止时间查询
	 */
	@Override
	public List<RecordMes> getAllRecordS(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getAllRecordS(recordMes);
		return list;
	}

	/**
	 * 分页获得所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	@Override
	public List<RecordMes> getPageRecordI(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getPageRecordI(recordMes);
		return list;
	}

	/**
	 * 获得所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	@Override
	public List<RecordMes> getAllRecordI(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getAllRecordI(recordMes);
		return list;
	}

	/**
	 * 分页获得某班主任所教的所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	@Override
	public List<RecordMes> getPageRecordT(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getPageRecordT(recordMes);
		return list;
	}

	/**
	 * 获得某班主任所教的所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	@Override
	public List<RecordMes> getAllRecordT(RecordMes recordMes) {
		List<RecordMes> list;
		list = recordMapper.getAllRecordT(recordMes);
		return list;
	}

}
