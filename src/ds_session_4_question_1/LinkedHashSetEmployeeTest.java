package ds_session_4_question_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedHashSetEmployeeTest {

	/**  
	 * test to check that no duplicate employee is added
	 */
	@Test(expected=AssertionError.class)
	public void test() {
		CollectionOfEmployee employee=new CollectionOfEmployee();
		employee.addEmployee(1,"Komal", "23", "Vasant Vihar", "Jaipur");
		employee.addEmployee(1,"Suhani", "21", "Rani Road", "Udaipur");
		employee.addEmployee(2,"Suhani", "21", "Rani Road", "Udaipur");
		employee.addEmployee(3,"Gautam", "26", "Rani Road", "Udaipur");
		employee.addEmployee(4,"Manish", "26", "Rani Road", "Udaipur");
		
		assertEquals(4,employee.getEmployeeList().size());

	}

}
