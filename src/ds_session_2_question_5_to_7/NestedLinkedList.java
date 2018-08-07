package ds_session_2_question_5_to_7;

import java.util.ArrayList;
import java.util.List;

public class NestedLinkedList {
	private List<Object> nestedList=new ArrayList<Object>();
	
	public void addValue(int data){
		nestedList.add(data);
	}
	public void addList(List<Object> nestedList){
		this.nestedList.add(nestedList);
	}
	public List<Object> getNestedList(){
		return nestedList;
	}
	
}
