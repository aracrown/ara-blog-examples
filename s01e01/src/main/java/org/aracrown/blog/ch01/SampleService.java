package org.aracrown.blog.ch01;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Sample injection point of properties.
 * 
 * @author vicento.ramos
 *
 */
@Named
public class SampleService {
	@Inject
	private ApplicationConfig applicationConfig;
	
	public void method() {
		System.out.println(String.format("Config value: %d", applicationConfig.getInitialTimeout()));
	}
}
