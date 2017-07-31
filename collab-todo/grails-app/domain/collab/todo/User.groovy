package collab.todo

class User {

	String userName
	String firstName
	String lastName
	Address address
	
	static hasMany = [todos: Todo, categories: Category]
	
    static constraints = {
		userName(blank:false, unique:true)
		firstName(blank:false)
		lastName(blank:false)
		address(required:false)
    }
	
	String toString() {
		"$lastName, $firstName"
	}
}
