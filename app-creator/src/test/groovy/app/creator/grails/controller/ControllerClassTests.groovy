package app.creator.grails.controller

import org.junit.Test

public class ControllerClassTests extends GroovyTestCase {

	public void testCreateContent() {
		ControllerClass creator = new ControllerClass(
			controllerPackage: "xyz",
			controllerClass: "UserController",
			scaffoldClass: "User"
		)
		println creator.createContent()
	}
	
}
