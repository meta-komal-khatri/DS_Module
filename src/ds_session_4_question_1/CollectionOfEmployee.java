package ds_session_4_question_1;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionOfEmployee {
	private List<Employee> employeeList;
	Set<Integer> employeeIdSet=new LinkedHashSet<Integer>();
	
	//initialize list of employees
	public CollectionOfEmployee() {
		setEmployeeList(new LinkedList<Employee>());
	}
	
	/**
	 * validate that all fields are filled
	 * @param id
	 * @param name
	 * @param houseNo
	 * @param street
	 * @param city
	 */
	private void validate(int id,String name,String houseNo,String street,String city) {
		if(id==0 || name.length()==0 || houseNo.length()==0 || street.length()==0 || city.length()==0) {
			throw new AssertionError("All fields are required");
		}
	}
	
	/**
	 * add new employee to list of employee
	 * @param id is an integer and should be unique
	 * @param name name of employee
	 * @param houseNo
	 * @param street
	 * @param city
	 */
	public void addEmployee(int id,String name,String houseNo,String street,String city){
		validate(id, name, houseNo, street, city);
		//if given Id exist ,It throws an error
		if(employeeIdSet.contains(id)){
			throw new AssertionError("Emplpoyee already exist");
		}
		else{
			employeeIdSet.add(id);
			Map<String,String> address=new LinkedHashMap<String,String>();
			address.put("Home", houseNo);
			address.put("Street", street);
			address.put("City",city);
			employeeList.add(new Employee(id,name, address));
		}
	}
	
	/**
	 * @return list of employee
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	/**
	 * an employee list is passed as argument
	 * @param employeeList
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	/**
	 * sort employee list in ascending order according to employee name 
	 * @return sorted list of employees
	 */
	public List<Employee> sortEmployeeCollectionByName(){
		SortByEmployeeName sortByEmployeeName=new SortByEmployeeName();
		Collections.sort(employeeList, sortByEmployeeName);
		return employeeList;
	}
	
	/**
	 * sort employee list in ascending order according to their employeeId
	 * @return sorted list of employees
	 */
	public List<Employee> sortEmployeeCollectionById(){
		SortByEmployeeId sortByEmployeeId=new SortByEmployeeId();
		Collections.sort(employeeList, sortByEmployeeId);
		return employeeList;
	}
	
}
