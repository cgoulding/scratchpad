package app.creator.gwt.server;

import static app.creator.gwt.server.TransformerUtils.toCamelCaseLowerFirst;
import static app.creator.gwt.server.TransformerUtils.toCamelCaseUpperFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import app.creator.grails.ClassProperty;
import app.creator.grails.GrailsAppCreator;
import app.creator.grails.GrailsAppObject;
import app.creator.grails.controller.ControllerClass;
import app.creator.grails.domain.DomainClass;
import app.creator.gwt.model.Application;
import app.creator.gwt.model.Entity;
import app.creator.gwt.model.EntityList;
import app.creator.gwt.model.Field;
import app.creator.gwt.model.Part;

public class ApplicationToCreatorTransformer {

	private List<GrailsAppObject> objects;
	private String pckg;
	
	public ApplicationToCreatorTransformer() {
		pckg = TransformerUtils.randomString();
		objects = new ArrayList<GrailsAppObject>();
	}
	
	public GrailsAppCreator transform(Application application) {
		if (application.getParts() != null) {
			for (Part part : application.getParts()) {
				if (part instanceof Entity) {
					processEntity(null, (Entity)part);
				} else {
					//should not happen
				}
			}
		}
		
		GrailsAppCreator creator = new GrailsAppCreator();
		creator.setGrailsAppObjects(objects);
		return creator;
	}
	
	private void processPart(DomainClass domainClass, Part part) {
		if (part instanceof EntityList) {
			processEntityList(domainClass, (EntityList)part);
		} else if (part instanceof Entity) {
			processEntity(domainClass, (Entity)part);
		} else if (part instanceof Field) {
			processField(domainClass, (Field)part);
		} else {
			//should not happen
		}
	}
	
	private void processField(DomainClass domainClass, Field field) {
		ClassProperty property = new ClassProperty();
		property.setName(toCamelCaseLowerFirst(field.getName()));
		property.setType(transformDefaultType(field));
		domainClass.getProperties().add(property);
	}
	
	private void processEntity(DomainClass parentClass, Entity entity) {
		DomainClass domainClass = createDomainClass(entity);
		
		if (parentClass != null) {
			setupEntityRelationship(parentClass, domainClass);
		}
		
		objects.add(domainClass);
		
		ControllerClass controllerClass = createControllerClass(domainClass);
		objects.add(controllerClass);
	}

	private void processEntityList(DomainClass parentClass, EntityList entityList) {
		DomainClass domainClass = createDomainClass(entityList);
		
		if (parentClass != null) {
			setupEntityListRelationship(parentClass, domainClass);
		}
		
		objects.add(domainClass);
		
		ControllerClass controllerClass = createControllerClass(domainClass);
		objects.add(controllerClass);
	}
	
	private DomainClass createDomainClass(Entity entity) {
		DomainClass domainClass = new DomainClass();
		domainClass.setDomainPackage(pckg);
		domainClass.setDomainClass(toCamelCaseUpperFirst(entity.getName()));
		domainClass.setProperties(new ArrayList<ClassProperty>());
		domainClass.setHasMany(new ArrayList<ClassProperty>());
		domainClass.setHasOne(new ArrayList<ClassProperty>());
		domainClass.setBelongsTo(new ArrayList<String>());
		
		if (entity.getParts() != null) {
			for (Part part : entity.getParts()) {
				processPart(domainClass, part);
			}
		}
		return domainClass;
	}
	
	private ControllerClass createControllerClass(DomainClass domainClass) {
		ControllerClass controllerClass = new ControllerClass();
		controllerClass.setControllerPackage(domainClass.getDomainPackage());
		controllerClass.setControllerClass(domainClass.getDomainClass() + "Controller");
		controllerClass.setScaffoldClass(domainClass.getDomainClass());
		return controllerClass;
	}
	
	private void setupEntityRelationship(DomainClass parentClass,
			DomainClass childClass) {
		ClassProperty parentProperty = createProperty(parentClass);	
		childClass.getProperties().add(parentProperty);
		childClass.getBelongsTo().add(parentProperty.getType());
		
		ClassProperty childProperty = createProperty(childClass);
		parentClass.getHasOne().add(childProperty);
	}
	
	private void setupEntityListRelationship(DomainClass parentClass,
			DomainClass childClass) {
		ClassProperty parentProperty = createProperty(parentClass);	
		childClass.getProperties().add(parentProperty);
		childClass.getBelongsTo().add(parentProperty.getType());
		
		ClassProperty childProperty = createProperty(childClass);
		parentClass.getHasMany().add(childProperty);
	}

	private ClassProperty createProperty(DomainClass domainClass) {
		ClassProperty property = new ClassProperty();
		property.setName(toCamelCaseLowerFirst(domainClass.getDomainClass()));
		property.setType(domainClass.getDomainClass());
		return property;
	}
	
	private String transformDefaultType(Field field) {
		List<String> bits = Arrays.asList(field.getName().toUpperCase().split(" "));
		if (bits.contains("DATE")) {
			return Date.class.getName();
		} else if (bits.contains("NUMBER")) {
			return Integer.class.getName();
		} else {
			return String.class.getName();
		}
	}
}
