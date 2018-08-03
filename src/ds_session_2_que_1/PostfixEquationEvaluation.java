package ds_session_2_que_1;
import stack.ArrayStack;
import stack.Stack;
public class PostfixEquationEvaluation {
	String equation;
	public PostfixEquationEvaluation() {

	}
 /**
  * checks that equation is empty or not
  * if empty throws NullPointerException
  */
	private void validate(){
		if(equation==null){
			throw new NullPointerException("equation is null");
		}
	}
/**
 * evaluate postfix equation
 * @param equation should contain integer and operators only,must separated by whitespace
 * @return number
 */
	public int evaluate(String equation){

		this.equation=equation;
		validate();
		ArithmeticOperations calculate=new ArithmeticOperations();
		String[] tokenizedEquation=equation.split(" ");
		Stack stack=new ArrayStack(tokenizedEquation.length); 
		int firstPoppedValue,secondPoppdeValue;
		for(String token:tokenizedEquation){
			//if token is operator pop first 2 values from stack and perform operation
			if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)){

				firstPoppedValue=stack.pop();
				secondPoppdeValue=stack.pop();
				stack.push(calculate.arithmeticOperations(firstPoppedValue, secondPoppdeValue, token));

			}
			//if token is operand ,push operand
			else{
				stack.push(Integer.parseInt(token));
			}

		}
		return stack.pop();
	}


	}
