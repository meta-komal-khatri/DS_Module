package ds_session_4_question_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
	private int id;
	private String name;
	private Map<String,String> address;
	public Employee(int id,String name,Map<String,String> address){
		this.id=id;
		this.setName(name);
		this.address=new LinkedHashMap<String, String>();
		this.address.putAll(address);
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public Map<String, String> getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Map<String, String> address) {
		this.address = address;
	}

}
