package ds_session_2_que_4;

public class ArrayCircularQueue {
	int front;
	int rear;
	int[] queue;
	
	ArrayCircularQueue(int size){
		queue=new int[size];
		front=-1;
		rear=-1;
	}
	/**
	 * add element at front 
	 * @param element
	 * @throws AssertionError when queue is full
	 */
	public void enqueue(int element) {
		if((front==0 && rear==queue.length-1) || front==rear+1) {
			throw new AssertionError("Overflow");
		}
		if(front==-1) {
			front=0;
			rear=0;
		}
		else if(rear==queue.length-1) {
			rear=0;
		}
		else {
			rear=rear+1;
		}
		queue[rear]=element;
	}
	/**
	 * delete element from queue at rear 
	 * @return deleted element
	 * @throws AssertionError when queue is empty
	 */
	public int dequeue() {
		if(front==-1) {
			throw new AssertionError("Underflow");
		}
		int element=queue[front];
		if(front==queue.length-1) {
			front=-1;
		}
		else if(front ==rear) {
			front=-1;
			rear=-1;
		}
		else {
			front=front+1;
		}
		return element;
	}
	/**
	 * checks that queue is empty or not
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		if(front==-1) {
			return true;
		}
		return false;
	}
}
