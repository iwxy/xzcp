package cn.xzcp.bean;

public class Classes {

	protected int classId;
	private String className;
	private int classTeacher;

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", classTeacher=" + classTeacher + "]";
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(int classTeacher) {
		this.classTeacher = classTeacher;
	}

}
