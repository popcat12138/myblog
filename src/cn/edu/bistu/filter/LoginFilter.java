package cn.edu.bistu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//"/addBlog","/addBlogType", "/adminManager", "/AlterPassword","/addBlog", "/listUser","/addBlog", "/listUser","/main"
@WebFilter(urlPatterns = {
		"/*" }, initParams = @WebInitParam(name = "excludedPages", value = "/index.jsp,/register,/login,/js/,/img/,/css/"))
public class LoginFilter implements Filter {

	private String excludedPages;
	private String[] excludedPageArray;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String url = req.getServletPath();

		if (!url.equals("/login") && !url.equals("/register") && !url.equals("/index.jsp") && !url.equals("/login.jsp")
				&& !url.startsWith("/js/") && !url.startsWith("/css/") && !url.startsWith("/img/")
				&& !url.startsWith("/logo/") && !url.startsWith("/adminLogin") && !url.startsWith("/existUser")
				&& !url.startsWith("/VerifyCode") && !url.startsWith("/visitor") && !url.startsWith("/Display")
				&& !url.startsWith("/List") && !url.startsWith("/Search") && !url.startsWith("/main")
				&& !url.startsWith("/tools/")) {

			String userName = (String) req.getSession().getAttribute("userName");

			if (userName == null || userName.equals("")) {
				res.sendRedirect("login?mustLogin=");
				return;
			}

		}
		chain.doFilter(request, response);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		excludedPages = arg0.getInitParameter("excludedPages");
		if (!excludedPages.isEmpty()) {
			excludedPageArray = excludedPages.split(",");
		}
	}

}
