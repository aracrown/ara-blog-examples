package io.vytas.blog;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import io.vytas.blog.mvc.controllers.BlogController;
import io.vytas.blog.resources.ImageResource;

/**
 * Sample blog application.
 * 
 * @author vytas.io
 *
 */
@ApplicationPath("/blog")
public class BlogApplication extends javax.ws.rs.core.Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<Class<?>>();

		// Add resources.
		resources.add(BlogController.class);
		resources.add(ImageResource.class);

		// Add additional features such as support for Multipart.
		resources.add(MultiPartFeature.class);

		return resources;
	}
}
