package ie.cganalytics.clubadmin.model.database;

import java.util.List;
import java.util.Properties;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class AnnotatedInMemoryDatabase implements Database {

	private Properties properties;
	private List<String> annotatedClasses;
	private Created created = new Created(false);
	
	public void create() {
		synchronized (created) {
			if (!created.created) {
				AnnotationConfiguration configuration = new AnnotationConfiguration();
				configuration.setProperties(properties); 

				for (String annotatedClass : annotatedClasses) {
					try {
						configuration.addAnnotatedClass(Class.forName(annotatedClass));
					} catch (Exception e) {
						throw new RuntimeException("Failed to load class " + annotatedClass, e);
					}
				}

				SchemaExport export = new SchemaExport(configuration);
				export.setOutputFile("sql.ddl");
				export.setDelimiter(";");		
				export.create(false, true);
				
				created.created = true;
			}
		}
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void setAnnotatedClasses(List<String> annotatedClasses) {
		this.annotatedClasses = annotatedClasses;
	}
	
	private static class Created {
		boolean created = false;
		Created(boolean created) {
			this.created = created;
		}
	}
}
