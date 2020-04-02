package cn.xzcp.bean;

public class RecordMes extends Record {

	int id;
	int limit;
	int page;
	int firstIndex;
	String recordCommitteeName;
	String recordStudentName;
	String recordItemName;
	double recordScore;
	String recordDatel;
	int recordClassid;
	String recordClassName;
	int recordTeacherid;

	public int getId() {
		return super.recordId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getFirstIndex() {
		return (page - 1) * limit;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public String getRecordCommitteeName() {
		return recordCommitteeName;
	}

	public void setRecordCommitteeName(String recordCommitteeName) {
		this.recordCommitteeName = recordCommitteeName;
	}

	public String getRecordStudentName() {
		return recordStudentName;
	}

	public void setRecordStudentName(String recordStudentName) {
		this.recordStudentName = recordStudentName;
	}

	public String getRecordItemName() {
		return recordItemName;
	}

	public void setRecordItemName(String recordItemName) {
		this.recordItemName = recordItemName;
	}

	public double getRecordScore() {
		return recordScore * recordTimes;
	}

	public void setRecordScore(double recordScore) {
		this.recordScore = recordScore;
	}

	public String getRecordDatel() {
		return recordDatel;
	}

	public void setRecordDatel(String recordDatel) {
		this.recordDatel = recordDatel;
	}

	public int getRecordClassid() {
		return recordClassid;
	}

	public void setRecordClassid(int recordClassid) {
		this.recordClassid = recordClassid;
	}

	public String getRecordClassName() {
		return recordClassName;
	}

	public void setRecordClassName(String recordClassName) {
		this.recordClassName = recordClassName;
	}

	public int getRecordTeacherid() {
		return recordTeacherid;
	}

	public void setRecordTeacherid(int recordTeacherid) {
		this.recordTeacherid = recordTeacherid;
	}

	@Override
	public String toString() {
		return "RecordMes [id=" + id + ", limit=" + limit + ", page=" + page + ", firstIndex=" + firstIndex
				+ ", recordCommitteeName=" + recordCommitteeName + ", recordStudentName=" + recordStudentName
				+ ", recordItemName=" + recordItemName + ", recordScore=" + recordScore + ", recordDatel=" + recordDatel
				+ ", recordClassid=" + recordClassid + ", recordClassName=" + recordClassName + ", recordTeacherid="
				+ recordTeacherid + "]";
	}

}
