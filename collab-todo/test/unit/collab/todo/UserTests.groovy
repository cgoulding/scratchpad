package collab.todo



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    void testSomething() {
       User user = new User();
	   
	   for (Object grouping : user.groupings) {
		   System.out.println("key ${grouping.key}")
		   for (Object value : grouping.value) {
			   System.out.println("value ${value}")
		   }
	   }
    }
}
