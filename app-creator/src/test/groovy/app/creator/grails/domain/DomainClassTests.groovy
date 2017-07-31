package app.creator.grails.domain

import org.junit.Test

import app.creator.grails.ClassProperty

class DomainClassTests extends GroovyTestCase {

	public void testCreateContent() {		
		DomainClass creator = new DomainClass(
			domainPackage: "xyz", 
			domainClass: "User", 
			properties: [
				new ClassProperty(type: 'String', name: 'firstName'),
				new ClassProperty(type: 'String', name: 'lastName')
			],
			hasOne: [
				new ClassProperty(type: 'Contact', name: 'contact'),
				new ClassProperty(type: 'Address', name: 'address')
			],
			hasMany: [
				new ClassProperty(type: 'BuddyListMember', name: 'members')
			],
			belongsTo: [
				'Owner1', 'Owner2'
			]
		)
		println creator.createContent()
	}
	
}
