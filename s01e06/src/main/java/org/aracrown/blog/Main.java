package org.aracrown.blog;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jpa.JPAFraction;
import org.wildfly.swarm.undertow.WARArchive;

import io.vytas.blog.s01e04.beans.BlogEntryBean;
import io.vytas.blog.s01e04.dao.BlogEntryDao;
import io.vytas.blog.s01e04.model.BlogEntry;
import io.vytas.blog.s01e04.query.BlogEntryQueryImpl;

public class Main {
	public static void main(String[] args) throws Exception {
		Container container = new Container();

		container.fraction(new DatasourcesFraction().jdbcDriver("h2", (d) -> {
			d.driverDatasourceClassName("org.h2.Driver");
			d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
			d.driverModuleName("com.h2database.h2");
		}).dataSource("ExampleDS", (ds) -> {
			ds.driverName("h2");
			ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
			ds.userName("sa");
			ds.password("sa");
		}));

		container.fraction(new JPAFraction().inhibitDefaultDatasource().defaultDatasource("jboss/datasources/ExampleDS"));

		container.start();

		WARArchive deployment = ShrinkWrap.create(WARArchive.class);
		deployment.addClasses(BlogEntryDao.class, BlogEntryQueryImpl.class, BlogEntry.class);
		deployment.addPackage(BlogEntryBean.class.getPackage());
		deployment.addAllDependencies();

		deployment.addAsWebResource(new ClassLoaderAsset("index.xhtml", Main.class.getClassLoader()), "index.xhtml");

		deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()),
				"classes/META-INF/persistence.xml");
		deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/load.sql", Main.class.getClassLoader()), "classes/META-INF/load.sql");
		deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/beans.xml", Main.class.getClassLoader()), "classes/META-INF/beans.xml");

		container.deploy(deployment);
	}
}
