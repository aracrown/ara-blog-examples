package io.vytas.blog.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import io.vytas.blog.model.BlogEntry;
import io.vytas.blog.query.BlogEntryQueryImpl;

/**
 * Blog related DAO.
 * 
 * @author vytas.io
 *
 */
@Named
public class BlogEntryDao {
	@Inject
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

	/**
	 * Using deltaspike transaction for testing purposes only.
	 * 
	 * @param be
	 *            blog post entry to persist.
	 */
	@org.apache.deltaspike.jpa.api.transaction.Transactional
	public void save(BlogEntry be) {
		em.persist(be);
		em.flush();
	}

	public byte[] getImage(String path) {
		return new BlogEntryQueryImpl(em).path(path).getImage();
	}
}
