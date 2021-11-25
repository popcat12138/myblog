package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.Blog;
import cn.edu.bistu.service.BlogService;

@WebServlet("/DeleteBlog")
public class DeleteBlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteBlogServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(); String userName =
		 * (String) session.getAttribute("userName"); String blogId = (String)
		 * request.getParameter("blogId");
		 * 
		 * BlogService blogService = new BlogService(); if
		 * (blogService.blogVerify(userName, blogId)) { Blog blog =
		 * blogService.findBlogById(blogId); request.setAttribute("blog", blog);
		 * request.setAttribute("name", userName);
		 * request.getRequestDispatcher("/modifyUserpassword.jsp").forward(
		 * request, response); } else { request.setAttribute("name", userName);
		 * request.setAttribute("warning", "禁止操作！");
		 * request.getRequestDispatcher("/blogManager.jsp").forward(request,
		 * response);
		 * 
		 * }做一个判断！删除时确定一下是否拥有
		 */

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogId = (String) request.getParameter("blogId");

		BlogService blogService = new BlogService();
		if (userName.equals(blogService.findBlogById(blogId).getUserName())) {

			Blog blog = new Blog();
			blog.setBlogId(blogId);

			request.setAttribute("name", userName);

			if (blogService.deleteBlog(blogId)) {
				response.sendRedirect("BlogManager?state=" + URLEncoder.encode("删除成功！", "utf-8"));
				return;
			} else {
				response.sendRedirect("BlogManager?state=" + URLEncoder.encode("删除失败！", "utf-8"));
				return;
			}
		} else {
			response.sendRedirect("BlogManager?state=" + URLEncoder.encode("违法操作！", "utf-8"));
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init() throws ServletException {

	}

}
