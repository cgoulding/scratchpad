package collab.todo

import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	static scaffold = User

	def editPropertyAddress() {
		def currentUser = session.currentUser
		
		if (!currentUser.isAttached() && currentUser.getId() != null) {
			currentUser.attach()
		}
		
		populateParams(currentUser, params)
		
		Address address = currentUser.getAddress()
		if (address == null) {
			address = new Address()
			address.setUser(currentUser)
			currentUser.setAddress(address)
		}
		session.currentAddress = address
		
		redirect(controller: "address", action: "editCurrent")
	}
	
    def create() {
		def currentUser = new User(params);
		session.currentUser = currentUser
        [userInstance: currentUser]
    }
	
    def save() {
        def userInstance = session.currentUser
		populateParams(userInstance, params)
		
		if (!userInstance.isAttached() && userInstance.getId() != null) {
			userInstance.attach()
		}
		
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }
		session.currentUser = userInstance
        [userInstance: userInstance]
    }

    def edit(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

		session.currentUser = userInstance
        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
        def userInstance = session.currentUser
		
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }
		
		if (!userInstance.isAttached() && userInstance.getId() != null) {
			println "attaching"
			userInstance.attach()
		}
		
		populateParams(userInstance, params)
			
        if (!userInstance.merge(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }
	
	private void populateParams(Object instance, Map params) {
		instance.properties = params
	}
}
