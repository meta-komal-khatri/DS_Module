package ds_session_2_question_7;
import ds_session_2_question_5.NestdeLinkedListImplementation;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GetValueTest {
	GetValueAtSpecifiedPosition getValueAtSpecifiedPosition=new GetValueAtSpecifiedPosition();
	List<Object> nestedList=NestdeLinkedListImplementation.nestedLinkedList1.getNestedList();
	
	//checks value 
	@Test
	public void getValueTest() {
		assertEquals(1,getValueAtSpecifiedPosition.getValue(nestedList,"TTH"));
		assertEquals(8,getValueAtSpecifiedPosition.getValue(nestedList, "TH"));
		assertEquals(4,getValueAtSpecifiedPosition.getValue(nestedList, "H"));

	}
	
	//checks for exception when specified string is not appropriate
	@Test(expected=AssertionError.class)
	public void getValueThrowsExceptionTest() {
		getValueAtSpecifiedPosition.getValue(nestedList, "HT");
		getValueAtSpecifiedPosition.getValue(nestedList, "TTTT");
		getValueAtSpecifiedPosition.getValue(nestedList, "THT");
		getValueAtSpecifiedPosition.getValue(nestedList, "TTHT");
		
	}
	
	//when specifiedPosition string contains character other than T or H
	@Test(expected=IllegalStateException.class)
	public void getValueThrowsIllegealStateExceptionTest() {
		getValueAtSpecifiedPosition.getValue(nestedList,"TF");
	}
	
	//when nested list is empty
	@Test(expected=NullPointerException.class)
	public void getValueThrowsExceptionIfListIsEmpty(){
		List<Object> nestedList=new ArrayList<>();
		getValueAtSpecifiedPosition.getValue(nestedList, "HT");
	}
	
	//when specified position string is empty
	@Test(expected=AssertionError.class)
	public void getValueThrowsExceptionIfSpecifiedPositionIsEmpty(){
		getValueAtSpecifiedPosition.getValue(nestedList, "");
	}

}
