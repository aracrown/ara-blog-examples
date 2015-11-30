package io.vytas.blog.dao;

import org.aracrown.commons.persistence.AbstractBuilder;
import org.aracrown.commons.util.RandomStringGenerator;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import io.vytas.blog.model.BlogEntry;

/**
 * Simple POJO builder to create new blog entry.
 * 
 * @author vytas.io
 *
 */
public class BlogEntryBuilder extends AbstractBuilder<BlogEntry>{

	public BlogEntryBuilder() {
		super(new BlogEntry());
	}

	public BlogEntryBuilder defaultAuthor() {
		getEntity().setAuthor("Firstname Lastname");
		return this;
	}

	public BlogEntryBuilder title(String title) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(title), "Post title is not provided.");
		getEntity().setTitle(title);
		return this;
	}

	public BlogEntryBuilder content(String content) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(content), "Post content is not provided.");
		getEntity().setContent(content);
		return this;
	}

	public BlogEntryBuilder randomPath() {
		getEntity().setPath(new RandomStringGenerator().generateLettersNumbers(10));
		return this;
	}

	public BlogEntryBuilder image(byte[] datainput) {
		if (datainput != null && datainput.length > 0) {
			getEntity().setImage(datainput);
		}
		return this;
	}

}
