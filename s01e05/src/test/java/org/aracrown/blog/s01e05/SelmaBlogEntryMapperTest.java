package org.aracrown.blog.s01e05;

import org.junit.Test;

import fr.xebia.extras.selma.Selma;

public class SelmaBlogEntryMapperTest {

	@Test
	public void testSelmaMapper () throws Exception {
		SelmaBlogEntryMapper mapper = Selma.builder(SelmaBlogEntryMapper.class).build();
		mapper.asBlogEntryResource(null);
		
	}
}
