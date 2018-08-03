package ds_session_2_que3;

import java.util.List;

public class Student {
	String name;
	List<String> preferences;
	/**
	 * @param name
	 * @param firstPreference
	 * @param secondPreference
	 * @param thirdPreference
	 * @param forthPreference
	 * @param fifthPreference
	 */
	public Student(String name,List<String> preferences) {
		this.name=name;
		this.preferences=preferences;
	}
	public String getName() {
		return name;
	}
	public List<String> getPrefernce(){
		return preferences;
	}
}
