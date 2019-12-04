package cn.xzcp.bean;

public class UserMes extends User {

	String userClassName;
	String userIdentityName;

	@Override
	public String toString() {
		return "UserMes [userClassName=" + userClassName + ", userIdentityName=" + userIdentityName + "]";
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
