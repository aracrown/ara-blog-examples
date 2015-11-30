package io.vytas.blog.mvc.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import io.vytas.blog.dao.BlogEntryBuilder;
import io.vytas.blog.dao.BlogEntryDao;
import io.vytas.blog.model.BlogEntry;
import io.vytas.blog.mvc.models.BlogEntryBean;
import io.vytas.blog.mvc.models.BlogEntryListBean;
import io.vytas.blog.mvc.request.FileUploadEntryRequest;
import io.vytas.blog.mvc.request.SimpleEntryRequest;

/**
 * Blog entry controller to create new post, retrieve one by path or retrieve post image.
 * 
 * @author vytas.io
 *
 */
@Controller
@Path("/posts/")
public class BlogController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
	
	@Inject
	Models models;

	@Inject
	private BlogEntryBean blogEntryBean;

	@Inject
	private BlogEntryDao blogEntryDao;

	/**
	 * Retrieve all posts. Actual retrieval is used via CDI bean {@link BlogEntryListBean}. Here we just tell the name of template to use.
	 */
	@GET
	@View("/WEB-INF/jsp/posts.jsp")
	public void getBlogEntries() {

	}

	/**
	 * Retrieve entry by path. Actual retrieval is used via CDI bean {@link BlogEntryBean}. Here we just set the path.
	 * 
	 * @param path
	 *            blog entry path as an unique key.
	 * @return template name to be used when rendering the HTML.
	 */
	@GET
	@Path("/{path}/")
	public String getBlogEntry(@PathParam("path") String path) {
		blogEntryBean.setPath(path);
		return "/WEB-INF/jsp/post.jsp";

	}

	/**
	 * Creates new simple blog entry.
	 * 
	 * @param form
	 *            form params, such as title and content
	 */
	@POST
	@View("redirect:/posts/")
	public void newBlogEntry(@BeanParam SimpleEntryRequest form) {
		BlogEntry be = new BlogEntryBuilder().defaultAuthor().title(form.getTitle()).content(form.getContent()).randomPath().build();

		blogEntryDao.save(be);
		
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/upload/")
	public String upload(@BeanParam FileUploadEntryRequest form) {
		Preconditions.checkArgument(form != null, "Request is missing");
		byte[] datainput = null;
		try {
			datainput = org.apache.commons.io.IOUtils.toByteArray(form.getUploadedInputStream());
		} catch (IOException e) {
			LOGGER.error("Could not retrieve image from file upload form.", e);
		}

		BlogEntry be = new BlogEntryBuilder().defaultAuthor().title(form.getTitle()).content(form.getContent()).randomPath().image(datainput).build();

		blogEntryDao.save(be);

		return "redirect:/posts/";
	}

	@GET
	@Path("/image/{img}.img")
	@Produces({ "image/*" })
	public String getImage(@PathParam("img") String imagePath) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(imagePath), "Blog post path is empty. Image cannot be retrieved.");
		byte[] img = blogEntryDao.getImage(imagePath);

		models.put("image", img);
		return "/producer.img";
	}

}
