package cn.xzcp.bean;

public class UserMes extends User {

	// 表格多选时，用的是同一个js方法，获取的是id，这个属性专为多选准备（okUtils.tableBatchCheck）
	int id;
	String userClassName;
	String userIdentityName;

	@Override
	public String toString() {
		return "UserMes [id=" + id + ", userClassName=" + userClassName + ", userIdentityName=" + userIdentityName
				+ "]";
	}

	public int getId() {
		return super.userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserClassName() {
		return userClassName;
	}

	public void setUserClassName(String userClassName) {
		this.userClassName = userClassName;
	}

	public String getUserIdentityName() {
		return userIdentityName;
	}

	public void setUserIdentityName(String userIdentityName) {
		this.userIdentityName = userIdentityName;
	}

}
