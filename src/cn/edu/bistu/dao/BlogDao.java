package cn.edu.bistu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.common.DbObject;
import cn.edu.bistu.entity.Blog;

public class BlogDao {
	public Blog findBlogByUsername(String userName) {

		String sql = "select * from Article where UserName=?";
		ResultSet rs = null;
		Blog blog = null;
		try {

			rs = DbObject.executeQuery(sql, userName);
			if (rs.next()) {
				blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				blog.setContent(rs.getString("content"));
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
				// return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return blog;

	}

	public Blog findBlogById(String BlogId) {

		String sql = "select * from Article where BlogId=?";
		ResultSet rs = null;
		Blog blog = null;
		try {
			rs = DbObject.executeQuery(sql, BlogId);
			if (rs.next()) {
				blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				blog.setContent(rs.getString("content"));
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return blog;

	}

	public Blog findBlogByNameId(String BlogId, String userName) {

		String sql = "select * from Article where BlogId=? and userName=?";
		ResultSet rs = null;
		Blog blog = null;
		try {
			rs = DbObject.executeQuery(sql, BlogId, userName);
			if (rs.next()) {
				blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				blog.setContent(rs.getString("content"));
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return blog;

	}

	public Blog addBlog(Blog blog) {

		// insert into BlogType(UserNameA,blogtype) values('','');
		String sql = "insert into Article(UserName,title,content,blogtype) values(?,?,?,?)";

		int iret = DbObject.executeUpdate(sql, blog.getUserName(), blog.getTitle(), blog.getContent(),
				blog.getBlogType());

		if (iret > 0) {
			return blog;
		}

		return null;
	}

	public boolean deleteBlog(String BlogId) {
		// "delete Article where blogId=?";
		String sql = "delete from Article where blogId=?";
		// "update Article set blogType='',title='',content='',userName='' where
		// blogId=?";

		int iret = DbObject.executeUpdate(sql, BlogId);
		if (iret > 0) {
			return true;
		}

		return false;

	}

	public Blog modifyBlog(Blog blog) {

		// update Article set blogType=? title=? content=? where blogId=?
		String sql = "update Article set AlterTime=NOW(),blogType=?,title=?,content=? where blogId=?";

		int iret = DbObject.executeUpdate(sql, blog.getBlogType(), blog.getTitle(), blog.getContent(),
				blog.getBlogId());

		if (iret > 0) {
			return blog;
		}

		return null;

	}

	public List<Blog> listBlogLast() {

		String sql = "select * from Article ORDER BY createTime DESC LIMIT 0,20";
		ResultSet rs = null;
		String content = null;
		ArrayList<Blog> list = new ArrayList<Blog>();
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				if ((rs.getString("content").length() <= 220)) {
					content = rs.getString("content") + "/>......";
				} else {
					content = (rs.getString("content")).substring(0, 220) + "/>......";
				}
				blog.setContent(content);
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
				list.add(blog);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

	public List<Blog> listBlogByUsername(String userName) {

		String sql = "select * from Article where UserName=? order by createTime DESC";
		ResultSet rs = null;
		String content = null;
		ArrayList<Blog> list = new ArrayList<Blog>();
		try {
			rs = DbObject.executeQuery(sql, userName);
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				if ((rs.getString("content").length() <= 220)) {
					content = rs.getString("content") + "/>......";
				} else {
					content = (rs.getString("content")).substring(0, 220) + "/>......";
				}
				blog.setContent(content);
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
				list.add(blog);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;

	}

	public List<Blog> fuzzySearchByTitle(String title) {

		String sql = "select * from Article where title like ? order by createTime DESC";
		ResultSet rs = null;
		String content = null;
		ArrayList<Blog> list = new ArrayList<Blog>();
		try {
			rs = DbObject.executeQuery(sql, "%" + title + "%");
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				if ((rs.getString("content").length() <= 220)) {
					content = rs.getString("content") + "/>......";
				} else {
					content = (rs.getString("content")).substring(0, 220) + "/>......";
				}
				blog.setContent(content);
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
				list.add(blog);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;
	}

	public List<Blog> fuzzySearchByTime(String time) {

		String sql = "SELECT * FROM Article WHERE createTime LIKE ? ORDER BY createTime desc";
		ResultSet rs = null;
		String content = null;
		ArrayList<Blog> list = new ArrayList<Blog>();
		try {
			rs = DbObject.executeQuery(sql, "%" + time + "%");
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				if ((rs.getString("content").length() <= 220)) {
					content = rs.getString("content") + "/>......";
				} else {
					content = (rs.getString("content")).substring(0, 220) + "/>......";
				}
				blog.setContent(content);
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
				list.add(blog);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbObject.close(null, null, rs);
		}
		return list;
	}

	public List<Blog> listBlogByType(String userName, String blogType) {

		String sql = "select * from Article where UserName=? and blogType=? order by createTime DESC";
		ResultSet rs = null;
		String content = null;
		ArrayList<Blog> list = new ArrayList<Blog>();
		try {
			rs = DbObject.executeQuery(sql, userName, blogType);
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setUserName(rs.getString("userName"));
				if ((rs.getString("content").length() <= 220)) {
					content = rs.getString("content") + "/>......";
				} else {
					content = (rs.getString("content")).substring(0, 220) + "/>......";
				}
				blog.setContent(content);
				blog.setTitle(rs.getString("title"));
				blog.setBlogType(rs.getString("blogtype"));
				blog.setBlogId(rs.getString("blogId"));
				blog.setCreateTime(rs.getString("createTime"));
				blog.setAlterTime(rs.getString("AlterTime"));
				list.add(blog);
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
