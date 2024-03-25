package servlet01.com.future;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class ServletSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletSecond() {
        super();
    }

	// 최초 second 요청이 오면 호출됨. (get,post모두)
	public void init(ServletConfig config) throws ServletException {
		System.out.println("요청이 왔습니다!!");
	}

	// 종료시 실행됨.
	public void destroy() {
		System.out.println("종료시 실행됨.");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식 요청을 받음
		System.out.println("doGet");
		System.out.println("요청 nm 변수값"+ request.getParameter("nm"));
		response.getWriter().append("Served at: ").append(request.getParameter("nm")).append("ㅇㅇㅇ");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("utf-8");
		String nm = request.getParameter("nm");
		System.out.println(nm);
		// response응답
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+nm+" 님 반가워요 ^^ ');");
		out.println("</script>");
	}

}
