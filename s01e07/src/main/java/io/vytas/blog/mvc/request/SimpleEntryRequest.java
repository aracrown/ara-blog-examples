package io.vytas.blog.mvc.request;

import javax.ws.rs.FormParam;


/**
 * Very few input fields supported for new blog entry.
 * 
 * @author vytas.io
 *
 */
public class SimpleEntryRequest {
	@FormParam("path")
	private String path;
	
	@FormParam("title")
	private String title;

	@FormParam("content")
	private String content;

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	

}
