package cn.edu.bistu.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.BlogType;
import cn.edu.bistu.service.BlogTypeService;

/**
 * Servlet implementation class addBlogType
 */
@WebServlet("/addBlogType")
public class addBlogType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addBlogType() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		String blogType = (String) request.getParameter("blogtype");

		request.setAttribute("name", userName);

		BlogType blogtype = new BlogType();
		blogtype.setBlogType(blogType);
		blogtype.setUserName(userName);

		BlogTypeService blogTypeService = new BlogTypeService();
		blogtype = blogTypeService.addBlogType(blogtype);

		if (blogtype != null) {
			response.sendRedirect("addBlog");
			return;
		}
	}

}
