package org.aracrown.blog.s01e04.resources;

import org.aracrown.blog.s01e04.model.BlogEntry;
import org.aracrown.commons.rest.ResourceCollectionResponse;
import org.aracrown.commons.rest.ResourceCollectionTransformation;

public class BlogEntryResourceCollectionTransformation extends ResourceCollectionTransformation<BlogEntry, BlogEntry> {

	public BlogEntryResourceCollectionTransformation(Long first, Long pageSize) {
		super(new ResourceCollectionResponse<BlogEntry>());
		page(first, pageSize);
	}

	@Override
	public BlogEntry tranformSingle(BlogEntry arg0) {
		return arg0;
	}

}
