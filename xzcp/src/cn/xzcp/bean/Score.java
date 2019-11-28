package cn.xzcp.bean;

import java.util.Date;

public class Score {

	private int scoreId;
	private int scoreStudentid;
	private int scoreScore;
	private Date scoreDate;
	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", scoreStudentid=" + scoreStudentid + ", scoreScore=" + scoreScore
				+ ", scoreDate=" + scoreDate + "]";
	}
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
	public int getScoreScore() {
		return scoreScore;
	}
	public void setScoreScore(int scoreScore) {
		this.scoreScore = scoreScore;
	}
	public Date getScoreDate() {
		return scoreDate;
	}
	public void setScoreDate(Date scoreDate) {
		this.scoreDate = scoreDate;
	}
	

}
