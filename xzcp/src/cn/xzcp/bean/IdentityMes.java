package cn.xzcp.bean;

public class IdentityMes extends Identity {

	int id;

	public int getId() {
		return super.identityId;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "IdentityMes [id=" + id + "]";
	}

}
