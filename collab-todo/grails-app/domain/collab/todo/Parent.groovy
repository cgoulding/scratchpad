package collab.todo

class Parent {

	String firstName;
	String lastName;
	Spouse spouse
	
	static hasMany = [
		children: Child
	]
	
	static constraints = {
		spouse(nullable: true)
	}
}
