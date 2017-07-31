package app.creator.gwt.server;

import org.apache.commons.lang.StringUtils;

import junit.framework.TestCase;

public class TransformerUtilsTest extends TestCase {

	public void setUp() throws Exception {
		
	}
	
	public void testToCamelCaseLowerFirst() {
		assertEquals(null, TransformerUtils.toCamelCaseLowerFirst(null));
		assertEquals("", TransformerUtils.toCamelCaseLowerFirst(""));
		assertEquals("asdf", TransformerUtils.toCamelCaseLowerFirst("asdf"));
		assertEquals("asdfAsdf", TransformerUtils.toCamelCaseLowerFirst("asdf asdf"));
		assertEquals("asdfAsdf", TransformerUtils.toCamelCaseLowerFirst("asdf Asdf"));
		assertEquals("asdfAsdf", TransformerUtils.toCamelCaseLowerFirst("Asdf Asdf"));
	}
	
	public void testToCamelCaseUpperFirst() {
		assertEquals(null, TransformerUtils.toCamelCaseUpperFirst(null));
		assertEquals("", TransformerUtils.toCamelCaseUpperFirst(""));
		assertEquals("Asdf", TransformerUtils.toCamelCaseUpperFirst("asdf"));
		assertEquals("AsdfAsdf", TransformerUtils.toCamelCaseUpperFirst("asdf asdf"));
		assertEquals("AsdfAsdf", TransformerUtils.toCamelCaseUpperFirst("asdf Asdf"));
		assertEquals("AsdfAsdf", TransformerUtils.toCamelCaseUpperFirst("Asdf Asdf"));
	}
	
	public void testRandomStringx() {
		String random = TransformerUtils.randomString(20);
		assertEquals(20, random.length());
		assertTrue(StringUtils.isAlpha(random));
	}
	
	public void testRandomString() {
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
		assertTrue(StringUtils.isAlpha(TransformerUtils.randomString()));
	}
}
