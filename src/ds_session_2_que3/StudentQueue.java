package ds_session_2_que3;

import java.util.InputMismatchException;

public class StudentQueue<E> {
	protected NodeOfQueue<E> front;
	protected NodeOfQueue<E> rear;
	int size;
	StudentQueue(){
		front=null;
		rear=null;
		size=0;
	}
	/**
	 * add element into queue at rear
	 * @param element
	 */
	public void enqueue(E element) {
		NodeOfQueue<E> newNode;
		try{
			newNode=new NodeOfQueue<E>(element,null);


			if(front==null) {
				front=newNode;
				rear=newNode;
			}
			else {
				rear.setLink(newNode);
				rear=newNode;
			}
			size++;
		}
		catch(InputMismatchException exception){
		}
	}
	/**
	 * deletes element from queue at front
	 * @return deleted value
	 * @throws AssertionError when queue is empty
	 */
	public E dequeue() {
		NodeOfQueue<E> pointer;
		E element;
		if(front==null) {
			throw new AssertionError("Underflow");
		}
		else {
			pointer=front;
			front=pointer.getLink();
			element=pointer.getData();
			size--;
		}
		return element;
	}
	/**
	 * checks that queue is empty or not
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		return front==null;
	}
	public E getElement(){
		return front.data;
	}
	public int size(){
		return size;
	}
}
