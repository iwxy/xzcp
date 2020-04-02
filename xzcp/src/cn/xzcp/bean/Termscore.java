package cn.xzcp.bean;

public class Termscore {

	protected int termscoreId;
	private int termscoreStudentid;
	private double termscoreScore;
	private String termscoreDate;

	@Override
	public String toString() {
		return "Termscore [termscoreId=" + termscoreId + ", termscoreStudentid=" + termscoreStudentid
				+ ", termscoreScore=" + termscoreScore + ", termscoreDate=" + termscoreDate + "]";
	}

	public int getTermscoreId() {
		return termscoreId;
	}

	public void setTermscoreId(int termscoreId) {
		this.termscoreId = termscoreId;
	}

	public int getTermscoreStudentid() {
		return termscoreStudentid;
	}

	public void setTermscoreStudentid(int termscoreStudentid) {
		this.termscoreStudentid = termscoreStudentid;
	}

	public double getTermscoreScore() {
		return termscoreScore;
	}

	public void setTermscoreScore(double termscoreScore) {
		this.termscoreScore = termscoreScore;
	}

	public String getTermscoreDate() {
		return termscoreDate;
	}

	public void setTermscoreDate(String termscoreDate) {
		this.termscoreDate = termscoreDate;
	}

}
