package io.vytas.blog.query;

import javax.persistence.EntityManager;

import org.aracrown.commons.persistence.AbstractQuery;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import io.vytas.blog.model.BlogEntry;
import io.vytas.blog.model.QBlogEntry;

/**
 * Simple typed blog query.
 * 
 * @author vytas.io
 *
 */
public class BlogEntryQueryImpl extends AbstractQuery<QBlogEntry, BlogEntry> {

	public BlogEntryQueryImpl(EntityManager entityManager) {
		super(entityManager, QBlogEntry.blogEntry);
	}

	public BlogEntryQueryImpl title(String title) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(title), "Post title is not provided.");
		getQuery().where(getEntityPath().title.eq(title));
		return this;
	}

	public BlogEntryQueryImpl path(String path) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(path), "Path is empty");
		getQuery().where(getEntityPath().path.eq(path));
		return this;
	}

	public byte[] getImage() {
		return getQuery().select(QBlogEntry.blogEntry.image).fetchFirst();
	}
}
