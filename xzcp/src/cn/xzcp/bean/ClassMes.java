package cn.xzcp.bean;

public class ClassMes extends Classes {

	// 表格多选时，用的是同一个js方法，获取的是id，这个属性专为多选准备（okUtils.tableBatchCheck）
	int id;
	String classTeacherName;

	public String getClassTeacherName() {
		return classTeacherName;
	}

	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
	}

	public int getId() {
		return super.classId;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ClassMes [id=" + id + ", classTeacherName=" + classTeacherName + "]";
	}

}
