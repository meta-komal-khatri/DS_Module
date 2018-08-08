package ds_session_4_question_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedHashSetEmployeeTest {

	@Test
	public void test() {
		CollectionOfEmployee employee=new CollectionOfEmployee();
		employee.addEmployee(1,"Komal", "23", "asd", "kdscity");
		employee.addEmployee(2,"Komal", "23", "asd", "kdscity");
		employee.getEmployeeList();
		for(Employee emp:employee.getEmployeeList()){
			System.out.print(emp.getName());
		}
	}

}
