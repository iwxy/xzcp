package cn.xzcp.bean;

public class ItemMes extends Item {

	int id;
	String itemCommitteeName;

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

	@Override
	public String toString() {
		return "ItemMes [id=" + id + ", itemCommitteeName=" + itemCommitteeName + "]";
	}

}
