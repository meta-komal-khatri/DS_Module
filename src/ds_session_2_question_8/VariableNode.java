package ds_session_2_question_8;


public class VariableNode {
	private String variableIndex;
	private int variablePower;
	
	public VariableNode(String variableIndex, int variablePower){
		this.setVariableIndex(variableIndex);
		this.setVariablePower(variablePower);
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

	
}
