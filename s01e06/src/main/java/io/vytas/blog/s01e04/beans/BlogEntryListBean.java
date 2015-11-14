package io.vytas.blog.s01e04.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.vytas.blog.s01e04.dao.BlogEntryDao;
import io.vytas.blog.s01e04.model.BlogEntry;

@Named
@RequestScoped
public class BlogEntryListBean {
	private List<BlogEntry> blogEntries;
	
	@Inject
	private BlogEntryDao blogEntryDao;
	
	public List<BlogEntry> getBlogEntries() {
		if (blogEntries == null) {
			blogEntries = blogEntryDao.page(0L, 10L);
		}
		return blogEntries;
	}
}
