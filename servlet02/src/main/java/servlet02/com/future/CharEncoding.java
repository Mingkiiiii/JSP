package servlet02.com.future;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.apache.el.parser.AstString;


@WebFilter("/CharEncoding")
public class CharEncoding implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("before filter");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		System.out.println("after filter");
	}


}
