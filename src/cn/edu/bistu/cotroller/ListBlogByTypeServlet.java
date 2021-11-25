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

@WebServlet("/ListBlogByType")
public class ListBlogByTypeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListBlogByTypeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String userName = (String) request.getParameter("userName");
		String operator = (String) session.getAttribute("userName");

		String blogType = (String) request.getParameter("blogtype");
		BlogService blogService = new BlogService();
		BlogTypeService blogTypeService = new BlogTypeService();

		String top = "ListBlogByType?blogtype=" + blogType + "&userName=" + userName;

		if (userName == null || userName.equals("")) {
			top = "ListBlogByType?blogtype=" + blogType;
			userName = (String) session.getAttribute("userName");
		}

		if (blogType == null || blogType.equals("")) {
			List<Blog> list = blogService.listBlogByUsername(userName);
			request.setAttribute("TYPE", "全部文章");
			request.setAttribute("listBlog", list);
		} else {
			List<Blog> list = blogService.listBlogByType(userName, blogType);
			request.setAttribute("TYPE", blogType);
			request.setAttribute("listBlog", list);
		}
		UserService userService = new UserService();
		User user = userService.findByUsername(userName);
		request.setAttribute("user", user);

		List<BlogType> listType = blogTypeService.findAllBlogType(userName);
		request.setAttribute("listType", listType);

		request.setAttribute("top", top);

		if (operator == null || operator.equals("")) {
			request.setAttribute("name", "访客");
			request.getRequestDispatcher("/listArticle.jsp").forward(request, response);
			return;
		}
		request.setAttribute("name", operator);
		request.getRequestDispatcher("/listArticle.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
