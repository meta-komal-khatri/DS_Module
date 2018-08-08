package ds_session_4_question_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterCountTest {

	@org.junit.Test
	public void uniqueCharacterCountTest() {
		UniqueCharactersCount charactersCount=new UniqueCharactersCount();
		assertEquals(5,charactersCount.countUniqueCharactersInString("Komal"));
		assertEquals(5,charactersCount.countUniqueCharactersInString("Komal"));
		assertEquals(5,charactersCount.countUniqueCharactersInString("jigisha"));
		assertNotEquals(3,charactersCount.countUniqueCharactersInString("jigisha"));
		assertEquals(7,charactersCount.countUniqueCharactersInString("komaltttuuugf"));

	}
	@Test(expected=NullPointerException.class)
	public void exceptionWhenStringIsEmpty() {
		UniqueCharactersCount charactersCount=new UniqueCharactersCount();
		charactersCount.countUniqueCharactersInString("");
	}

}
