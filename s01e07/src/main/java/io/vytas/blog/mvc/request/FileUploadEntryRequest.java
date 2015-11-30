package io.vytas.blog.mvc.request;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * Sample post request with file upload support.
 * 
 * @author vytas.io
 *
 */
public class FileUploadEntryRequest {
	@FormDataParam("path")
	private String path;

	@FormDataParam("title")
	private String title;

	@FormDataParam("content")
	private String content;

	@FormDataParam("uploadfile")
	private InputStream uploadedInputStream;

	@FormDataParam("uploadfile")
	private FormDataContentDisposition fileDetail;

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
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
	 * @param title
	 *            the title to set
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
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the uploadedInputStream
	 */
	public InputStream getUploadedInputStream() {
		return uploadedInputStream;
	}

	/**
	 * @param uploadedInputStream the uploadedInputStream to set
	 */
	public void setUploadedInputStream(InputStream uploadedInputStream) {
		this.uploadedInputStream = uploadedInputStream;
	}

	/**
	 * @return the fileDetail
	 */
	public FormDataContentDisposition getFileDetail() {
		return fileDetail;
	}

	/**
	 * @param fileDetail the fileDetail to set
	 */
	public void setFileDetail(FormDataContentDisposition fileDetail) {
		this.fileDetail = fileDetail;
	}

}
