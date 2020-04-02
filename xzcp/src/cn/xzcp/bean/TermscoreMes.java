package cn.xzcp.bean;

public class TermscoreMes extends Termscore {

	int id;
	String termscoreStudentName;
	int termscoreClassid;
	String termscoreClassName;
	int termscoreTeacherid;
	int limit;
	int page;
	int firstIndex;

	public int getId() {
		return super.termscoreId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTermscoreStudentName() {
		return termscoreStudentName;
	}

	public void setTermscoreStudentName(String termscoreStudentName) {
		this.termscoreStudentName = termscoreStudentName;
	}

	public int getTermscoreClassid() {
		return termscoreClassid;
	}

	public void setTermscoreClassid(int termscoreClassid) {
		this.termscoreClassid = termscoreClassid;
	}

	public String getTermscoreClassName() {
		return termscoreClassName;
	}

	public void setTermscoreClassName(String termscoreClassName) {
		this.termscoreClassName = termscoreClassName;
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

	public int getTermscoreTeacherid() {
		return termscoreTeacherid;
	}

	public void setTermscoreTeacherid(int termscoreTeacherid) {
		this.termscoreTeacherid = termscoreTeacherid;
	}

	@Override
	public String toString() {
		return "TermscoreMes [id=" + id + ", termscoreStudentName=" + termscoreStudentName + ", termscoreClassid="
				+ termscoreClassid + ", termscoreClassName=" + termscoreClassName + ", termscoreTeacherid="
				+ termscoreTeacherid + ", limit=" + limit + ", page=" + page + ", firstIndex=" + firstIndex + "]";
	}

}
