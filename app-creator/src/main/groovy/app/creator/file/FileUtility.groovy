package app.creator.file

import java.nio.file.Path

import org.apache.commons.lang.StringUtils

class FileUtility {

	static final String SEPERATOR = FileSystem.getFileSystem().getSeparator()
	static final String GROOVY_EXTENSION = '.groovy'
	static final String JAVA_EXTENSION = '.java'
	static final String BAT_EXTENSION = '.bat'
	static final String ZIP_EXTENSION = '.zip'
	
	static File createFile(String path, String fileName, String body) {
		File folder = new File(path)
		if (!folder.exists()) {
			folder.mkdirs()
		}
		
		File file = new File(path + SEPERATOR + fileName)
		file.write(body);
		file
	}
	
	static void copyFile(File source, String destinationFolder) {
		new AntBuilder().copy(
			file:source.absolutePath, 
			tofile:getPathString(destinationFolder, source.getName().toString())
		)
	}
	
	static void copyFolder(String source, String destination) {
		new AntBuilder().copy(todir: destination) {
			println "Destination ${destination}"
			fileset(dir : source) {
				println "Source ${source}"
			}
		}
	}
	
	static File compressFolder(Path source, String destinationName) {
		def zipFile = new File(getPathString(source.toString(), destinationName + ZIP_EXTENSION))
		new AntBuilder().zip( basedir: source.toString(),
							  destFile: zipFile.absolutePath)
		zipFile
	}
	
	static String getPathString(String[] fragments) {
		StringUtils.join(fragments, SEPERATOR)
	}
	
	static String getPathStringFromPackage(String classPackage) {
		classPackage.replaceAll(~'\\.', SEPERATOR)
	}
}
