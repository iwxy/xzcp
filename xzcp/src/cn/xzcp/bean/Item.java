package cn.xzcp.bean;

public class Item {

	private int itemId;
	private String itemName;
	private String itemDiscribe;
	private int itemCommitteeid;
	private double itemScore;

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDiscribe=" + itemDiscribe
				+ ", itemCommitteeid=" + itemCommitteeid + ", itemScore=" + itemScore + "]";
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDiscribe() {
		return itemDiscribe;
	}

	public void setItemDiscribe(String itemDiscribe) {
		this.itemDiscribe = itemDiscribe;
	}

	public int getItemCommitteeid() {
		return itemCommitteeid;
	}

	public void setItemCommitteeid(int itemCommitteeid) {
		this.itemCommitteeid = itemCommitteeid;
	}

	public double getItemScore() {
		return itemScore;
	}

	public void setItemScore(double itemScore) {
		this.itemScore = itemScore;
	}

}
