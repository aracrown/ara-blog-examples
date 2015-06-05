package org.aracrown.blog.s01e04;

import org.aracrown.blog.s01e04.dao.BlogEntryDao;
import org.aracrown.blog.s01e04.model.BlogEntry;
import org.aracrown.blog.s01e04.query.BlogEntryQueryImpl;
import org.aracrown.blog.s01e04.resources.BlogEntriesResource;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.Datasource;
import org.wildfly.swarm.datasources.DatasourceDeployment;
import org.wildfly.swarm.datasources.DriverDeployment;
import org.wildfly.swarm.jaxrs.JAXRSDeployment;

public class Main {
	public static void main(String[] args) throws Exception {
		Container container = new Container();
		container.start();

		// Create a JDBC driver deployment using maven groupId:artifactId
		// The version is resolved from your pom.xml's <dependency>
		DriverDeployment driverDeployment = new DriverDeployment(container, "com.h2database:h2", "h2");
		container.deploy(driverDeployment);

		// Create a DS deployment
		DatasourceDeployment dsDeployment = new DatasourceDeployment(container, new Datasource("ExampleDS")
				.connectionURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE").driver("h2").authentication("sa", "sa"));
		container.deploy(dsDeployment);

		JAXRSDeployment deployment = new JAXRSDeployment(container);
		deployment.getArchive().addClasses(BlogEntryDao.class, BlogEntryQueryImpl.class);
		deployment.getArchive().addPackage(BlogEntry.class.getPackage());
		deployment.getArchive().addPackage(BlogEntriesResource.class.getPackage());
		deployment.getArchive().addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()),
				"classes/META-INF/persistence.xml");
		deployment.getArchive().addAsWebInfResource(new ClassLoaderAsset("META-INF/load.sql", Main.class.getClassLoader()),
				"classes/META-INF/load.sql");

		container.deploy(deployment);
	}
}
