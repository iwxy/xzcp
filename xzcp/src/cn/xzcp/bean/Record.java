package cn.xzcp.bean;

import java.util.Date;

public class Record {

	private int recordId;
	private int recordCommitteeid;
	private int recordStudentid;
	private int recordItemid;
	private int recordTimes;
	private String recordDiscribe;
	private Date recordDate;
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", recordCommitteeid=" + recordCommitteeid + ", recordStudentid="
				+ recordStudentid + ", recordItemid=" + recordItemid + ", recordTimes=" + recordTimes
				+ ", recordDiscribe=" + recordDiscribe + ", recordDate=" + recordDate + "]";
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getRecordCommitteeid() {
		return recordCommitteeid;
	}
	public void setRecordCommitteeid(int recordCommitteeid) {
		this.recordCommitteeid = recordCommitteeid;
	}
	public int getRecordStudentid() {
		return recordStudentid;
	}
	public void setRecordStudentid(int recordStudentid) {
		this.recordStudentid = recordStudentid;
	}
	public int getRecordItemid() {
		return recordItemid;
	}
	public void setRecordItemid(int recordItemid) {
		this.recordItemid = recordItemid;
	}
	public int getRecordTimes() {
		return recordTimes;
	}
	public void setRecordTimes(int recordTimes) {
		this.recordTimes = recordTimes;
	}
	public String getRecordDiscribe() {
		return recordDiscribe;
	}
	public void setRecordDiscribe(String recordDiscribe) {
		this.recordDiscribe = recordDiscribe;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	

}
