package ds_session_2_que_8;


public class PolynomialList {
	private int coefficient;
	private VariableList firstTermOfVariableList;
	private PolynomialList nextPolynomialList;
	
	/**
	 * @param  coefficient
	 * @param   variable - two dimensional array, 
	 * Where first Column represent Index of variable and 
	 * Second Column represent Power of variable
	 */
	PolynomialList(int coefficient, int variable[][]){
		this.coefficient = coefficient;
		if(variable.length != 0) {
			this.firstTermOfVariableList = new VariableList(variable[0][0], variable[0][1]);
			VariableList variableList = this.firstTermOfVariableList;
			for(int i=1; i<variable.length; i++) {
				variableList.setNextVariableList( new VariableList(variable[i][0], variable[i][1]));
				variableList = variableList.getNextVariableList();
			}
			this.nextPolynomialList = null;
		}
	}
}
