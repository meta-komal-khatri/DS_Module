package ds_session_2_que_5_to_7;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GetValueTest {
	GetValueAtSpecifiedPosition getValueAtSpecifiedPosition=new GetValueAtSpecifiedPosition();
	List<Object> nestedList=NestdeLinkedListImplementation.nestedLinkedList1.getNestedList();
	@Test
	public void getValueTest() {
		assertEquals(1,getValueAtSpecifiedPosition.getValue(nestedList,"TTH"));
		assertEquals(8,getValueAtSpecifiedPosition.getValue(nestedList, "TH"));
		assertEquals(4,getValueAtSpecifiedPosition.getValue(nestedList, "H"));

	}
	@Test(expected=AssertionError.class)
	public void getValueThrowsExceptionTest() {
		getValueAtSpecifiedPosition.getValue(nestedList, "HT");
		getValueAtSpecifiedPosition.getValue(nestedList, "TTTT");
		getValueAtSpecifiedPosition.getValue(nestedList, "THT");
		getValueAtSpecifiedPosition.getValue(nestedList, "TTHT");
		
	}
	@Test(expected=IllegalStateException.class)
	public void getValueThrowsIllegealStateExceptionTest() {
		getValueAtSpecifiedPosition.getValue(nestedList,"TF");
	}

}
