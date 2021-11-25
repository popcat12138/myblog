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
import cn.edu.bistu.entity.BlogType;
import cn.edu.bistu.entity.User;
import cn.edu.bistu.service.BlogService;
import cn.edu.bistu.service.BlogTypeService;
import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class blogManagerServlet
 */
@WebServlet("/BlogManager")
public class BlogManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlogManagerServlet() {
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
		String state = (String) request.getParameter("state");
		String warning = (String) request.getParameter("warning");
		BlogService blogService = new BlogService();

		String blogType = (String) request.getParameter("blogtype");
		BlogTypeService blogTypeService = new BlogTypeService();

		if (blogType == null || blogType.equals("")) {
			List<Blog> list = blogService.listBlogByUsername(userName);
			request.setAttribute("listBlog", list);
		} else {

			List<Blog> list = blogService.listBlogByType(userName, blogType);
			request.setAttribute("listBlog", list);
		}

		UserService userService = new UserService();
		User user = userService.findByUsername(userName);
		request.setAttribute("user", user);
		List<BlogType> listType = blogTypeService.findAllBlogType(userName);
		request.setAttribute("listType", listType);
		request.setAttribute("state", state);
		request.setAttribute("warning", warning);
		request.setAttribute("name", userName);
		request.getRequestDispatcher("/blogManager.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
