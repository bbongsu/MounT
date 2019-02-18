package register;

import java.io.Serializable;

/*
--회원 테이블 삭제

DROP TABLE REGISTER
CASCADE CONSTRAINTS;

--회원 검색

SELECT * FROM REGISTER;

--회원 테이블

CREATE TABLE REGISTER
(
	ID VARCHAR2(20) PRIMARY KEY, --아이디
	PWD VARCHAR2(20) NOT NULL, --패스워드
	NAME VARCHAR2(20) NOT NULL, --이름
	BIRTH VARCHAR2(20) NOT NULL, --생일

	POSTCODE VARCHAR2(20), --우편번호
	ADDRESS VARCHAR2(100) NOT NULL, --주소
	DETAILADDRESS VARCHAR2(50), --상세주소
	EXTRAADDRESS VARCHAR2(50) NOT NULL, --참고항목
	
	EMAIL VARCHAR2(30) UNIQUE, --이메일

	PHONENUM VARCHAR2(20) NOT NULL, --전화번호
	AUTH NUMBER(1) NOT NULL --사용자/관리자
);
*/

public class registerDTO implements Serializable 
{	
	///////////////아이디,비밀번호,이름,생일
	
	private String id; 
	private String pwd; 
	private String name;
	private String birth;
	
	///////////////우편번호,주소,상세주소,참고항목
	
	private String postcode;
	private String address;
	private String detailaddress;
	private String extraaddress;
	
	///////////////이메일,전화번호,사용자(3)/관리자(1)
	
	private String email;
	private String phonenum;
	private int auth;
	
	///////////////생성자
	
	public registerDTO(String id, String pwd, String name, String birth, String postcode, String address,
			String detailaddress, String extraaddress, String email, String phonenum, int auth) 
	{
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.postcode = postcode;
		this.address = address;
		this.detailaddress = detailaddress;
		this.extraaddress = extraaddress;
		this.email = email;
		this.phonenum = phonenum;
		this.auth = auth;
	}
	
	///////////////getter , setter
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public String getExtraaddress() {
		return extraaddress;
	}
	public void setExtraaddress(String extraaddress) {
		this.extraaddress = extraaddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	///////////////toString(확인용)
	
	@Override
	public String toString() 
	{
		return "registerDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", birth=" + birth + ", postcode="
				+ postcode + ", address=" + address + ", detailaddress=" + detailaddress + ", extraaddress="
				+ extraaddress + ", email=" + email + ", phonenum=" + phonenum + ", auth=" + auth + "]";
	}
}
