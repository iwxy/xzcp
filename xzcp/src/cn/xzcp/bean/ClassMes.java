package cn.xzcp.bean;

public class ClassMes extends Classes {

	// 表格多选时，用的是同一个js方法，获取的是id，这个属性专为多选准备（okUtils.tableBatchCheck）
	int id;
	String classTeacherName;
	int limit;
	int page;
	int firstIndex;

	public int getId() {
		return super.classId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassTeacherName() {
		return classTeacherName;
	}

	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
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

	@Override
	public String toString() {
		return "ClassMes [id=" + id + ", classTeacherName=" + classTeacherName + ", limit=" + limit + ", page=" + page
				+ ", firstIndex=" + firstIndex + "]";
	}

}
