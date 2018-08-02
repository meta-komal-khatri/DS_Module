package stack;

import java.util.NoSuchElementException;
/**
 * implements stack structure using array
 */
public class ArrayStack implements Stack{
	static public int[] arrayStack;
	private int top,size;
	public ArrayStack(int size){
		this.size=size;
		arrayStack=new int[size];
		top=-1;
	}
	/**
	 * add elements at the top of array
	 * @param value added to the stack
	 */
	public void push(int valueOfStack){
		if(top+1>=size){
			throw new IndexOutOfBoundsException("Overflow Exception");
		}
		else{
			arrayStack[++top]=valueOfStack;
		}
		
	}
	/**
	 * delete elements at the top of array
	 * @return deleted element
	 */
	public int pop(){
		int poppedElement; 
		if(top==-1){
			throw new NoSuchElementException("Underflow Exception");	
		}
		else{
			poppedElement=arrayStack[top--];
		}
		return poppedElement;
				
	}
	/**
	 * checks that stack array is empty or not
	 * @return true is stack array is empty 
	 */
	public boolean isEmpty(){
		return top==-1;
	}

}
