package Myinfo;

import java.io.Serializable;

/*
DROP TABLE SCHEDULE
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_SCHEDULE;

CREATE TABLE SCHEDULE
(
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(20) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	RDATE VARCHAR2(12) NOT NULL,
	WDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_SCHEDULE
START WITH 1
INCREMENT BY 1;

ALTER TABLE SCHEDULE
ADD CONSTRAINT FK_SCHEDULE_ID FOREIGN KEY(ID)
REFERENCES REGISTER(ID);
*/

public class MyscheduleDTO implements Serializable 
{
	private static final long serialVersionUID = 7858396664119031610L;
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private String rdate;	// 약속한 날짜
	private String wdate;	// 작성한 날짜
	
	public MyscheduleDTO() 
	{
		
	}
	
	public MyscheduleDTO(int seq, String id, String title, String content, String rdate, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.wdate = wdate;
	}

	public MyscheduleDTO(String id, String title, String content, String rdate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
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

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MyscheduleDTO [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", rdate="
				+ rdate + ", wdate=" + wdate + "]";
	}
}
