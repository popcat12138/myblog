package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.net.URLEncoder;
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

/**
 * Servlet implementation class addBlogServlet
 */
@WebServlet("/addBlog")
public class addBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addBlogServlet() {
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

		BlogTypeService blogTypeService = new BlogTypeService();

		List<BlogType> list = blogTypeService.findAllBlogType(userName);

		// 显示用户列表
		if (list.isEmpty()) {
			response.sendRedirect("BlogManager?warning=" + URLEncoder.encode("请添加博客类型后发表文章！", "utf-8"));
			return;
		}
		request.setAttribute("list", list);
		request.setAttribute("name", userName);
		request.getRequestDispatcher("/addBlog.jsp").forward(request, response);
		return;

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
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		String blogtype = (String) request.getParameter("blogtype");

		// System.out.print(content);

		Blog blog = new Blog();
		blog.setContent(content);
		blog.setUserName(userName);
		blog.setTitle(title);
		blog.setBlogType(blogtype);

		BlogService blogService = new BlogService();
		blog = blogService.addBlog(blog);
		if (blog != null) {
			response.sendRedirect("ListArticle");
		}

	}

}
