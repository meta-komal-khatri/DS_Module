package ds_session_2_question_8;

import java.util.ArrayList;
import java.util.List;


public class VariableListLinked {
	protected List<VariableNode> variableList;
	public VariableListLinked() {
		variableList=new ArrayList<VariableNode>();
	}
	public void addVariableNode(String index,int power){
		variableList.add(new VariableNode(index,power));
	}
	public List<VariableNode> getVariableList(){
		return variableList;
	}
}
