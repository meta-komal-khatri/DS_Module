package ds_session_2_question_2;

import java.util.Arrays;
import java.util.Stack;
public class InfixToPostfix {
	String postfixEquation;
	Stack<String> stack;
	public InfixToPostfix() {
		stack=new Stack<String>();
	}
	/**
	 * method to check pattern
	 * @param tokens
	 */
	private void validate(String[] tokens){
		for(int i=0;i<tokens.length-1;i++){
			if("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])
					){
				if("+".equals(tokens[i+1]) || "-".equals(tokens[i+1]) || "*".equals(tokens[i+1]) || "/".equals(tokens[i+1])
						){
					throw new AssertionError("Pattern mismatch");
				}
			}
			if(")".equals(tokens[i]))
			{
				if(!"+".equals(tokens[i+1]) && !"-".equals(tokens[i+1]) && !"*".equals(tokens[i+1]) && !"/".equals(tokens[i+1])
					){
					throw new AssertionError("Pattern mismatch");
				}
			}
			if("(".equals(tokens[i]))
			{
				if(!"+".equals(tokens[i-1]) && !"-".equals(tokens[i-1]) && !"*".equals(tokens[i-1]) && !"/".equals(tokens[i-1])
					){
					throw new AssertionError("Pattern mismatch");
				}
			}
			
		}
	}

	/**
	 * checks operator precedence
	 * @param operater1 
	 * @param operator2
	 * @return if operator1 precedence is higher than operator2 return true else false
	 */
	private boolean checkPrecedence(String operater1,String operator2){
		if(("*".equals(operater1) || "/".equals(operater1)) && ("+".equals(operator2) || "-".equals(operator2) )){
			return true;
		}
		if("/".equalsIgnoreCase(operater1) && "*".equals(operator2)){
			return true;
		}
		return false;
	}
	/**
	 * pop all elements from stack until left parenthesis is encountered
	 */
	private void solveBrackets(){
		while(!"(".equals(stack.peek())){			
			addTokenToPostfixEquation(stack.pop());
		}
		stack.pop();
	}
	/**
	 * concatenate token to postfix equation
	 * @param token
	 */
	private void addTokenToPostfixEquation(String token){
		postfixEquation=postfixEquation.concat(token);
		postfixEquation=postfixEquation.concat(" ");
	}
	/**
	 * initialize stack and postfix equation and checks that equation is empty or not
	 * @param equation
	 * @return if equation is not empty returns tokenized array
	 */
	private String[] initialize(String equation){
		if(equation.length()==0){
			throw new NullPointerException("Equation string is empty");
		}
		postfixEquation="";
		stack.push("(");
		return equation.split(" ");
	}
	/**
	 * convert infix representation of equation into postfix equation
	 * @param equation each operand must be separated by whitespace
	 * @return return converted string
	 */
	public String infixToPostfix(String equation){
		String[] equationTokenArray=initialize(equation);
		validate(equationTokenArray);
		for(String tokens:equationTokenArray){
			//token is an operator
			if("+".equals(tokens) || "-".equals(tokens) || "*".equals(tokens) 
					|| "/".equals(tokens)){
				try{
					while(checkPrecedence(stack.peek(),tokens)){	
						addTokenToPostfixEquation(stack.pop());
					}
				}
				catch(Exception exception){
					
				}
				stack.push(tokens);
			}
			//token is left parenthesis
			else if("(".equals(tokens)){
				stack.push(tokens);
			}
			//token is right parenthesis
			else if(")".equals(tokens)){
				solveBrackets();
			}
			//token is an operand
			else{
				addTokenToPostfixEquation(tokens);
			}
		}
		while(!stack.empty() && !"(".equals(stack.peek())){
			addTokenToPostfixEquation(stack.pop());
		}
		return postfixEquation;
	}
}
