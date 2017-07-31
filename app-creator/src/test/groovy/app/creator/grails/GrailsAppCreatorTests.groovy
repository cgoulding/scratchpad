package app.creator.grails

import java.nio.file.Path

import org.junit.*

import app.creator.grails.controller.ControllerClass
import app.creator.grails.domain.DomainClass

class GrailsAppCreatorTests extends GroovyTestCase {

    void testCreate() {
		GrailsAppCreator creator = new GrailsAppCreator()
		
		DomainClass domainClass = new DomainClass(
			domainPackage: "xyz",
			domainClass: "User",
			properties: [
				new ClassProperty(type: 'String', name: 'firstName'),
				new ClassProperty(type: 'String', name: 'lastName')
			],
		)
		
		ControllerClass controllerClass = new ControllerClass(
			controllerPackage: "xyz",
			controllerClass: "UserController",
			scaffoldClass: "User"
		)
		
		creator.grailsAppObjects << domainClass
		creator.grailsAppObjects << controllerClass
		
		Path application = creator.generate()
		println "Created application in " + application.toString()
		
		File war = creator.buildWar(application)
		println "Created war " + war.absolutePath 	
    }
}
