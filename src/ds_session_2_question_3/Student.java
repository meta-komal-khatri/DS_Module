package ds_session_2_question_3;

import java.util.List;

public class Student {
	String name;
	List<String> preferences;
	/**
	 * @param name
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
