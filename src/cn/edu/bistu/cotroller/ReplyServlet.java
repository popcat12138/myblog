package cn.edu.bistu.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bistu.entity.Comment;
import cn.edu.bistu.service.CommentService;
import cn.edu.bistu.service.UserService;

/**
 * Servlet implementation class CommentManagerServlet
 */
@WebServlet("/Reply")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogId = (String) request.getParameter("blogId");
		String content = (String) request.getParameter("reply");
		String parentId = (String) request.getParameter("parentId");
		String userNameB = (String) request.getParameter("userNameB");
		UserService userService = new UserService();
		request.setAttribute("user", userService.findByUsername(userName));

		Comment comment = new Comment();
		comment.setBlogId(blogId);
		comment.setContent(content);
		comment.setUserName(userName);
		comment.setParentId(parentId);
		comment.setUserNameB(userNameB);

		CommentService commentService = new CommentService();
		Comment newComment = commentService.addReply(comment);

		if (newComment == null) {
			request.setAttribute("error", "´íÎó");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

		response.sendRedirect("DisplayArticalById?blogId=" + blogId);

		// request.setAttribute("name", userName);
		// request.getRequestDispatcher(requestWhere).forward(request,
		// response);
	}

}
