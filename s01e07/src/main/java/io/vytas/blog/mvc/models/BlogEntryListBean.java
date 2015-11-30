package io.vytas.blog.mvc.models;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.vytas.blog.dao.BlogEntryDao;
import io.vytas.blog.model.BlogEntry;

/**
 * CDI bean to retrieve blog post entry list.
 * 
 * @author vytas.io
 *
 */
@Named
@RequestScoped
public class BlogEntryListBean {
	
	@Inject
	private BlogEntryDao blogEntryDao;
	
	private List<BlogEntry> blogEntries;

	/**
	 * @return the blogEntries
	 */
	public List<BlogEntry> getBlogEntries() {
		if (blogEntries == null) {
			blogEntries = blogEntryDao.page(0L, 20L);
		}
		return blogEntries;
	}
}
