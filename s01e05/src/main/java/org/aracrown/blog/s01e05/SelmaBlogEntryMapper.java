package org.aracrown.blog.s01e05;

import org.aracrown.blog.s01e05.model.BlogEntry;
import org.aracrown.blog.s01e05.resource.BlogEntryResource;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

@Mapper(withCustomFields = { @Field({ "enabled", "properties.enabled" }), @Field({ "commentsEnabled", "properties.commentsEnabled" }),
		@Field({ "author.name", "authorName" }), @Field({ "author.signature", "authorSignature" }) }, withIgnoreMissing = IgnoreMissing.ALL)
public interface SelmaBlogEntryMapper {
	BlogEntryResource toResourceBlogEntry(BlogEntry entry);

	BlogEntry toJpaBlogEntry(BlogEntryResource entry);
}
