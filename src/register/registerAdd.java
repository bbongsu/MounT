package register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/registerAdd")

public class registerAdd extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html; charset=utf-8");		
		req.setCharacterEncoding("utf-8");
		System.out.println("registerAdd doGet에 왔음");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html; charset=utf-8");		
		req.setCharacterEncoding("utf-8");
		
		System.out.println("registerAdd doPost에 왔음");
		
		String command = req.getParameter("command");
		
		if(command.equals("addAf"))
		{
			/////////////////////////register에 있는 값 받아오기
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String UserName = req.getParameter("UserName");
			String birth = req.getParameter("birth");
			
			String Postcode = req.getParameter("Postcode");
			
			String Address = req.getParameter("Address");
			String detailAddress = req.getParameter("detailAddress");
			String extraAddress = req.getParameter("extraAddress");
			
			String email = req.getParameter("email");
			String phonenum = req.getParameter("phonenum");
			
			/////////////////////////끝

			/////////////////////////값 다받아왔는지 확인
			
			System.out.println("id = " + id);
			System.out.println("pwd = " + pwd);
			System.out.println("UserName = " + UserName);
			System.out.println("birth = " + birth);
			System.out.println("Postcode = " + Postcode);
			System.out.println("Address = " + Address);
			System.out.println("detailAddress = " + detailAddress);
			System.out.println("extraAddress = " + extraAddress);
			System.out.println("email = " + email);
			System.out.println("phonenum = " + phonenum);
			
			/////////////////////////끝
			
			/////////////////////////DAO야 도와줘~
			
			iregisterDAO dao = registerDAO.getInstance();
			
			registerDTO dto = new registerDTO(id, pwd, UserName, birth, Postcode, Address, detailAddress, extraAddress, email, phonenum, 3);
			
			boolean isS = dao.AddRegister(dto);

			if(isS)
			{
				System.out.println("[가입 성공했습니다]");
				resp.sendRedirect("login.jsp");
			}
			else
			{
				System.out.println("[가입 실패했습니다]");
				resp.sendRedirect("register.jsp");
			}
			/////////////////////////끝
		}
	}
	
}
