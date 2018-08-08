package ds_session_2_question_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {
    InfixToPostfix  infixToPstfix;
	@Test
	public void infixToPostfixTest() {
		infixToPstfix=new InfixToPostfix();
		assertEquals("1 2 3 * + ",infixToPstfix.infixToPostfix("1 + 2 * 3"));
		assertEquals("1 2 3 * * ",infixToPstfix.infixToPostfix("1 * 2 * 3"));
		assertEquals("1 3 4 5 / 4 * + + ",infixToPstfix.infixToPostfix("1 + 3 + ( 4 / 5 ) * 4"));
		
	}
	@Test
	public void exceptionTest() {
		infixToPstfix=new InfixToPostfix();
		try {
			String result=infixToPstfix.infixToPostfix("");
		}
		catch(NullPointerException error) {
			
		}	
	}
	
	@Test
	public void throwsAssertionErrorIfPatternIsNotAppropriate(){
		infixToPstfix=new InfixToPostfix();
		try{
			infixToPstfix.infixToPostfix("2 + +");
			infixToPstfix.infixToPostfix("1 + 3 ( 6 + 8 ) + 4");
		}
		catch(AssertionError error){
			
		}
	}
}
