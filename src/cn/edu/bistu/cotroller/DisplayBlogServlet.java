package cn.edu.bistu.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class DisplayBlogServlet
 */
@WebServlet("/DisplayBlog")
public class DisplayBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayBlogServlet() {
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

		UserService userService = new UserService();
		String userName = (String) request.getSession().getAttribute("userName");
		User user = userService.findByUsername(userName);
		if (userName == null || userName.equals("")) {
			request.setAttribute("name", "·Ã¿Í");
			request.getRequestDispatcher("/displayBlog.jsp").forward(request, response);
			return;
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/displayBlog.jsp").forward(request, response);

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
