package cn.xzcp.bean;

public class ItemMes extends Item {

	int id;
	String itemCommitteeName;
	int limit;
	int page;
	int firstIndex;

	public int getId() {
		return super.itemId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemCommitteeName() {
		return itemCommitteeName;
	}

	public void setItemCommitteeName(String itemCommitteeName) {
		this.itemCommitteeName = itemCommitteeName;
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
		return "ItemMes [id=" + id + ", itemCommitteeName=" + itemCommitteeName + ", limit=" + limit + ", page=" + page
				+ ", firstIndex=" + firstIndex + "]";
	}

}
