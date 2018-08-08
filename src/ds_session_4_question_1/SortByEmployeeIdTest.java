package ds_session_4_question_1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SortByEmployeeIdTest {

	@Test
	public void test() {
		CollectionOfEmployee collectionOfEmployee=new CollectionOfEmployee();
		collectionOfEmployee.addEmployee(1,"Komal", "23", "asd", "kdscity");
		collectionOfEmployee.addEmployee(3,"Ram", "12", "ghj", "srigan");
		collectionOfEmployee.addEmployee(7,"Akshita", "23", "asd", "scity");
		collectionOfEmployee.addEmployee(8,"Shubham", "2e", "asd1", "wwkdscity");
		collectionOfEmployee.addEmployee(2,"Surbhi", "23", "asd", "kdscity");
		List<Employee> employeeList=collectionOfEmployee.sortEmployeeCollectionById();
		List<String> nameOfEmployees=new LinkedList<String>
		(Arrays.asList("Komal","Surbhi","Ram","Akshita","Shubham"));
		
		for(int i=0;i<employeeList.size();i++){
			assertEquals(nameOfEmployees.get(i),employeeList.get(i).getName());
		}
	}

}
