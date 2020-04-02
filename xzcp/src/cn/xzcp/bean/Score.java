package cn.xzcp.bean;

public class Score {

	protected int scoreId;
	private int scoreStudentid;
	private double scoreScore;
	private String scoreDate;

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public int getScoreStudentid() {
		return scoreStudentid;
	}

	public void setScoreStudentid(int scoreStudentid) {
		this.scoreStudentid = scoreStudentid;
	}

	public double getScoreScore() {
		return scoreScore;
	}

	public void setScoreScore(double scoreScore) {
		this.scoreScore = scoreScore;
	}

	public String getScoreDate() {
		return scoreDate;
	}

	public void setScoreDate(String scoreDate) {
		this.scoreDate = scoreDate;
	}

	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", scoreStudentid=" + scoreStudentid + ", scoreScore=" + scoreScore
				+ ", scoreDate=" + scoreDate + "]";
	}

}
