package org.aracrown.blog.s01e03.query;


import javax.persistence.EntityManager;

import org.aracrown.blog.s01e03.model.BlogEntry;
import org.aracrown.blog.s01e03.model.QBlogEntry;
import org.aracrown.commons.persistence.AbstractQuery;

public class BlogEntryQueryImpl extends AbstractQuery<QBlogEntry, BlogEntry>{

	public BlogEntryQueryImpl(EntityManager entityManager) {
		super(entityManager, QBlogEntry.blogEntry);
	}

	public BlogEntryQueryImpl title(String title) {
		getQuery().where(getEntityPath().title.eq(title));
		return this;
	}

}
