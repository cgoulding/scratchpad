package app.creator.pckg

import static app.creator.file.FileUtility.*

import java.nio.file.Path

import app.creator.file.ShellCopier

class PackageCreator {

	List<PackageObject> packageObjects = []

	Path generate(File war) {
		Path destination = new ShellCopier().copyPackageShell()
		
		copyFile(war, getPathString(destination.toString(), "webapps"))
		
		packageObjects.each {
			String actualPath = getPathString(destination.toString(), it.getRelativePath())
			createFile(actualPath, it.fileName + it.extension, it.createContent())
		}
		
		destination
	}

	File compress(Path destination, String toName) {
		compressFolder(destination, toName)
	}

}
