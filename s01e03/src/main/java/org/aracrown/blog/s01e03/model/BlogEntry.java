package org.aracrown.blog.s01e03.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BLOG_ENTRY")
@Cacheable
public class BlogEntry {
	/** The primary key. */
	@Id
	@SequenceGenerator(name = "BLOG_ENTRY_ID_GENERATOR", sequenceName = "BLOG_ENTRY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLOG_ENTRY_ID_GENERATOR")
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "TITLE_")
	private String title;

	@Column(name = "AUTHOR_")
	private String author;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

}
