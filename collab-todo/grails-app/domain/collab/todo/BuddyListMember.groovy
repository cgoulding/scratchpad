package collab.todo

class BuddyListMember {

    String nickName
	User user
	BuddyList buddyList
	
	static belongsTo = [BuddyList]
	
	String toString() {
		nickName
	}
}
