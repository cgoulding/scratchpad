package collab.todo

class Child {

	String firstName
	Parent parent
	
	static constraints = {
		parent(nullable: true)
	}

}
