package ds_session_2_question_5_to_7;

import java.util.List;



public class PolynomialNode {
	private int coefficient;
	private List<VariableNode> variableList;
	/**
	 * @param  coefficient
	 * @param   variableList - list of variable, 
	 * Where first Column represent Index of variable and 
	 * Second Column represent Power of variable
	 */
	PolynomialNode(int coefficient, List<VariableNode> variableList){
		this.setCoefficient(coefficient);
		this.setVariableList(variableList);
		/*if(variable.length != 0) {
			this.firstTermOfVariableList = new VariableList(variable[0][0], variable[0][1]);
			VariableList variableList = this.firstTermOfVariableList;
			for(int i=1; i<variable.length; i++) {
				variableList.setNextVariableList( new VariableList(variable[i][0], variable[i][1]));
				variableList = variableList.getNextVariableList();
			}*/
	
	}
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	public List<VariableNode> getVariableList() {
		return variableList;
	}
	public void setVariableList(List<VariableNode> variableList) {
		this.variableList = variableList;
	}


}
