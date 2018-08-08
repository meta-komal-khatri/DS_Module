package ds_session_4_question_1;

import java.util.Comparator;


public class SortByEmployeeName implements Comparator<Employee> {

	/**
	 * method to compare employee id
	 */
	public int compare(Employee employee1, Employee employee2) {
		String employeeName1= employee1.getName().toUpperCase();
		String employeeName2 = employee2.getName().toUpperCase();

		//ascending order
		return employeeName1.compareTo(employeeName2);
	}



}
