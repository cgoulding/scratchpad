package collab.todo

class Address {

	Integer houseNumber;
	String addressLine1
	String addressLine2
	String town
	String county
	User user
	
	static belongsTo = [User]	
}
