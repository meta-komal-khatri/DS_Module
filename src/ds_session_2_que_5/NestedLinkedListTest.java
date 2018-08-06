package ds_session_2_que_5;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class NestedLinkedListTest {

	@Test
	public void test() {
		NestdeLinkedListImplementation implementation=new NestdeLinkedListImplementation();
		int sum=implementation.sum(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList());
		System.out.print(sum);
		int max=implementation.largestValue(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList(),0);
		System.out.print(max);
		List<Integer> index =implementation.findValue(NestdeLinkedListImplementation.nestedLinkedList1.getNestedList(), 32);
		System.out.print(index);
	}

}
