package cn.edu.bistu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.common.DbObject;
import cn.edu.bistu.entity.BlogType;

public class BlogTypeDao {
	public BlogType addBlogType(BlogType blogtype) {

		// insert into BlogType(UserNameA,blogtype) values('','');
		String sql = "insert into BlogType(UserName,blogtype) values(?,?)";

		int iret = DbObject.executeUpdate(sql, blogtype.getUserName(), blogtype.getBlogType());

		if (iret > 0) {
			return blogtype;
		}

		return null;
	}

	public boolean deleteBlogType(String userName, String blogType) {

		// delete BlogType where userNameA=? and blogType=?;
		String sql = "delete from BlogType where UserName=? and blogtype=?";

		int iret = DbObject.executeUpdate(sql, userName, blogType);

		if (iret > 0) {
			return true;
		}

		return false;
	}

	public boolean modifyBlogType(String newBlogType, String userName, String blogType) {

		// delete BlogType where userNameA=? and blogType=?;
		String sql = "update BlogType set blogtype=? where UserName=? and blogtype=?";

		int iret = DbObject.executeUpdate(sql, newBlogType, userName, blogType);

		if (iret > 0) {
			return true;
		}

		return false;
	}

	// 查看某用户某分类下文章个数
	/*
	 * public int findBlogNum(String userName, String blogType) { String sql =
	 * "SELECT COUNT(*) as num FROM article WHERE userName=? AND blogType=?";
	 * ResultSet rs = null; int num = 0; try { rs = DbObject.executeQuery(sql,
	 * userName); num = rs.getInt("num");
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } finally { DbObject.close(null, null, rs); } return
	 * num; }
	 */

	public List<BlogType> findAllBlogType(String userName) {
		String sql = "select * from BlogType where UserName=? ";
		ResultSet rs = null;
		ArrayList<BlogType> list = new ArrayList<BlogType>();
		try {
			rs = DbObject.executeQuery(sql, userName);

			while (rs.next()) {
				BlogType blogType = new BlogType();
				blogType.setBlogType(rs.getString("blogtype"));

				list.add(blogType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}
}
