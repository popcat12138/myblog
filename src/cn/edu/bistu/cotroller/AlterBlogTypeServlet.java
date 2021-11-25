package cn.edu.bistu.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.service.BlogTypeService;

@WebServlet("/AlterBlogType")
public class AlterBlogTypeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AlterBlogTypeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// √ª”√
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogType = (String) request.getParameter("blogtype");
		String newBlogType = (String) request.getParameter("newBlogtype");

		BlogTypeService blogTypeService = new BlogTypeService();

		if (blogTypeService.modifyBlogType(newBlogType, userName, blogType)) {
			response.sendRedirect("ListBlogByType");
		} else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
