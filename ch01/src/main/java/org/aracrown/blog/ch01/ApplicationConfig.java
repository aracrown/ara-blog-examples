package org.aracrown.blog.ch01;

import javax.inject.Named;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;

@HotReload
@Sources({ "file:/etc/taxes/taxes.properties","file:~/.taxes.properties", "classpath:/taxes.properties" })
@Named("applicationConfig")
public interface ApplicationConfig extends Accessible{
	int getInitialTimeout();
}
