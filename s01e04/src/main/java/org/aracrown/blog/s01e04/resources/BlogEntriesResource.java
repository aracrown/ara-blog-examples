package org.aracrown.blog.s01e04.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.aracrown.blog.s01e04.dao.BlogEntryDao;
import org.aracrown.blog.s01e04.model.BlogEntry;
import org.aracrown.commons.rest.ResourceCollectionResponse;

@Path("/")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BlogEntriesResource {

	@Inject
	private BlogEntryDao blogEntryDao;

	@GET
	public ResourceCollectionResponse<BlogEntry> getAll() {

		return new BlogEntryResourceCollectionTransformation(new ResourceCollectionResponse<BlogEntry>()).total(blogEntryDao.count()).page(0L, 10L)
				.transform(blogEntryDao.page(0L, 10L));
	}
}
