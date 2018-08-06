package ds_session_2_que_8;


public class VariableList {
	private int variableIndex;
	private int variablePower;
	private VariableList nextVariableList;
	
	public VariableList(int variableIndex, int variablePower){
		this.setVariableIndex(variableIndex);
		this.setVariablePower(variablePower);
		this.setNextVariableList(null);
	}

	public int getVariableIndex() {
		return variableIndex;
	}

	public void setVariableIndex(int variableIndex) {
		this.variableIndex = variableIndex;
	}

	public int getVariablePower() {
		return variablePower;
	}

	public void setVariablePower(int variablePower) {
		this.variablePower = variablePower;
	}

	public VariableList getNextVariableList() {
		return nextVariableList;
	}

	public void setNextVariableList(VariableList nextVariableList) {
		this.nextVariableList = nextVariableList;
	}
}
