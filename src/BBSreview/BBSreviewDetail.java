package BBSreview;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/BBSreviewDetail")
public class BBSreviewDetail extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		System.out.println("BBSreviewDetail컨트롤러에 도착했습니다.");
		
		req.setCharacterEncoding("utf-8");
		
		iBBSreviewDAO rDao = BBSreviewDAO.getInstance();
		
		String sseq = req.getParameter("seq");
		int seq = Integer.parseInt(sseq);
		
		System.out.println(seq);
		
		BBSreviewDTO rDto = rDao.reviewDetail(seq);
		
		req.setAttribute("rDto", rDto);
		
		req.getRequestDispatcher("BBSreviewDetail.jsp").forward(req, resp);
		
		System.out.println("BBSreviewDetail.jsp 뷰로 이동합니다.");
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	
}
