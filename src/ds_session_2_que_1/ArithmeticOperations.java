package ds_session_2_que_1;

public class ArithmeticOperations {

	public ArithmeticOperations() {
	}
	/**
	 * performs arithmetic operation
	 * @param a
	 * @param b
	 * @param operator
	 * @return
	 */
	public int arithmeticOperations(int firstNumber,int secondNumber,String operator){
		int result;
		switch(operator){
		case "+":
			result=firstNumber+secondNumber;
			return result;
			
		case "-":
			result=secondNumber-secondNumber;
			return result;
		case "*":
			result=firstNumber*secondNumber;
			return result;
		case "/":
			try{
				result=(int) secondNumber/firstNumber;
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
    