package cn.edu.bistu.service;

import java.util.List;

import cn.edu.bistu.dao.BlogDao;
import cn.edu.bistu.entity.Blog;

public class BlogService {

	public boolean blogVerify(String userName, String blogId) {
		Blog blog = findBlogById(blogId);
		if (blog.getUserName().equals(userName)) {
			return true;
		}
		return false;
	}

	public boolean deleteTypeVerify(String userName, String blogType) {
		List<Blog> list = listBlogByType(userName, blogType);
		List<Blog> list1 = listBlogByType("", "");

		if (list.equals(list1)) {
			return true;
		}
		return false;
	}

	public Blog addBlog(Blog blog) {

		BlogDao blogDao = new BlogDao();
		return (blogDao.addBlog(blog));
	}

	public Blog modifyBlog(Blog blog) {

		BlogDao blogDao = new BlogDao();
		return (blogDao.modifyBlog(blog));
	}

	public boolean deleteBlog(String BlogId) {

		BlogDao blogDao = new BlogDao();
		return (blogDao.deleteBlog(BlogId));
	}

	public Blog findBlogByUsername(String userName) {
		BlogDao blogDao = new BlogDao();
		return (blogDao.findBlogByUsername(userName));

	}

	public Blog findBlogById(String BlogId) {
		BlogDao blogDao = new BlogDao();
		return (blogDao.findBlogById(BlogId));

	}

	public Blog findBlogByNameId(String BlogId, String userName) {
		BlogDao blogDao = new BlogDao();
		return (blogDao.findBlogByNameId(BlogId, userName));

	}

	public List<Blog> listBlogLast() {
		BlogDao blogDao = new BlogDao();
		return (blogDao.listBlogLast());
	}

	public List<Blog> listBlogByUsername(String userName) {
		BlogDao blogDao = new BlogDao();
		return (blogDao.listBlogByUsername(userName));
	}

	public List<Blog> listBlogByType(String userName, String blogType) {
		BlogDao blogDao = new BlogDao();
		return (blogDao.listBlogByType(userName, blogType));
	}

	public List<Blog> fuzzySearchByTitle(String title) {
		BlogDao blogDao = new BlogDao();
		return (blogDao.fuzzySearchByTitle(title));
	}

	public List<Blog> fuzzySearchByTime(String time) {
		BlogDao blogDao = new BlogDao();
		return (blogDao.fuzzySearchByTime(time));
	}

}
