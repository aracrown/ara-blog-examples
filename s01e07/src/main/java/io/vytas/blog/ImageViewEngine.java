package io.vytas.blog;

import java.io.IOException;

import javax.annotation.Priority;
import javax.mvc.engine.Priorities;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ozark.engine.ViewEngineBase;

/**
 * Custom {@link ViewEngine} to display dynamic images from database using REST style.
 * 
 * @author vytas.io
 *
 */
@Priority(Priorities.DEFAULT)
public class ImageViewEngine extends ViewEngineBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageViewEngine.class);
	
	private static final String IMG_SUFFIX = ".img";
	
	private static final String IMAGE_KEY = "image";

	@Override
	public boolean supports(String view) {
		return view.endsWith(IMG_SUFFIX);
	}

	@Override
	public void processView(ViewEngineContext context) throws ViewEngineException {
		final HttpServletResponse response = context.getResponse();
		byte[] image_data = (byte[]) context.getModels().get(IMAGE_KEY);
		if (image_data == null) {
			//nothing to process.
			return;
		}
		context.getModels().remove(IMAGE_KEY);
		try {
			response.getOutputStream().write(image_data);
		} catch (IOException e1) {
			LOGGER.error("Error occured while writing image to outputstream.", e1);
		}
	}
}
