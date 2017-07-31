package collab.todo

class BuddyList {

	String description
	String name
	User user
	
	static belongsTo = [User]
	
	static hasMany = [members: BuddyListMember]
	
    String toString() {
		name
	}
}
