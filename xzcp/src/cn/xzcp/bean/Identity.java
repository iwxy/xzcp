package cn.xzcp.bean;

public class Identity {

	protected int identityId;
	private String identityName;

	@Override
	public String toString() {
		return "Identity [identityId=" + identityId + ", identityName=" + identityName + "]";
	}

	public int getIdentityId() {
		return identityId;
	}

	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}

	public String getIdentityName() {
		return identityName;
	}

	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}

}
