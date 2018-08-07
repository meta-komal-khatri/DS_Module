package ds_session_2_question_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfiEvaluationTest {
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
