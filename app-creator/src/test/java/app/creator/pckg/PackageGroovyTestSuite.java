package app.creator.pckg;

import groovy.util.GroovyTestSuite;
import junit.framework.TestSuite;
import app.creator.AppCreatorGroovyTestSuite;

public class PackageGroovyTestSuite extends AppCreatorGroovyTestSuite {

	public static TestSuite suite() throws Exception {
		GroovyTestSuite gsuite = createBaseSuite();
		compile(gsuite, SRC_ROOT + "/app/creator/pckg/PackageObject.groovy");
		compile(gsuite, SRC_ROOT + "/app/creator/pckg/launch/LaunchBat.groovy");
		compile(gsuite, SRC_ROOT + "/app/creator/pckg/PackageCreator.groovy");
		
		TestSuite suite = new TestSuite();
		suite.addTestSuite(compile(gsuite, TEST_ROOT + "/app/creator/pckg/PackageCreatorTests.groovy"));
		
		return suite;
	}
	
}
