package BBSreview;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/BBSreviewList")
public class BBSreviewList extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("BBSreviewList컨트롤러에 도착했습니다.");
		
		req.setCharacterEncoding("utf-8");
		
		iBBSreviewDAO rDao = BBSreviewDAO.getInstance();
		
		List<BBSreviewDTO> reviewList = rDao.getReviewList();
		
		req.setAttribute("reviewList", reviewList);
		
		req.getRequestDispatcher("BBSreview.jsp").forward(req, resp);
		
		System.out.println("BBSreview.jsp 뷰로 이동합니다.");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	

}
