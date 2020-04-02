package cn.xzcp.bean;

public class ScoreMes extends Score {

	int id;
	String scoreStudentName;
	double oldScore;
	int limit;
	int page;
	int firstIndex;
	String scoreDatel;
	int scoreClassid;
	String scoreClassName;
	int scoreTeacherid;

	public int getId() {
		return super.scoreId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScoreStudentName() {
		return scoreStudentName;
	}

	public void setScoreStudentName(String scoreStudentName) {
		this.scoreStudentName = scoreStudentName;
	}

	public double getOldScore() {
		return oldScore;
	}

	public void setOldScore(double oldScore) {
		this.oldScore = oldScore;
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

	public String getScoreDatel() {
		return scoreDatel;
	}

	public void setScoreDatel(String scoreDatel) {
		this.scoreDatel = scoreDatel;
	}

	public int getScoreClassid() {
		return scoreClassid;
	}

	public void setScoreClassid(int scoreClassid) {
		this.scoreClassid = scoreClassid;
	}

	public String getScoreClassName() {
		return scoreClassName;
	}

	public void setScoreClassName(String scoreClassName) {
		this.scoreClassName = scoreClassName;
	}

	public int getScoreTeacherid() {
		return scoreTeacherid;
	}

	public void setScoreTeacherid(int scoreTeacherid) {
		this.scoreTeacherid = scoreTeacherid;
	}

	@Override
	public String toString() {
		return "ScoreMes [id=" + id + ", scoreStudentName=" + scoreStudentName + ", oldScore=" + oldScore + ", limit="
				+ limit + ", page=" + page + ", firstIndex=" + firstIndex + ", scoreDatel=" + scoreDatel
				+ ", scoreClassid=" + scoreClassid + ", scoreClassName=" + scoreClassName + ", scoreTeacherid="
				+ scoreTeacherid + "]";
	}

}
