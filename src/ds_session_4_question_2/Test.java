package ds_session_4_question_2;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		UniqueCharactersCount charactersCount=new UniqueCharactersCount();
		assertEquals(5,charactersCount.countUniqueCharactersInString("Komal"));
		assertEquals(5,charactersCount.countUniqueCharactersInString("Komal"));

	}

}
