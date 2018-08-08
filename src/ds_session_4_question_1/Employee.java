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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddres(Map<String,String> address){
		this.address.putAll(address);
	}
	public Map<String,String> getAddress(){
		return address;
	}
}
