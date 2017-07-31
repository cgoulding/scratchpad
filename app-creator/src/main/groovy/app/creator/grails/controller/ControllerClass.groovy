package app.creator.grails.controller

import groovy.text.SimpleTemplateEngine
import app.creator.file.FileUtility
import app.creator.grails.ClassProperty
import app.creator.grails.GrailsAppObject;

class ControllerClass implements GrailsAppObject {

	String controllerPackage
	String controllerClass
	String scaffoldClass
	
	def template = ClassLoader.getSystemClassLoader().getResource("templates/controllerClass.gtpl");
	def engine = new SimpleTemplateEngine()
	
	String createContent() {
		def binding = [
			"controllerPackage" : controllerPackage,
			"controllerClass" : controllerClass,
			"scaffoldClass" : scaffoldClass
		]
			
		def controllerClass = engine.createTemplate(template).make(binding)
		controllerClass.toString()
	}
	
	String getRelativePath() {
		FileUtility.getPathString(getGrailsFolder(), FileUtility.getPathStringFromPackage(controllerPackage))
	}
	
	String getFileName() {
		controllerClass
	}
	
	String getExtension() {
		FileUtility.GROOVY_EXTENSION
	}
	
	String getGrailsFolder() {
		"grails-app/controllers"
	}
}
