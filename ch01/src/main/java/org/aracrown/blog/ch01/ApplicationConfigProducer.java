package org.aracrown.blog.ch01;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.aeonbits.owner.ConfigFactory;

@ApplicationScoped
public class ApplicationConfigProducer {
	@Produces
	@ApplicationScoped
	public ApplicationConfig produceSportsConfig() {
		return ConfigFactory.create(ApplicationConfig.class);
	}
}
