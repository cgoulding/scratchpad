package app.creator.grails;

import groovy.util.GroovyTestSuite;
import junit.framework.TestSuite;
import app.creator.AppCreatorGroovyTestSuite;

public class GrailsGroovyTestSuite extends AppCreatorGroovyTestSuite {

	public static TestSuite suite() throws Exception {
		GroovyTestSuite gsuite = createBaseSuite();
		compile(gsuite, SRC_ROOT + "/app/creator/grails/ClassProperty.groovy");
		compile(gsuite, SRC_ROOT + "/app/creator/grails/GrailsAppObject.groovy");
		compile(gsuite, SRC_ROOT + "/app/creator/grails/controller/ControllerClass.groovy");
		compile(gsuite, SRC_ROOT + "/app/creator/grails/domain/DomainClass.groovy");
		compile(gsuite, SRC_ROOT + "/app/creator/grails/GrailsAppCreator.groovy");
		
		TestSuite suite = new TestSuite();
		suite.addTestSuite(compile(gsuite, TEST_ROOT + "/app/creator/grails/GrailsAppCreatorTests.groovy"));
		suite.addTestSuite(compile(gsuite, TEST_ROOT + "/app/creator/grails/controller/ControllerClassTests.groovy"));
		suite.addTestSuite(compile(gsuite, TEST_ROOT + "/app/creator/grails/domain/DomainClassTests.groovy"));
		
		return suite;
	}
	
}
