package BBSreview;
/*DROP TABLE REVIEW
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_REVIEW;

CREATE TABLE REVIEW
(
	SEQ NUMBER(8) PRIMARY KEY, --시퀀스(게시글번호)
	ID VARCHAR2(20) NOT NULL, --아이디
	
	TITLE VARCHAR2(50) NOT NULL, --제목
	CONTENT VARCHAR2(4000) NOT NULL, --내용
	
	LOCALCATEGORY VARCHAR2(20) NOT NULL, --지역 카테고리
	MTCATEGORY VARCHAR2(20) NOT NULL, --지역에 있는 산 카테고리
	
	WDATE DATE NOT NULL, --작성일
	
	DEL NUMBER(1) NOT NULL, --삭제
	READCOUNT NUMBER(8) NOT NULL, --조회수
	
	FILENAME VARCHAR2(50) NOT NULL, --파일이름
	DOWNCOUNT NUMBER(8) NOT NULL --다운로드수
);*/
import java.io.Serializable;

public class BBSreviewDTO implements Serializable 
{
	private int seq;
	private String id;
	private String title;
	private String content;
	
	private String localcategory;
	private String mtcategory;
	
	private String wdate;
	
	private int del;
	private int readcount;
	
	private String filename;
	private int downcount;
	
	public BBSreviewDTO() {
		
	}
	
	public BBSreviewDTO(int seq, String id, String title, String content, String localcategory, String mtcategory,
			String wdate, int del, int readcount, String filename, int downcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.localcategory = localcategory;
		this.mtcategory = mtcategory;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
		this.filename = filename;
		this.downcount = downcount;
	}

	public BBSreviewDTO(String title, String content, String localcategory, String mtcategory, String filename) {
		super();
		this.title = title;
		this.content = content;
		this.localcategory = localcategory;
		this.mtcategory = mtcategory;
		this.filename = filename;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocalcategory() {
		return localcategory;
	}

	public void setLocalcategory(String localcategory) {
		this.localcategory = localcategory;
	}

	public String getMtcategory() {
		return mtcategory;
	}

	public void setMtcategory(String mtcategory) {
		this.mtcategory = mtcategory;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}

	@Override
	public String toString() {
		return "BBSreviewDTO [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", localcategory=" + localcategory + ", mtcategory=" + mtcategory + ", wdate=" + wdate + ", del="
				+ del + ", readcount=" + readcount + ", filename=" + filename + ", downcount=" + downcount + "]";
	}
}
