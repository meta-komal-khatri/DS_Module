package ds_session_4_question_1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SortByEmployeeNameTest {

	/**
	 * test to check ordering of received list from sortEmployeeByName method
	 */
	@Test
	public void test() {
		CollectionOfEmployee collectionOfEmployee=new CollectionOfEmployee();
		collectionOfEmployee.addEmployee(1,"Komal", "23", "asd", "kdscity");
		collectionOfEmployee.addEmployee(3,"Ram", "12", "ghj", "srigan");
		collectionOfEmployee.addEmployee(7,"Akshita", "23", "asd", "scity");
		collectionOfEmployee.addEmployee(8,"Shubham", "2e", "asd1", "wwkdscity");
		collectionOfEmployee.addEmployee(2,"Surbhi", "23", "asd", "kdscity");
		List<Employee> employeeList=collectionOfEmployee.sortEmployeeCollectionByName();
		List<String> nameOfEmployees=new LinkedList<String>
		(Arrays.asList("Akshita","Komal","Ram","Shubham","Surbhi"));
		
		for(int i=0;i<employeeList.size();i++){
			assertEquals(nameOfEmployees.get(i),employeeList.get(i).getName());
		}
		
		
	}

}
