package cn.edu.bistu.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CommentServlet
 */
@WebServlet("/Comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operator = (String) session.getAttribute("userName");
		String commentId = (String) request.getParameter("commentId");
		UserService userService = new UserService();
		String json;

		if (!userService.isAdmin(operator)) {
			request.setAttribute("errorMessage1", "登录后操作");
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
		} else {
			CommentService commentService = new CommentService();

			boolean state = commentService.findByCommentId(commentId).getState().equals("正常");
			if (state) {
				if (commentService.alterCommentState(commentId, state)) {
					json = "{\"success\":\"trueA\"}";
				} else {
					json = "{\"success\":\"false\"}";
				}

			} else {
				if (commentService.alterCommentState(commentId, state)) {
					json = "{\"success\":\"trueB\"}";
				} else {
					json = "{\"success\":\"false\"}";
				}

			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();

			out.println(json);
			out.flush();
			out.close();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String blogId = (String) request.getParameter("blogId");
		String content = (String) request.getParameter("content");
		String userNameB = (String) request.getParameter("userNameB");
		UserService userService = new UserService();
		request.setAttribute("user", userService.findByUsername(userName));

		Comment comment = new Comment();
		comment.setBlogId(blogId);
		comment.setContent(content);
		comment.setUserName(userName);
		comment.setUserNameB(userNameB);

		CommentService commentService = new CommentService();
		Comment newComment = commentService.addComment(comment);

		if (newComment == null) {
			response.sendRedirect("DisplayArticalById?blogId=" + blogId);
			return;
		}

		response.sendRedirect("DisplayArticalById?blogId=" + blogId);
	}

}
