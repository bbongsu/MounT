package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBClose;
import DB.DBConnection;
import register.registerDTO;

public class loginDAO implements iloginDAO 
{
	/////////////////////////싱글톤
	
	private static loginDAO loginDao = new loginDAO();
	
	private loginDAO() 
	{
		DBConnection.initConnect();
	}
	
	public static loginDAO getInstance() {
		return loginDao;
	}
	
	/////////////////////////끝
	
	/////////////////////////로그인 함수
	
	@Override
	public registerDTO login(registerDTO dto) 
	{
		//////////////////////////////SQL문 
		
		String sql = " SELECT ID, PWD, NAME, BIRTH, POSTCODE, ADDRESS, "
				+ " DETAILADDRESS, EXTRAADDRESS, EMAIL, PHONENUM, AUTH"
				+ " FROM REGISTER "
				+ " WHERE ID=? AND PWD=? ";
		
		
		////////////////conn : DB연결 , psmt : SQL적용 , rs : 결과처리 , 회원로그인
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		registerDTO member = null;
		
		try 
		{
			conn = DBConnection.getConnection();
			System.out.println("conn = " + conn);
			
			psmt = conn.prepareStatement(sql);
			System.out.println("psmt = " + psmt);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			
			rs = psmt.executeQuery();
			System.out.println("rs = " + rs);
			
			if(rs.next()) 
			{
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String postcode = rs.getString(5);
				String address = rs.getString(6);
				String detailaddress = rs.getString(7);
				String extraaddress = rs.getString(8);
				String email = rs.getString(9);
				String phonenum = rs.getString(10);
				int auth = rs.getInt(11);
				
				member = new registerDTO(id, pwd, name, birth, postcode
				, address, detailaddress, extraaddress, email, phonenum, auth);				
			}
			
			System.out.println(member.toString());
		} 
		catch (SQLException e) 
		{
			System.out.println("[login함수에서 예외 발생]");
			e.printStackTrace();
		} 
		finally 
		{
			DBClose.close(conn, psmt, rs);			
		}
				
		return member;
	}

}
