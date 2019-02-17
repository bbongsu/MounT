package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import register.registerDTO;

@WebServlet(value="/loginAf")
public class loginAf extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html; charset=utf-8");		
		req.setCharacterEncoding("utf-8");
		
		System.out.println("loginAf doGet에 왔음");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//////////////////////////////한글 깨짐 방지
		
		resp.setContentType("text/html; charset=utf-8");		
		req.setCharacterEncoding("utf-8");
		
		//////////////////////////////확인용
		
		System.out.println("loginAf doPost에 왔음");
		
		//////////////////////////////login.jsp에 있는 hidden
		
		String command = req.getParameter("command");
		
		//////////////////////////////command의 value과 비교해서 세션에 추가!
		//////////////////////////////session에서 짐싼 별명은 "login"으로 설정함
			
		if(command.equals("loginAf")) 
		{

			//////////////////////////////Parameter 갖고오구~
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			//////////////////////////////Session 만들구~
			
			HttpSession session = req.getSession(false);
			
			//////////////////////////////DAO 불러오구~
			
			iloginDAO dao = loginDAO.getInstance();
			
			registerDTO dto = new registerDTO(id, pwd, null, null, null, null, null, null, null, null, 3);			
			registerDTO member = dao.login(dto);
			
			//////////////////////////////ID가 없다면 로그인 불가!
			
			if(member != null || !member.getId().equals(""))
			{
				session.setAttribute("login", member);
				session.setMaxInactiveInterval(30*60);
				System.out.println("[로그인 성공]");
				resp.sendRedirect("main.jsp");
			}
			else
			{
				System.out.println("[로그인 실패]");
				resp.sendRedirect("login.jsp");
			}
			
			//////////////////////////////끝
		}
	}
	
}
