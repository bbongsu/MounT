package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBConnection;
import DB.DBClose;

public class registerDAO implements iregisterDAO 
{
	
	/////////////////////////싱글톤
	
	private static registerDAO registerdao = new registerDAO();
	
	private registerDAO() 
	{
		DBConnection.initConnect();
	}
	
	public static registerDAO getInstance() 
	{
		return registerdao;
	}
	
	/////////////////////////끝
	
	/////////////////////////회원 추가 함수
	
	public boolean AddRegister(registerDTO dto) 
	{
		String sql = " INSERT INTO REGISTER " + 
					 "(ID,PWD,NAME,BIRTH,POSTCODE," + 
					 "ADDRESS,DETAILADDRESS,EXTRAADDRESS," + 
					 "EMAIL,PHONENUM,AUTH) " +
					 " VALUES(?,?,?,?,?,?,?,?,?,?,3)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try 
		{
			conn = DBConnection.getConnection();
			System.out.println("conn = " + conn);
			
			psmt = conn.prepareStatement(sql);
			System.out.println("psmt = " + psmt);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getBirth());
			psmt.setString(5, dto.getPostcode());
			psmt.setString(6, dto.getAddress());
			psmt.setString(7, dto.getDetailaddress());
			psmt.setString(8, dto.getExtraaddress());
			psmt.setString(9, dto.getEmail());
			psmt.setString(10, dto.getPhonenum());
			
			count = psmt.executeUpdate();
			System.out.println("count = " + count);
		} 
		catch (SQLException e) 
		{		
			System.out.println("[AddRegister에서 예외발생]");
			e.printStackTrace();
		} 
		finally 
		{
			DBClose.close(conn, psmt, null);
		}
				
		return count>0?true:false;
	}

}
