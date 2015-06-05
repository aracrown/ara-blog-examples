package org.aracrown.blog.s01e04.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aracrown.blog.s01e04.model.BlogEntry;
import org.aracrown.blog.s01e04.query.BlogEntryQueryImpl;

@Named
public class BlogEntryDao {
	@PersistenceContext
	private EntityManager em;
	
	public List<BlogEntry> getAll() {
		return new BlogEntryQueryImpl(em).list();
	}
}
