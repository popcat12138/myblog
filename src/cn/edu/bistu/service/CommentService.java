package cn.edu.bistu.service;

import java.util.List;

import cn.edu.bistu.dao.CommentDao;
import cn.edu.bistu.entity.Comment;

public class CommentService {

	public Comment addComment(Comment comment) {
		CommentDao commentDao = new CommentDao();
		Comment newComment = commentDao.addComment(comment);

		if (newComment != null) {
			return newComment;
		}
		return null;
	}

	public Comment findByCommentId(String commentId) {
		CommentDao commentDao = new CommentDao();
		return (commentDao.findByCommentId(commentId));
	}

	public Comment addReply(Comment comment) {
		CommentDao commentDao = new CommentDao();
		Comment newComment = commentDao.addReply(comment);

		if (newComment != null) {
			return newComment;
		}
		return null;
	}

	public List<Comment> findCommentByBlogId(String blogId) {
		CommentDao commentDao = new CommentDao();
		return (commentDao.listCommentByBlogId(blogId));
	}

	public List<Comment> findReplyByCommentId(String commentId) {
		CommentDao commentDao = new CommentDao();
		return (commentDao.listCommentByCommentId(commentId));
	}

	public boolean alterCommentState(String commentId, boolean state) {

		CommentDao commentDao = new CommentDao();
		return (commentDao.alterCommentState(commentId, state));

	}

}
