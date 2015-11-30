package io.vytas.blog;

import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import io.vytas.blog.dao.BlogEntryDao;

@Path("/resources/")
public class ImageResource {

	@Inject
	private BlogEntryDao blogEntryDao;

	@GET
	@Path("/image/{img}.img")
	@Produces({ "image/*" })
	public StreamingOutput getImage(@PathParam("img") String imagePath) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(imagePath), "Blog post path is empty. Image cannot be retrieved.");
		byte[] img = blogEntryDao.getImage(imagePath);

		return new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				output.write(img);
				output.flush();
			}

		};
	}
}
