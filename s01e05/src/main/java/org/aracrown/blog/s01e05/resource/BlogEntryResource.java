package org.aracrown.blog.s01e05.resource;

public class BlogEntryResource {
	/** The primary key. */
	private Long id;

	private String title;

	private String authorName;
	
	private String authorSignature;
	
	private BlogEntryPropertiesResource properties = new BlogEntryPropertiesResource();
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @return the properties
	 */
	public BlogEntryPropertiesResource getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(BlogEntryPropertiesResource properties) {
		this.properties = properties;
	}

	/**
	 * @return the authorSignature
	 */
	public String getAuthorSignature() {
		return authorSignature;
	}

	/**
	 * @param authorSignature the authorSignature to set
	 */
	public void setAuthorSignature(String authorSignature) {
		this.authorSignature = authorSignature;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
