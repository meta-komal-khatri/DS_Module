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
