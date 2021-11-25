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

/**
 * Servlet implementation class adminManagerServlet
 */
@WebServlet("/adminManager")
public class adminManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		// 判断是否为登陆

		UserService userService = new UserService();

		BlogService blogService = new BlogService();
		List<Blog> list = blogService.listBlogLast();

		request.setAttribute("listBlog", list);

		if (userService.isAdmin(userName)) {
			User user = userService.findByUsername(userName);
			request.setAttribute("user", user);
			request.setAttribute("name", userName);
			request.getRequestDispatcher("/adminManager.jsp").forward(request, response);
			return;

		} else {
			request.setAttribute("errorMessage1", "您不是管理员用户");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
