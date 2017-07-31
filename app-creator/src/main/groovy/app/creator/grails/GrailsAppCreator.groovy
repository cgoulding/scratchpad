package app.creator.grails

import static app.creator.file.FileUtility.*

import java.nio.file.Path

import app.creator.file.ShellCopier

class GrailsAppCreator {

	List<GrailsAppObject> grailsAppObjects = []

	Path generate() {
		Path destination = new ShellCopier().copyAppShell()
		grailsAppObjects.each {
			String actualPath = getPathString(destination.toString(), it.getRelativePath())
			createFile(actualPath, it.fileName + it.extension, it.createContent())
		}
		destination
	}

	File buildWar(Path destination) {
		def warProcess = new ProcessBuilder("cmd", "/c", "grails", "prod", "war")
				.directory(new File(destination.toString()))
				.redirectErrorStream(true)
				.start()

		warProcess.inputStream.eachLine {
			println it
		}

		warProcess.waitFor()

		def war = null

		def targetDir = new File(destination.toString() + "/target")
		targetDir.eachFileMatch(~/.*\.war/) { file ->
			war = file
		}

		war
	}

	File buildSchema(Path destination) {
		def schemaProcess = new ProcessBuilder("cmd", "/c", "grails", "prod", "schema-export", "generate")
				.directory(new File(destination.toString()))
				.redirectErrorStream(true)
				.start()

		schemaProcess.inputStream.eachLine {
			println it
		}

		schemaProcess.waitFor()

		def schema = null

		def targetDir = new File(destination.toString() + "/target")
		targetDir.eachFileMatch(~/.*\.sql/) { file ->
			schema = file
		}

		schema
	}

}
