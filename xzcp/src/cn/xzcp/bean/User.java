package cn.xzcp.bean;

public class User {

	private int userId;
	private String userName;
	private String password;
	private String userSex;
	private int userClassid;
	private int userIdentity;
	private String userDormitory;
	private String userPhone;
	private String userAddress;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userSex=" + userSex
				+ ", userClassid=" + userClassid + ", userIdentity=" + userIdentity + ", userDormitory=" + userDormitory
				+ ", userPhone=" + userPhone + ", userAddress=" + userAddress + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getUserClassid() {
		return userClassid;
	}

	public void setUserClassid(int userClassid) {
		this.userClassid = userClassid;
	}

	public int getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(int userIdentity) {
		this.userIdentity = userIdentity;
	}

	public String getUserDormitory() {
		return userDormitory;
	}

	public void setUserDormitory(String userDormitory) {
		this.userDormitory = userDormitory;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
