package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.service.BlogService;
import cn.edu.bistu.service.BlogTypeService;

@WebServlet("/DeleteBlogType")
public class deleteBlogTypeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public deleteBlogTypeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogType = (String) request.getParameter("blogType");
		BlogService blogService = new BlogService();

		if (blogService.deleteTypeVerify(userName, blogType)) {
			BlogTypeService blogTypeService = new BlogTypeService();
			if (blogTypeService.deleteBlogType(userName, blogType)) {
				response.sendRedirect("BlogManager?warning=" + URLEncoder.encode("删除成功！", "utf-8"));
			} else {

				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else {
			response.sendRedirect("BlogManager?warning=" + URLEncoder.encode("当前博客类型仍有文章！请转移或删除后删除本博客类型", "utf-8"));

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogType = (String) request.getParameter("blogType");
		BlogService blogService = new BlogService();

		if (blogService.deleteTypeVerify(userName, blogType)) {
			BlogTypeService blogTypeService = new BlogTypeService();
			if (blogTypeService.deleteBlogType(userName, blogType)) {
				request.setAttribute("name", userName);
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			} else {
				request.setAttribute("name", userName);
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("name", userName);
			request.setAttribute("warning", "当前博客类型仍有文章！请转移或删除后删除本博客类型");
			request.getRequestDispatcher("/blogManager.jsp").forward(request, response);

		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
