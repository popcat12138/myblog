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
import cn.edu.bistu.service.BlogService;
import cn.edu.bistu.service.BlogTypeService;

@WebServlet("/AlterArtical")
public class AlterArticalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AlterArticalServlet() {
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

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogId = (String) request.getParameter("blogId");
		BlogService blogService = new BlogService();

		if (blogService.blogVerify(userName, blogId)) {
			BlogTypeService blogTypeService = new BlogTypeService();
			List<BlogType> listType = blogTypeService.findAllBlogType(userName);
			Blog blog = blogService.findBlogById(blogId);
			request.setAttribute("listType", listType);
			request.setAttribute("blog", blog);
			request.setAttribute("name", userName);
			request.getRequestDispatcher("/modifyArtical.jsp").forward(request, response);
		} else {
			request.setAttribute("name", userName);
			request.setAttribute("warning", "½ûÖ¹²Ù×÷£¡");
			request.getRequestDispatcher("/blogManager.jsp").forward(request, response);

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogId = (String) request.getParameter("blogId");
		String blogType = (String) request.getParameter("blogType");
		String content = (String) request.getParameter("content");
		String title = (String) request.getParameter("title");

		request.setAttribute("name", userName);

		Blog blog = new Blog();

		blog.setBlogId(blogId);
		blog.setBlogType(blogType);
		blog.setContent(content);
		blog.setTitle(title);

		BlogService blogService = new BlogService();
		Blog newBlog = blogService.modifyBlog(blog);

		if (newBlog == null) {
			request.setAttribute("error", "ÐÞ¸ÄÊ§°Ü");
			request.setAttribute("blog", blog);
			request.getRequestDispatcher("/modifyArtical.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("DisplayArticalById?blogId=" + blogId);

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
