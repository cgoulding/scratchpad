package app.creator.pckg

import java.nio.file.Path

import org.junit.*

import app.creator.grails.ClassProperty
import app.creator.grails.GrailsAppCreator
import app.creator.grails.controller.ControllerClass
import app.creator.grails.domain.DomainClass
import app.creator.pckg.launch.LaunchBat

class PackageCreatorTests extends GroovyTestCase {

    void testCreate() {
		File war = new File("resources/test/test.war")
		
		LaunchBat launchBat = new LaunchBat(
			appWarFile : "test.war",
			appContext : "testcontext",
			appServerPort : 9999,
			appServerThreadsMin : 9,
			appServerThreadsMax : 99
		)
		
		PackageCreator packageCreator = new PackageCreator()
		packageCreator.packageObjects << launchBat
		
		Path pckg = packageCreator.generate(war);
		println "Created package in " + pckg.toString()
		
		File compressed = packageCreator.compress(pckg, war.name);
		println "Compressed package in " + compressed.absolutePath
    }
}
