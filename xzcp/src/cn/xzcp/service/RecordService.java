package cn.xzcp.service;

import java.util.List;

import cn.xzcp.bean.RecordMes;

public interface RecordService {

	/**
	 * 添加记录
	 */
	public boolean addRecord(RecordMes recordMes) throws Exception;

	/**
	 * 分页获得某班委所记录的所有考评记录
	 */
	public List<RecordMes> getPageCommitteeRecord(RecordMes recordMes);

	/**
	 * 获得某班委所记录的所有考评记录
	 */
	public List<RecordMes> getAllCommitteeRecord(RecordMes recordMes);

	/**
	 * 批量删除记录，也可单个
	 */
	public boolean deleteRecord(String[] idsArray) throws Exception;

	/**
	 * 通过recordId查询，得到recordMes对象
	 */
	public RecordMes getRecordById(int recordId);

	/**
	 * 修改考评记录的信息
	 */
	public boolean changeRecord(RecordMes recordMes) throws Exception;

	/**
	 * 分页获得某个学生的记录，也可以通过起止时间查询
	 */
	public List<RecordMes> getPageRecordS(RecordMes recordMes);

	/**
	 * 获得某个学生所有的记录，也可以通过起止时间查询
	 */
	public List<RecordMes> getAllRecordS(RecordMes recordMes);

	/**
	 * 分页获得所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	public List<RecordMes> getPageRecordI(RecordMes recordMes);

	/**
	 * 获得所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	public List<RecordMes> getAllRecordI(RecordMes recordMes);

	/**
	 * 分页获得某班主任所教的所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	public List<RecordMes> getPageRecordT(RecordMes recordMes);

	/**
	 * 获得某班主任所教的所有学生的所有记录，也可以通过班级，起止时间，学号，姓名，考评项查询
	 */
	public List<RecordMes> getAllRecordT(RecordMes recordMes);

}
