package io.vytas.blog.s01e04.query;


import javax.persistence.EntityManager;

import io.vytas.blog.s01e04.model.QBlogEntry;
import org.aracrown.commons.persistence.AbstractQuery;

import com.google.common.base.Preconditions;

import io.vytas.blog.s01e04.model.BlogEntry;

public class BlogEntryQueryImpl extends AbstractQuery<QBlogEntry, BlogEntry>{

	public BlogEntryQueryImpl(EntityManager entityManager) {
		super(entityManager, QBlogEntry.blogEntry);
	}

	public BlogEntryQueryImpl title(String title) {
		getQuery().where(getEntityPath().title.eq(title));
		return this;
	}

	public BlogEntryQueryImpl path(String path) {
		Preconditions.checkNotNull(path, "Path not provided");
		Preconditions.checkArgument(path.length() > 0, "Path is empty");
		getQuery().where(getEntityPath().path.eq(path));
		return this;
	}

}
