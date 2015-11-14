package io.vytas.blog.s01e04.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.common.base.Preconditions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import io.vytas.blog.s01e04.dao.BlogEntryDao;
import io.vytas.blog.s01e04.model.BlogEntry;

@Named
@RequestScoped
@URLMappings(mappings={
		@URLMapping(id = "blog", pattern = "/blog/#{path : blogEntryBean.path}/", viewId = "/blog-entry.html")
})
public class BlogEntryBean {
	private BlogEntry blogEntry;
	
	private String path;
	
	@Inject
	private BlogEntryDao blogEntryDao;
	
	public BlogEntry getBlogEntry() {
		if (blogEntry == null) {
			Preconditions.checkNotNull(path, "Path not provided");
			Preconditions.checkArgument(path.length() > 0, "Path is empty");
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
