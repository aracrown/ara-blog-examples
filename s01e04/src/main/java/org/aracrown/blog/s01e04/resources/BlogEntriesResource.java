package org.aracrown.blog.s01e04.resources;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.aracrown.blog.s01e04.model.BlogEntry;
import org.aracrown.blog.s01e04.query.BlogEntryQueryImpl;
import org.aracrown.commons.rest.ResourceCollectionResponse;

@Path("/")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BlogEntriesResource {

	@PersistenceContext
	EntityManager em;

	@GET
	public ResourceCollectionResponse<BlogEntry> getAll() {
		BlogEntryQueryImpl query = new BlogEntryQueryImpl(em);

		return new BlogEntryResourceCollectionTransformation(new ResourceCollectionResponse<BlogEntry>()).total(query.count()).page(0L, 10L)
				.transform(query.page(0L, 10L).list());
	}
}
