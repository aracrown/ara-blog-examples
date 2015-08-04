package org.aracrown.blog.s01e05;

import org.aracrown.blog.s01e05.model.Author;
import org.aracrown.blog.s01e05.model.BlogEntry;
import org.aracrown.blog.s01e05.resource.BlogEntryResource;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

public class MapStructBlogEntryMapperTest {

	@Test
	public void testMapStructMapper() throws Exception {
		MapStructBlogEntryMapper mapper = Mappers.getMapper(MapStructBlogEntryMapper.class);
		BlogEntryResource result = mapper.toResourceBlogEntry(newBlogEntry());
		Assert.assertEquals("title goes here", result.getTitle());
		Assert.assertEquals("name", result.getAuthorName());
		Assert.assertEquals("signature", result.getAuthorSignature());
		Assert.assertEquals(1, result.getId().intValue());
		
		Assert.assertNotNull(result.getProperties());
		Assert.assertTrue(result.getProperties().isCommentsEnabled());
		Assert.assertTrue(result.getProperties().isEnabled());
		
		BlogEntry reverse = mapper.toJpaBlogEntry(result);
		
		Assert.assertEquals("title goes here", reverse.getTitle());
		Assert.assertEquals(1, reverse.getId().intValue());
		Assert.assertTrue(reverse.isCommentsEnabled());
		Assert.assertTrue(reverse.isEnabled());
		
		Assert.assertNotNull(reverse.getAuthor());
		Assert.assertEquals("name", reverse.getAuthor().getName());
		Assert.assertEquals("signature", reverse.getAuthor().getSignature());
	}

	private BlogEntry newBlogEntry() {
		BlogEntry entry = new BlogEntry();
		entry.setAuthor(newAuthor());
		entry.setCommentsEnabled(true);
		entry.setEnabled(true);
		entry.setId(1L);
		entry.setTitle("title goes here");
		return entry;
	}

	private Author newAuthor() {
		Author author = new Author();
		author.setName("name");
		author.setSignature("signature");
		return author;
	}
}
