package app.creator.file

import java.nio.file.Files
import java.nio.file.Path


class ShellCopier {
	
	Path copyPackageShell() {
		copy('package-shell')
	}
	
	Path copyAppShell() {
		copy('app-shell')
	}
	
	Path copy(String dir) {
		Path destination = Files.createTempDirectory(dir)
		URL resourceDir = this.class.getClassLoader().getResource('app-creator-resources/' + dir)
		FileUtility.copyFolder resourceDir.file, destination.toString()
		destination
	}
}