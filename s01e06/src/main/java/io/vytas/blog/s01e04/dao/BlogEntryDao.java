package io.vytas.blog.s01e04.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.vytas.blog.s01e04.model.BlogEntry;
import io.vytas.blog.s01e04.query.BlogEntryQueryImpl;

@Named
public class BlogEntryDao {
	@PersistenceContext
	private EntityManager em;

	public List<BlogEntry> page(Long first, Long pageSize) {
		return new BlogEntryQueryImpl(em).page(first, pageSize).list();
	}

	public Long count() {
		return new BlogEntryQueryImpl(em).count();
	}

	public BlogEntry get(String path) {
		return new BlogEntryQueryImpl(em).path(path).singleResult();
	}
}
