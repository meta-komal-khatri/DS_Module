package ds_session_4_question_1;

import java.util.Comparator;

public class SortByEmployeeId implements Comparator<Employee> {

	/**
	 * compare employee Id
	 */
	public int compare(Employee employee1, Employee employee2) {
		int employeeId1= employee1.getId();
		int employeeId2 = employee2.getId();

		//ascending order
		return employeeId1-employeeId2;
	}
}
