package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.Blog;
import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.BlogService;
import cn.edu.bistu.service.UserService;

@WebServlet("/SearchArticle")
public class SearchArticleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SearchArticleServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) request.getParameter("userName");
		String operator = (String) session.getAttribute("userName");
		if (userName == null || userName.equals("")) {
			userName = (String) session.getAttribute("userName");
		}

		BlogService blogService = new BlogService();
		List<Blog> list = blogService.listBlogLast();

		request.setAttribute("listBlog", list);
		UserService userService = new UserService();
		User user = userService.findByUsername(userName);
		request.setAttribute("result", "最新文章");
		request.setAttribute("user", user);
		if (operator == null || operator.equals("")) {
			request.setAttribute("name", "访客");
			request.getRequestDispatcher("/searchArticle.jsp").forward(request, response);
			return;
		}
		request.setAttribute("name", operator);
		request.getRequestDispatcher("/searchArticle.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) request.getParameter("userName");
		String title = (String) request.getParameter("title");
		String time = (String) request.getParameter("time");
		String operator = (String) session.getAttribute("userName");
		if (userName == null || userName.equals("")) {
			userName = (String) session.getAttribute("userName");
		}

		BlogService blogService = new BlogService();
		if (time == null && title != null) {
			List<Blog> list = blogService.fuzzySearchByTitle(title);
			request.setAttribute("listBlog", list);
			request.setAttribute("result", "按标题" + title);
		}
		if (title == null && time != null) {
			List<Blog> list = blogService.fuzzySearchByTime(time);
			request.setAttribute("listBlog", list);
			request.setAttribute("result", "按时间" + time);
		}

		UserService userService = new UserService();
		User user = userService.findByUsername(userName);
		request.setAttribute("user", user);
		if (operator == null || operator.equals("")) {
			request.setAttribute("name", "访客");
			request.getRequestDispatcher("/searchArticle.jsp").forward(request, response);
			return;
		}
		request.setAttribute("name", operator);
		request.getRequestDispatcher("/searchArticle.jsp").forward(request, response);

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
