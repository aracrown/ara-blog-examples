package org.aracrown.blog.ch01;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.aeonbits.owner.ConfigFactory;

/**
 * Application scope based configuration file producer.
 * 
 * @author vicento.ramos
 *
 */
@ApplicationScoped
public class ApplicationConfigProducer {
	@Produces
	@ApplicationScoped
	public ApplicationConfig produceSportsConfig() {
		return ConfigFactory.create(ApplicationConfig.class);
	}
}
