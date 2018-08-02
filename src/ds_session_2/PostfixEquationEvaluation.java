package ds_session_2;
import stack.ArrayStack;
import stack.Stack;
public class PostfixEquationEvaluation {
	String equation;

	public PostfixEquationEvaluation(String equation) {
		this.equation = equation;
		validate();
	}

	private void validate(){
		if(equation==null){
			throw new NullPointerException("");
		}
	}
	public int evaluate(){
		ArithmeticOperations calculate=new ArithmeticOperations();
		String[] tokenizedEquation=equation.split(" ");
		Stack stack=new ArrayStack(tokenizedEquation.length); 
		int firstPoppedValue,secondPoppdeValue;
		for(String token:tokenizedEquation){
			if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)){
				firstPoppedValue=stack.pop();
				secondPoppdeValue=stack.pop();
				stack.push(calculate.arithmeticOperations(firstPoppedValue, secondPoppdeValue, token));
			}
			else{
				stack.push(Integer.parseInt(token));
			}

		}
		return stack.pop();
	}


}
