package app.creator.gwt.server;

import java.io.File;
import java.nio.file.Path;

import junit.framework.TestCase;
import app.creator.grails.GrailsAppCreator;
import app.creator.gwt.model.Application;
import app.creator.gwt.model.Attributes;
import app.creator.gwt.model.Entity;
import app.creator.gwt.model.EntityList;
import app.creator.gwt.model.Field;

public class ApplicationToCreatorTransformerTest extends TestCase {

	ApplicationToCreatorTransformer transformer;
	
	public void setUp() throws Exception {
		transformer = new ApplicationToCreatorTransformer();
	}
	
	public void testTransform() {
		Field field1 = new Field();
		field1.setName("Field1");
		field1.setAttributes(new Attributes());
		
		Entity entity1 = new Entity();
		entity1.setName("Entity1");
		entity1.add(field1);
		
		Field field2 = new Field();
		field2.setName("Field2");
		field2.setAttributes(new Attributes());
		
		Field field3 = new Field();
		field3.setName("Field3");
		field3.setAttributes(new Attributes());
		
		EntityList entityList = new EntityList();
		entityList.setName("EntityList1");
		entityList.add(field3);
		
		Entity entity2 = new Entity();
		entity2.setName("Entity2");
		entity2.add(field2);
		entity2.add(entityList);
		
		Application application = new Application();
		application.setName("Application1");
		application.add(entity1);
		application.add(entity2);
		
		GrailsAppCreator creator = transformer.transform(application);
		assertNotNull(creator);
		
		Path generated = creator.generate();
		assertNotNull(generated);
		
		File war = creator.buildWar(generated);
		assertNotNull(war);
	}
}
