package Myinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBClose;
import DB.DBConnection;

public class MyscheduleDAO implements iMyscheduleDAO 
{
	private static MyscheduleDAO scheduleDao = new MyscheduleDAO();
	
	private MyscheduleDAO() 
	{
		
	}
	
	public static MyscheduleDAO getInstance() 
	{
		return scheduleDao;
	}

	@Override
	public List<MyscheduleDTO> getscheduleList(String id, String yyyyMM) 
	{
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " +
				" FROM (SELECT ROW_NUMBER() OVER(PARTITION BY SUBSTR(RDATE, 1, 8) ORDER BY RDATE ASC) RN, " +
					"	SEQ, ID, TITLE, CONTENT, RDATE, WDATE " +
				" FROM SCHEDULE " +
				" WHERE ID=? AND SUBSTR(RDATE, 1, 6)=?) " +
				" WHERE RN BETWEEN 1 AND 5 "; 
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<MyscheduleDTO> list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("conn = " + conn);
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, yyyyMM.trim());
			System.out.println("psmt = " + psmt);
			
			rs = psmt.executeQuery();
			System.out.println("rs = " + rs);
			
			while(rs.next()) 
			{
				MyscheduleDTO dto = new MyscheduleDTO();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRdate(rs.getString(5));
				dto.setWdate(rs.getString(6));
				
				list.add(dto);
			}
			System.out.println(list.toString());
			
		} catch (SQLException e) {
			System.out.println("[getscheduleList함수에서 예외발생]");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}		
		
		return list;
	}

	@Override
	public boolean addschedule(MyscheduleDTO dto) {
		
		String sql = " INSERT INTO SCHEDULE(SEQ, ID, TITLE, CONTENT, RDATE, WDATE) "
				+ " VALUES(SEQ_CAL.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("conn = " + conn);
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getRdate());
			System.out.println("psmt = " + psmt);
			
			count = psmt.executeUpdate();
			System.out.println("count = " + count);
			
		} catch (SQLException e) {
			System.out.println("[addschedule함수에서 예외발생]");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
}
