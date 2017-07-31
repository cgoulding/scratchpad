package app.creator.grails.domain

import groovy.text.SimpleTemplateEngine
import app.creator.file.FileUtility
import app.creator.grails.ClassProperty
import app.creator.grails.GrailsAppObject

class DomainClass implements GrailsAppObject {

	String domainPackage
	String domainClass
	List<ClassProperty> properties
	List<ClassProperty> hasOne
	List<ClassProperty> hasMany
	List<String> belongsTo 
	
	def template = ClassLoader.getSystemClassLoader().getResource("templates/domainClass.gtpl");
	def engine = new SimpleTemplateEngine()
	
	String createContent() {
		def binding = [
			"domainPackage" : domainPackage,
			"domainClass" : domainClass,
			"properties" : properties,
			"hasOne" : hasOne,
			"hasMany" : hasMany,
			"belongsTo" : belongsTo		
		]
			
		println "Template: " + template
		def domainClass = engine.createTemplate(template).make(binding)
		domainClass.toString()
	}
	
	String getRelativePath() {
		FileUtility.getPathString(getGrailsFolder(), FileUtility.getPathStringFromPackage(domainPackage))	
	}
	
	String getFileName() {
		domainClass
	}
	
	String getExtension() {
		FileUtility.GROOVY_EXTENSION
	}
	
	String getGrailsFolder() {
		"grails-app/domain"
	}
}