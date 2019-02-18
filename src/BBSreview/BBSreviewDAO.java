package BBSreview;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import java.util.List;

import DB.DBClose;
import DB.DBConnection;

public class BBSreviewDAO implements iBBSreviewDAO {
	
	private static BBSreviewDAO breview = new BBSreviewDAO();
	
	private BBSreviewDAO() {
	}
	
	public static BBSreviewDAO getInstance() {
		return breview;
	}

	@Override
	public List<BBSreviewDTO> getReviewList() {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, LOCALCATEGORY, "
				+ " MTCATEGORY, WDATE, DEL, READCOUNT, FILENAME, DOWNCOUNT " 
				+ " FROM REVIEW " + 
				" ORDER BY SEQ ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BBSreviewDTO> list = new ArrayList<BBSreviewDTO>();
		BBSreviewDTO rDto = new BBSreviewDTO();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 후기게시판");
			
			psmt = conn.prepareStatement(sql);
		    System.out.println("2/6 후기게시판");
		    
		    rs = psmt.executeQuery();
			System.out.println("3/6 후기게시판");
			
			while(rs.next()) {
				rDto = new BBSreviewDTO(
					rs.getInt(1),	//seq, 
					rs.getString(2),	//id, 
					rs.getString(3),	//title, 
					rs.getString(4),	//content, 
					rs.getString(5),	//localcategory, 
					rs.getString(6),	//mtcategory, 
					rs.getString(7),	//wdate, 
					rs.getInt(8),	//del, 
					rs.getInt(9),	//readcount, 
					rs.getString(10),	//filename, 
					rs.getInt(11));	//downcount)
							
				list.add(rDto); 
			}			
			System.out.println("4/6 후기게시판");
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return list; 
	}

	@Override
	public BBSreviewDTO reviewDetail(int seq) {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, LOCALCATEGORY, "
				+ " MTCATEGORY, WDATE, DEL, READCOUNT, FILENAME, DOWNCOUNT " 
				+ " FROM REVIEW " + 
				" WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		BBSreviewDTO rDto = new BBSreviewDTO();
	
		try {
			conn = DBConnection.getConnection();
		    System.out.println("1/6 후기게시판디테일");
		
		    psmt = conn.prepareStatement(sql);
		    System.out.println("2/6 후기게시판디테일");
		    
		    psmt.setInt(1, seq);
		    
		    rs = psmt.executeQuery();
			System.out.println("3/6 후기게시판디테일");
			
			while(rs.next()) {
				rDto = new BBSreviewDTO(
					rs.getInt(1),	//seq, 
					rs.getString(2),	//id, 
					rs.getString(3),	//title, 
					rs.getString(4),	//content, 
					rs.getString(5),	//localcategory, 
					rs.getString(6),	//mtcategory, 
					rs.getString(7),	//wdate, 
					rs.getInt(8),	//del, 
					rs.getInt(9),	//readcount, 
					rs.getString(10),	//filename, 
					rs.getInt(11));	//downcount)
			}	
			System.out.println("4/6 후기게시판디테일 성공");
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.DBClose.close(conn, psmt, rs);			
		}		
		return rDto;
	} 
	

}