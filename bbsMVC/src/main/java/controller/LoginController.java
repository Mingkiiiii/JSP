package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserService;
import model.userVO;

@WebServlet({"/login.do","/logout"})
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath(); // client 요청경로
		if("/login.do".equals(path)) {
			String userId = (String) req.getSession().getAttribute("userId");
			if(userId != null) {
				resp.sendRedirect("index.jsp");
			}else {
				// forward client 요청정보와 응답정보를 그대로 jsp쪽으로 전달
				req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
			}
		}else if("/logout".equals(path)) {
			HttpSession session = req.getSession();
			session.invalidate(); //세션초기화
			resp.sendRedirect("index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		userVO vo = service.loginUser(req.getParameter("userId"), req.getParameter("userPw"));
		if(vo != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", vo.getUserId());
			resp.sendRedirect("index.jsp");
		}else {
			resp.sendRedirect("login.do");
		}
	}
	
	
}
