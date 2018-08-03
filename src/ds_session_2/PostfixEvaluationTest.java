package ds_session_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluationTest {
	PostfixEquationEvaluation postfixEquationEvaluation=new PostfixEquationEvaluation();
	@Test
	public void postfixEquationEvaluationTest() {
	 
		assertEquals(15,postfixEquationEvaluation.evaluate("3 4 + 5 4 + * 4 /"));
		assertEquals(-28,postfixEquationEvaluation.evaluate("3 4 + 5 4 - * 4 *"));
		assertEquals(147,postfixEquationEvaluation.evaluate("7 7 3 * *"));
		assertNotEquals(14,postfixEquationEvaluation.evaluate("7 7 3 * *"));
	}
	@Test
	public void exceptionTest() {
		try {
			int result=postfixEquationEvaluation.evaluate("3 4 + 4 4 - * 4 /");
		}
		catch(ArithmeticException error) {
			
		}
		
	}

}
