package ds_session_2_question_6;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import ds_session_2_question_5.NestdeLinkedListImplementation;

public class NestedLinkedListTest {
	NestdeLinkedListImplementation implementation=new NestdeLinkedListImplementation();
	JSONObjectReader jsonObject=new JSONObjectReader();
	
	/**
	 * test for sum method
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void sumTest() throws FileNotFoundException, IOException, ParseException {
		
		JSONObject object=jsonObject.createJsonObject();
		NestedLinkedList nestedList=jsonObject.storeJsonNestedObjectIntoNestedList(object);
 		assertEquals(2880,implementation.sum(nestedList.getNestedList()));
		assertNotEquals(23,implementation.sum(nestedList.getNestedList()));
	}
	/**
	 * test for largetstValue method
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void largestValueTest() throws FileNotFoundException, IOException, ParseException {
		JSONObject object=jsonObject.createJsonObject();
		NestedLinkedList nestedList=jsonObject.storeJsonNestedObjectIntoNestedList(object);
		assertEquals(789,implementation.largestValue(nestedList.getNestedList()));
		assertNotEquals(23,implementation.largestValue
				(nestedList.getNestedList()));
	}
	/**
	 * test for findValueTest method
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void findValueTest() throws FileNotFoundException, IOException, ParseException {
		JSONObject object=jsonObject.createJsonObject();
		NestedLinkedList nestedList=jsonObject.storeJsonNestedObjectIntoNestedList(object);
		List<Integer> index =new ArrayList<Integer>(Arrays.asList(3,1));
		assertEquals(index.toString(),implementation.findValue
				(nestedList.getNestedList(), 7).toString());
		
		index=new ArrayList<Integer>(Arrays.asList(2,1));
		assertEquals(index.toString(),implementation.findValue
				(nestedList.getNestedList(), 789).toString());
		
		assertNotEquals(index.toString(),implementation.findValue
				(nestedList.getNestedList(), 7).toString());
		
		//when value is not in nested list ,it return empty list 
		assertEquals(new ArrayList<Integer>().
				toString(),implementation.findValue(nestedList.getNestedList(), 23).toString());
		
	}
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorTest() {
		
		implementation.sum(new ArrayList<>());
		implementation.findValue(new ArrayList<>(Arrays.asList(1,2)), 4);
		implementation.largestValue(new ArrayList<>());
		
		
	}



}
