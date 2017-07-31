package collab.todo

import grails.converters.*
import grails.persistence.Event

class AddressController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	static scaffold = Address

	def updateCurrent() {
		Address currentInstance = session.currentAddress
		if (!currentInstance.isAttached() && currentInstance.getId() != null) {
			currentInstance.attach()
		}
		
		populateParams(currentInstance, params)
		
		render(template:"response", model:[serverResponse:'Successful'])
	}
	
	def editCurrent() {
		println Event.allEvents.toList()
		
		Address currentInstance = session.currentAddress
		render(template:"edit", model:[addressInstance:currentInstance])
	}
	
	private void populateParams(Object instance, Map params) {
		instance.properties = params
	}
}
