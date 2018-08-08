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
	public CollectionOfEmployee() {
		setEmployeeList(new LinkedList<Employee>());
	}
	public void addEmployee(int id,String name,String houseNo,String street,String city){
		if(employeeIdSet.contains(id)){
			System.out.println("duplicate");
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
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public List<Employee> sortEmployeeCollectionByName(){
		SortByEmployeeName sortByEmployeeName=new SortByEmployeeName();
		Collections.sort(employeeList, sortByEmployeeName);
		return employeeList;
	}
	public List<Employee> sortEmployeeCollectionById(){
		SortByEmployeeId sortByEmployeeId=new SortByEmployeeId();
		Collections.sort(employeeList, sortByEmployeeId);
		return employeeList;
	}
	
}
