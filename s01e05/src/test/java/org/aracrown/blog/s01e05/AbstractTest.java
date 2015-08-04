package org.aracrown.blog.s01e05;

import org.aracrown.blog.s01e05.model.Author;
import org.aracrown.blog.s01e05.model.BlogEntry;

public class AbstractTest {
	protected BlogEntry newBlogEntry() {
		BlogEntry entry = new BlogEntry();
		entry.setAuthor(newAuthor());
		entry.setCommentsEnabled(true);
		entry.setEnabled(true);
		entry.setId(1L);
		entry.setTitle("title goes here");
		return entry;
	}

	protected Author newAuthor() {
		Author author = new Author();
		author.setName("name");
		author.setSignature("signature");
		return author;
	}
}
