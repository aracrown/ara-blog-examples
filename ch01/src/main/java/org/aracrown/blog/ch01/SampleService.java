package org.aracrown.blog.ch01;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SampleService {
	@Inject
	private ApplicationConfig applicationConfig;
	
	public void method() {
		System.out.println(String.format("Config value: %d", applicationConfig.getInitialTimeout()));
	}
}
