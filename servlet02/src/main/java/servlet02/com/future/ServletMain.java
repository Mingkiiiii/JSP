package servlet02.com.future;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class ServletMain extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("main");
		String nm = req.getParameter("nm");
		System.out.println(nm);
		res.setContentType("text/html; charset=utf-8");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('" + nm + "님 반가워요^^');");
		out.println("</script>");
		// /main url명으로 요청이 오면 해당 서블릿이 동작하게 web.xml을 수정하세요(성공)
	}
	

}
