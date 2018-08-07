package ds_session_2_que_8;


public class PolynomialNode {
	private int coefficient;
	private VariableNode variableList;
	private PolynomialNode nextPolynomialList;
	
	/**
	 * @param  coefficient
	 * @param   variable - two dimensional array, 
	 * Where first Column represent Index of variable and 
	 * Second Column represent Power of variable
	 */
	PolynomialNode(int coefficient, VariableNode variableList){
		this.coefficient = coefficient;
		this.variableList=variableList;
		/*if(variable.length != 0) {
			this.firstTermOfVariableList = new VariableList(variable[0][0], variable[0][1]);
			VariableList variableList = this.firstTermOfVariableList;
			for(int i=1; i<variable.length; i++) {
				variableList.setNextVariableList( new VariableList(variable[i][0], variable[i][1]));
				variableList = variableList.getNextVariableList();
			}*/
			this.setNextPolynomialList(null);
	
	}

	public PolynomialNode getNextPolynomialList() {
		return nextPolynomialList;
	}

	public void setNextPolynomialList(PolynomialNode nextPolynomialList) {
		this.nextPolynomialList = nextPolynomialList;
	}
}
