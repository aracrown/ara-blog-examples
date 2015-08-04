package org.aracrown.blog.s01e05;

import org.aracrown.blog.s01e05.model.Author;
import org.aracrown.blog.s01e05.model.BlogEntry;
import org.aracrown.blog.s01e05.resource.BlogEntryPropertiesResource;
import org.aracrown.blog.s01e05.resource.BlogEntryResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStructBlogEntryMapper {

	@Mappings({ @Mapping(source = "entry", target = "author"), @Mapping(source = "properties.enabled", target = "enabled"),
			@Mapping(source = "properties.commentsEnabled", target = "commentsEnabled") })
	BlogEntry toJpaBlogEntry(BlogEntryResource entry);

	@Mappings({ @Mapping(source = "authorName", target = "name"), @Mapping(source = "authorSignature", target = "signature") })
	Author toJpaAuthor(BlogEntryResource resource);

	// To resource mapping

	@Mappings({ @Mapping(source = "entry", target = "properties"), @Mapping(source = "author.name", target = "authorName"),
			@Mapping(source = "author.signature", target = "authorSignature") })
	BlogEntryResource toResourceBlogEntry(BlogEntry entry);

	BlogEntryPropertiesResource toResourceBlogEntryProperties(BlogEntry entry);
}
