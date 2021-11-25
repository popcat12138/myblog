package cn.edu.bistu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.common.DbObject;
import cn.edu.bistu.entity.Comment;

public class CommentDao {

	// 添加主评论，不加parentId
	public Comment addComment(Comment comment) {
		String sql = "insert into Comment(blogId,UserName,content,UserNameB) values(?,?,?,?)";
		int iret = DbObject.executeUpdate(sql, comment.getBlogId(), comment.getUserName(), comment.getContent(),
				comment.getUserNameB());

		if (iret > 0) {
			return comment;
		}

		return null;
	}

	// 回复评论，加上parentId
	public Comment addReply(Comment comment) {
		String sql = "insert into Comment(blogId,UserName,content,parentId,UserNameB) values(?,?,?,?,?)";
		int iret = DbObject.executeUpdate(sql, comment.getBlogId(), comment.getUserName(), comment.getContent(),
				comment.getParentId(), comment.getUserNameB());

		if (iret > 0) {
			return comment;
		}

		return null;
	}

	public Comment findByCommentId(String commentId) {
		String sql = "select * from Comment where commentId=?";
		ResultSet rs = null;
		Comment comment = null;
		try {
			rs = DbObject.executeQuery(sql, commentId);
			if (rs.next()) {
				comment = new Comment();
				comment.setState(rs.getString("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return comment;
	}

	public boolean alterCommentState(String commentId, boolean state) {
		if (state) {
			String sql = "update Comment set state=? where commentId=?";
			int iret = DbObject.executeUpdate(sql, "禁用", commentId);
			if (iret > 0) {
				return true;
			}

			return false;

		} else {
			String sql = "update Comment set state=? where commentId=?";
			int iret = DbObject.executeUpdate(sql, "正常", commentId);

			if (iret > 0) {
				return true;
			}

			return false;
		}

	}

	// 根据文章Id获得评论表 and parentId=-1
	public List<Comment> listCommentByBlogId(String blogId) {
		String sql = "select * from Comment where blogId=? and parentId=-1";
		ResultSet rs = null;
		ArrayList<Comment> list = new ArrayList<Comment>();

		try {
			rs = DbObject.executeQuery(sql, blogId);
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setBlogId(rs.getString("blogId"));
				comment.setCommentId(rs.getString("commentId"));
				comment.setContent(rs.getString("content"));
				comment.setCreateTime(rs.getString("createTime"));
				comment.setParentId(rs.getString("parentId"));
				comment.setState(rs.getString("state"));
				comment.setUserName(rs.getString("UserName"));
				comment.setUserNameB(rs.getString("UserNameB"));
				list.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;
	}

	public List<Comment> listCommentByCommentId(String commentId) {
		String sql = "select * from Comment where parentId=?";
		ResultSet rs = null;
		ArrayList<Comment> list = new ArrayList<Comment>();

		try {
			rs = DbObject.executeQuery(sql, commentId);
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setBlogId(rs.getString("blogId"));
				comment.setCommentId(rs.getString("commentId"));
				comment.setContent(rs.getString("content"));
				comment.setCreateTime(rs.getString("createTime"));
				comment.setParentId(rs.getString("parentId"));
				comment.setState(rs.getString("state"));
				comment.setUserName(rs.getString("UserName"));
				comment.setUserNameB(rs.getString("UserNameB"));
				list.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;
	}

}
