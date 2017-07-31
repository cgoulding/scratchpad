package app.creator.pckg.launch

import groovy.text.SimpleTemplateEngine
import app.creator.file.FileUtility
import app.creator.pckg.PackageObject

class LaunchBat implements PackageObject {

	String appWarFile
	String appContext
	Integer appServerPort
	Integer appServerThreadsMin
	Integer appServerThreadsMax
	
	def template = ClassLoader.getSystemClassLoader().getResource("templates/launchBat.gtpl");
	def engine = new SimpleTemplateEngine()
	
	String createContent() {
		def binding = [
			"appWarFile" : appWarFile,
			"appContext" : appContext,
			"appServerPort" : appServerPort,
			"appServerThreadsMin" : appServerThreadsMin,
			"appServerThreadsMax" : appServerThreadsMax		
		]
			
		println "Template: " + template
		def launchBat = engine.createTemplate(template).make(binding)
		launchBat.toString()
	}
	
	String getRelativePath() {
		getPackageFolder()	
	}
	
	String getFileName() {
		'launch'
	}
	
	String getExtension() {
		FileUtility.BAT_EXTENSION
	}
	
	String getPackageFolder() {
		"bin"
	}
}