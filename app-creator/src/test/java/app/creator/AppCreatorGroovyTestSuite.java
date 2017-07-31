package app.creator;

import groovy.util.GroovyTestSuite;
import junit.framework.TestSuite;

public abstract class AppCreatorGroovyTestSuite extends TestSuite {
	
	protected static final String TEST_ROOT = "src/test/groovy";
	protected static final String SRC_ROOT = "src/main/groovy";
		
	public static GroovyTestSuite createBaseSuite() throws Exception {
		GroovyTestSuite gsuite = new GroovyTestSuite();
		gsuite.compile(SRC_ROOT + "/app/creator/file/FileUtility.groovy");
		gsuite.compile(SRC_ROOT + "/app/creator/file/ShellCopier.groovy");
		return gsuite;
	}
	
	public static Class compile(GroovyTestSuite suite, String groovyFile) throws Exception {
		return suite.compile(groovyFile);
	}
}
