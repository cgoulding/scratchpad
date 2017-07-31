package ie.cganalytics.common;

import junit.framework.TestCase;

public class DtoProxyTest extends TestCase {

	public void setUp() throws Exception {
		
	}
	
	public void testGetterSetter() {
		Person person = DtoProxy.create(Person.class);
		
		person.setFirstName("Connor");
		assertEquals("Connor", person.getFirstName());
		
		person.setFirstName(null);
		assertEquals(null, person.getFirstName());
		
		person.setLastName("Goulding");
		assertEquals("Goulding", person.getLastName());
		
		person.setLastName(null);
		assertEquals(null, person.getLastName());
	}
	
	public void testSerialization() {
		Person person = DtoProxy.create(Person.class);
		
		person.setFirstName("Connor");
		
		System.out.println(person.getFirstName());
		
		Serializer serializer = new Serializer();
		
		serializer.serializeOut(person);
		Person samePerson = (Person)serializer.serializeIn();
		
		System.out.println(samePerson.getFirstName());
	}
}
