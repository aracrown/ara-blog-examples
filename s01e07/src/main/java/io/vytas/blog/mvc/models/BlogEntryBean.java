package io.vytas.blog.mvc.models;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import io.vytas.blog.dao.BlogEntryDao;
import io.vytas.blog.model.BlogEntry;

/**
 * CDI bean to retrieve blog post by path.
 * 
 * @author vytas.io
 *
 */
@Named("blogEntryBean")
@RequestScoped
public class BlogEntryBean {
	private BlogEntry blogEntry;
	
	private String path;
	
	@Inject
	private BlogEntryDao blogEntryDao;
	
	public BlogEntry getBlogEntry() {
		if (blogEntry == null) {
			Preconditions.checkArgument(!Strings.isNullOrEmpty(path), "Path is empty");
			blogEntry = blogEntryDao.get(path);
			Preconditions.checkNotNull(blogEntry, "Blog entry does not exist!Please, check the home page!");
		}
		return blogEntry;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
