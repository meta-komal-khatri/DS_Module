package ds_session_2_que_8;


public class VariableNode {
	private String variableIndex;
	private int variablePower;
	private VariableNode nextVariableList;
	
	public VariableNode(String variableIndex, int variablePower){
		this.setVariableIndex(variableIndex);
		this.setVariablePower(variablePower);
		this.setNextVariableList(null);
	}

	public String getVariableIndex() {
		return variableIndex;
	}

	public void setVariableIndex(String variableIndex) {
		this.variableIndex = variableIndex;
	}

	public int getVariablePower() {
		return variablePower;
	}

	public void setVariablePower(int variablePower) {
		this.variablePower = variablePower;
	}

	public VariableNode getNextVariableList() {
		return nextVariableList;
	}

	public void setNextVariableList(VariableNode nextVariableList) {
		this.nextVariableList = nextVariableList;
	}
}
