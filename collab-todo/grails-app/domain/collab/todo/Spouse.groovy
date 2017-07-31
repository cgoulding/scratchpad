package collab.todo

class Spouse {

	String firstName
	String lastName
	Parent parent
	
	static belongsTo = [Parent]
	
	static constraints = {
		parent(nullable: true)
	}
}
