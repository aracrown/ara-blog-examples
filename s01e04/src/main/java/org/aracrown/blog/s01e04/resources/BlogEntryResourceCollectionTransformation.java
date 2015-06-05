package org.aracrown.blog.s01e04.resources;

import org.aracrown.blog.s01e04.model.BlogEntry;
import org.aracrown.commons.rest.ResourceCollectionResponse;
import org.aracrown.commons.rest.ResourceCollectionTransformation;

public class BlogEntryResourceCollectionTransformation extends ResourceCollectionTransformation<BlogEntry, BlogEntry>{

	public BlogEntryResourceCollectionTransformation(ResourceCollectionResponse<BlogEntry> target) {
		super(target);
		page(0L, 10L);
	}

	@Override
	public BlogEntry tranformSingle(BlogEntry arg0) {
		return arg0;
	}

}
