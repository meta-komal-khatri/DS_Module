package ds_session_3_question_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void priorityQueueTest(){
		try {
		PriorityQueue priorityQueue=new PriorityQueue(5);
		priorityQueue.insertIntoPriorityQueue("Bowler", 5);
		priorityQueue.insertIntoPriorityQueue("batting", 4);
		priorityQueue.insertIntoPriorityQueue("bat", 8);
		priorityQueue.insertIntoPriorityQueue("Raquet", 6);
		assertEquals("bat",priorityQueue.remove().getJob());
		assertEquals("Raquet",priorityQueue.remove().getJob());
		assertNotEquals("fgh",priorityQueue.remove().getJob());
		priorityQueue.insertIntoPriorityQueue("23",8);
		priorityQueue.insertIntoPriorityQueue("87",3);
		priorityQueue.insertIntoPriorityQueue("97",2);
		priorityQueue.insertIntoPriorityQueue("76",9);
		priorityQueue.insertIntoPriorityQueue("87",7);
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			assertEquals("Queue is full",exception.getMessage());
		}
		
		
	}

}