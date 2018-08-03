package ds_session_2_que_1;
import stack.ArrayStack;
import stack.Stack;
public class PostfixEquationEvaluation {
	String equation;
	public PostfixEquationEvaluation() {

	}

	private void validate(){
		if(equation==null){
			throw new NullPointerException("equation is null");
		}
	}

	public int evaluate(String equation){

		this.equation=equation;
		validate();
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
