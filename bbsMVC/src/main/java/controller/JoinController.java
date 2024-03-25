package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;
import model.userVO;

@WebServlet("/join.do")
public class JoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		userVO vo = new userVO();
		vo.setUserId(req.getParameter("userId"));
		vo.setUserPw(req.getParameter("userPw"));
		int cnt = service.insertUser(vo);
		if(cnt > 0) {
			resp.sendRedirect("login.do");
			
		}else {
			resp.sendRedirect("join.do");
		}
	}
	
}
