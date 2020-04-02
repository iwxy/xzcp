package cn.xzcp.bean;

public class IdentityMes extends Identity {

	int id;
	int limit;
	int page;
	int firstIndex;

	public int getId() {
		return super.identityId;
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

	@Override
	public String toString() {
		return "IdentityMes [id=" + id + ", limit=" + limit + ", page=" + page + ", firstIndex=" + firstIndex + "]";
	}

}
