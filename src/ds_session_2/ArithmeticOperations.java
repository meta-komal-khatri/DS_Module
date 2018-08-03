package ds_session_2;

public class ArithmeticOperations {

	public ArithmeticOperations() {
	}
	public int arithmeticOperations(int a,int b,String operator){
		int result;
		switch(operator){
		case "+":
			result=a+b;
			return result;
			
		case "-":
			result=a-b;
			return result;
		case "*":
			result=a*b;
			return result;
		case "/":
			try{
				result=(int) b/a;
				System.out.println(result);
				return result;
			}
			catch(ArithmeticException exception){
				
			}
		default:
			throw new AssertionError("Not an appropriate operator");
		}
		
	}
	
}
