package org.aracrown.blog.ch01;

import javax.inject.Named;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;

/**
 * Application configuration properties are defined here.
 * 
 * @author vicento.ramos
 *
 */
@HotReload
@Sources({ "file:/etc/my-app.properties", "file:~/.my-app.properties", "classpath:/my-app.properties" })
@Named("applicationConfig")
public interface ApplicationConfig extends Accessible {
	@DefaultValue("50")
	@Key("app.timeout")
	int getInitialTimeout();
}
