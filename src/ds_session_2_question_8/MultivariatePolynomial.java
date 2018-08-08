package ds_session_2_question_8;
import java.util.List;
import java.util.ArrayList;




public class MultivariatePolynomial {
	protected List<PolynomialNode> multivariatePolynomial;
	public MultivariatePolynomial() {
		multivariatePolynomial=new ArrayList<PolynomialNode>();
	}
	public void addPolynomialNode(int coefficient,List<VariableNode> variableList){
		multivariatePolynomial.add(new PolynomialNode(coefficient,variableList));
	}
	public void printPolynomial(){
		for(PolynomialNode polynomial:multivariatePolynomial){
			for(VariableNode variableNode:polynomial.getVariableList()){
				System.out.println(polynomial.getCoefficient() +""+variableNode.getVariableIndex()+"^"+
			variableNode.getVariablePower());
			}
		}
	}
}
