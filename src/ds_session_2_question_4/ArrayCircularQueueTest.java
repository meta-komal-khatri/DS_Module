package ds_session_2_question_4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

class ArrayCircularQueueTest {
	ArrayCircularQueue arrayQueue;
	@Test
	public void queueUnderflowTest() {
		arrayQueue=new  ArrayCircularQueue(5);
		//queue is empty
		assertEquals(true,arrayQueue.isEmpty());
		assertNotEquals(false,arrayQueue.isEmpty());
	}
	
	@Test
	public void Test() {
		arrayQueue=new  ArrayCircularQueue(5);
		//throws AssertionError when queue is full
		try {
		arrayQueue.enqueue(4);
		arrayQueue.enqueue(3);
		arrayQueue.enqueue(6);
		assertEquals(4,arrayQueue.dequeue());
		arrayQueue.enqueue(7);
		arrayQueue.enqueue(6);
		arrayQueue.enqueue(9);
		
		}
		catch(AssertionError error) {
			assertEquals("Overflow", error.getMessage());
		}
	
		assertEquals(3,arrayQueue.dequeue());
		assertEquals(6,arrayQueue.dequeue());
		assertEquals(7,arrayQueue.dequeue());
		assertNotEquals(1,arrayQueue.dequeue());
		
		//throws AssertionError when queue is empty
		try {
			arrayQueue.dequeue();
		}
		catch(AssertionError error){
			assertEquals("Underflow",error.getMessage());
		}
		
		
	}

}
