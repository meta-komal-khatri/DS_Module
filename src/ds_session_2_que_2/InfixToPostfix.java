package ds_session_2_que_2;

import java.util.Arrays;
import java.util.Stack;
public class InfixToPostfix {
	String postfixEquation;
	Stack<String> stack;
	public InfixToPostfix() {
		stack=new Stack<String>();
	}

	
	private boolean checkPrecedence(String operater1,String operator2){
		if(("*".equals(operater1) || "/".equals(operater1)) && ("+".equals(operator2) || "-".equals(operator2) )){
			return true;
		}
		if("/".equalsIgnoreCase(operater1) && "*".equals(operator2)){
			return true;
		}
		return false;
	}
	
	private void solveBrackets(){
		while(!"(".equals(stack.peek())){			
			addTokenToPostfixEquation(stack.pop());
		}
		stack.pop();
	}
	
	private void addTokenToPostfixEquation(String token){
		postfixEquation=postfixEquation.concat(token);
		postfixEquation=postfixEquation.concat(" ");
	}
	
	private String[] initialize(String equation){
		if(equation.length()==0){
			throw new NullPointerException("Equation string is empty");
		}
		postfixEquation="";
		stack.push("(");
		return equation.split(" ");
	}
	
	public String infixToPostfix(String equation){
		String[] equationTokenArray=initialize(equation);
		for(String tokens:equationTokenArray){
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
			else if("(".equals(tokens)){
				stack.push(tokens);
			}
			else if(")".equals(tokens)){
				solveBrackets();
			}
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
