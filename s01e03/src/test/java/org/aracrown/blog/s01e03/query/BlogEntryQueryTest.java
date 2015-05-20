package org.aracrown.blog.s01e03.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.aracrown.blog.s01e03.model.BlogEntry;
import org.aracrown.blog.s01e03.model.BlogEntry_;
import org.aracrown.blog.s01e03.model.QBlogEntry;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysema.query.jpa.impl.JPAQuery;

public class BlogEntryQueryTest {
	protected static EntityManager em;
	protected static EntityManagerFactory emf;

	@BeforeClass
	public static void beforeClass() {
		emf = Persistence.createEntityManagerFactory("s01e03");
		em = emf.createEntityManager();
	}

	@Test
	public void testQueryDSLDefault() {
		delete();
		
		Assert.assertTrue(new BlogEntryQueryImpl(getEntityManager()).title("test").list().isEmpty());
	}

	

	@Test
	public void testQueryDSLExists() {
		createBlogEntry();

		Assert.assertFalse(new BlogEntryQueryImpl(getEntityManager()).title("test").list().isEmpty());
	}

	@Test
	public void testQueryDSLPlain() {
		QBlogEntry qb = QBlogEntry.blogEntry;
		
		Assert.assertFalse(new JPAQuery(getEntityManager()).from(qb).where(qb.title.eq("test")).fetch().exists());
	}
	
	@Test
	public void testQueryDSLPlainExists() {
		createBlogEntry();

		QBlogEntry qb = QBlogEntry.blogEntry;
		
		Assert.assertTrue(new JPAQuery(getEntityManager()).from(qb).where(qb.title.eq("test")).fetch().exists());
	}

	
	@Test
	public void testCriteriaDefault() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BlogEntry> cq = cb.createQuery(BlogEntry.class);
		Root<BlogEntry> be = cq.from(BlogEntry.class);
		cq.select(be);
		TypedQuery<BlogEntry> q = em.createQuery(cq);
		List<BlogEntry> allItems = q.getResultList();

		Assert.assertTrue(allItems.isEmpty());
	}
	
	@Test
	public void testCriteriaExists() {
		createBlogEntry();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BlogEntry> cq = cb.createQuery(BlogEntry.class);
		Root<BlogEntry> be = cq.from(BlogEntry.class);
		cq.select(be);
		cq.where(cb.equal(be.get(BlogEntry_.title), "test"));
		TypedQuery<BlogEntry> q = em.createQuery(cq);
		List<BlogEntry> allItems = q.getResultList();

		Assert.assertFalse(allItems.isEmpty());
	}

	private void createBlogEntry() {
		em.getTransaction().begin();
		BlogEntry be = new BlogEntry();
		be.setTitle("test");
		be.setAuthor("author");
		em.persist(be);
		em.getTransaction().commit();
	}

	
	private void delete() {
		getEntityManager().getTransaction().begin();
		getEntityManager().createQuery("delete from BlogEntry").executeUpdate();
		getEntityManager().getTransaction().commit();
	}
	
	private EntityManager getEntityManager() {
		return em;
	}
}
