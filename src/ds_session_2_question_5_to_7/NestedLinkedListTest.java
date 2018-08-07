package ds_session_2_question_5_to_7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NestedLinkedListTest {
	NestdeLinkedListImplementation implementation=new NestdeLinkedListImplementation();
	/**
	 * test for sum method
	 */
	@Test
	public void sumTest() {

		assertEquals(88,implementation.sum(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList()));
		assertNotEquals(23,implementation.sum(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList()));
	}
	/**
	 * test for largetstValue method
	 */
	@Test
	public void largestValueTest() {
		assertEquals(32,implementation.largestValue(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList()));
		assertNotEquals(23,implementation.largestValue(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList()));
	}
	/**
	 * test for findValueTest method
	 */
	@Test
	public void findValueTest() {
		List<Integer> index =new ArrayList<Integer>(Arrays.asList(4,2,2));
		assertEquals(index.toString(),implementation.findValue
				(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList(), 32).toString());
		
		index=new ArrayList<Integer>(Arrays.asList(3,1));
		assertEquals(index.toString(),implementation.findValue
				(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList(), 3).toString());
		
		assertNotEquals(index.toString(),implementation.findValue
				(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList(), 32).toString());
		//when value is not in nested list ,it return empty list 
		assertEquals(new ArrayList<Integer>().toString(),implementation.findValue(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList(), 23).toString());
		
	}
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorTest() {
		
		implementation.sum(new ArrayList<>());
		implementation.findValue(new ArrayList<>(Arrays.asList(1,2)), 4);
		implementation.largestValue(new ArrayList<>());
		
		
	}



}
