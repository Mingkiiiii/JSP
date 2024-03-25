package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BbsVO;
import model.UserService;
import model.userVO;

@WebServlet("/mypage.do")
public class MypageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userId = null;
		
		if(session.getAttribute("userId") != null){
			userId = (String)session.getAttribute("userId");
		}else{
			// 사용자 정보 없을 때
			// redirect client에게 다시 해당 페이지로 요청하게
			resp.sendRedirect("index.jsp");
			return;
		}
		
		UserService service = UserService.getInstance();
		userVO vo = service.userInfo(userId);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		userVO vo = new userVO();
		vo.setUserId(req.getParameter("userId"));
		vo.setUserNm(req.getParameter("userNm"));
		int cnt = service.updateUser(vo);
		if(cnt > 0) {
			resp.sendRedirect("index.jsp");
		}else {
			resp.sendRedirect("mypage.do");
		}

	}
}
