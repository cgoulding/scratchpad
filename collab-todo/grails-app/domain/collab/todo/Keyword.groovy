package collab.todo

class Keyword {

    String description
	String name
	
	static belongsTo = Todo
	
	static hasMany = [todos: Todo]
	
	String toString() {
		name
	}
}
