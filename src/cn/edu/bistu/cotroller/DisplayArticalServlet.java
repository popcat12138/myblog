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
import cn.edu.bistu.entity.Comment;
import cn.edu.bistu.service.BlogService;
import cn.edu.bistu.service.CommentService;
import cn.edu.bistu.service.UserService;

@WebServlet("/DisplayArticalById")
public class DisplayArticalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DisplayArticalServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String blogId = (String) request.getParameter("blogId");
		String operator = (String) session.getAttribute("userName");
		String userName = (String) request.getParameter("userName");

		CommentService commentService = new CommentService();
		List<Comment> commentList = commentService.findCommentByBlogId(blogId);

		BlogService blogService = new BlogService();
		Blog blog = blogService.findBlogById(blogId);
		// ¶¥²ãµ×²ã¶¨Î»
		String top = "?blogId=" + blogId + "&userName=" + userName;

		if (userName == null || userName.equals("")) {
			top = "?blogId=" + blogId;
			userName = blog.getUserName();
		}

		UserService userService = new UserService();
		request.setAttribute("blog", blog);
		request.setAttribute("commentList", commentList);
		request.setAttribute("user", userService.findByUsername(userName));
		request.setAttribute("top", top);

		if (operator == null || operator.equals("")) {
			request.setAttribute("name", "·Ã¿Í");
			request.setAttribute("role", "user");
			request.getRequestDispatcher("/displayArticle.jsp").forward(request, response);
			return;
		}
		if (userService.isAdmin(operator)) {
			request.setAttribute("role", "admin");
		} else {
			request.setAttribute("role", "user");
		}

		request.setAttribute("name", operator);
		request.getRequestDispatcher("/displayArticle.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
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
