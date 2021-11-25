package cn.edu.bistu.service;

import java.util.List;

import cn.edu.bistu.dao.BlogTypeDao;
import cn.edu.bistu.entity.BlogType;

public class BlogTypeService {
	public BlogType addBlogType(BlogType blogtype) {

		BlogTypeDao blogTypeDao = new BlogTypeDao();
		return (blogTypeDao.addBlogType(blogtype));
	}

	public boolean deleteBlogType(String userName, String blogType) {

		BlogTypeDao blogTypeDao = new BlogTypeDao();
		return (blogTypeDao.deleteBlogType(userName, blogType));
	}

	public List<BlogType> findAllBlogType(String userName) {
		BlogTypeDao blogTypeDao = new BlogTypeDao();
		return blogTypeDao.findAllBlogType(userName);
	}

	public boolean modifyBlogType(String newBlogType, String userName, String blogType) {

		BlogTypeDao blogTypeDao = new BlogTypeDao();
		return (blogTypeDao.modifyBlogType(newBlogType, userName, blogType));
	}

}
