package ds_session_3_question_2;
/*
 * Max heap is used to create PriorityQueue
 */
public class PriorityQueue {
	private Task[] taskHeap;
	private int capacityOfPriorityQueue,heapSize;
	public PriorityQueue(int capacityOfPriorityQueue) {
		this.capacityOfPriorityQueue = capacityOfPriorityQueue + 1;
		taskHeap = new Task[this.capacityOfPriorityQueue];
		heapSize = 0;
	}
	/**
	 * @return returns heap of priority queue
	 */
	public Task[] getHeap() {
		return taskHeap;
	}
	/**
	 * sets value in heap
	 * @param heap
	 */
	public void setHeap(Task[] heap) {
		this.taskHeap = heap;
	}
	/**
	 * @return capacity of PriorityQueue
	 */
	public int getCapacityOfPriorityQueue() {
		return capacityOfPriorityQueue;
	}
	/**
	 * sets capacity of priority queue
	 * @param capacityOfPriorityQueue
	 */
	public void setCapacityOfPriorityQueue(int capacityOfPriorityQueue) {
		this.capacityOfPriorityQueue = capacityOfPriorityQueue;
	}
	/**
	 * checks that priority queue heap is empty or not
	 * @return true if priority queue heap is empty
	 */
	public boolean isEmpty()
	{
		return heapSize == 0;
	}
	/**
	 * check that priority queue heap is full or not
	 * @return true if priority queue heap is full
	 */
	public boolean isFull(){
		return heapSize==taskHeap.length-1;
	}
	/**
	 * insert a task into priority queue heap 
	 * parent task priority is higher than its child task priority
	 * @param job name of task (job)
	 * @param priority 
	 */
	public void insertIntoPriorityQueue(String job,int priority){
		Task newJob=new Task(job,priority);
		if(isFull()){
			throw new ArrayIndexOutOfBoundsException("Queue is full");
		}
		taskHeap[++heapSize]=newJob;
		int pos = heapSize;
		//insert node at last of heap than traverse heap to check priority
		//if parents priority is less than child ,replace
		while (pos != 1 && newJob.getPriority() > taskHeap[pos/2].getPriority())
		{
			taskHeap[pos] = taskHeap[pos/2];
			pos /=2;
		}
		taskHeap[pos] = newJob;  
	}
	/**
	 * removes root of priority queue heap
	 * @return task removed from queue heap
	 */
	public Task remove()
	{
		int parent, child;
		Task item, temp;
		if (isEmpty() )
		{
			throw new AssertionError("Heap is empty");
		}
		item = taskHeap[1];
		temp = taskHeap[heapSize--];
		parent = 1;
		child = 2;
		while (child <= heapSize)
		{
			if (child < heapSize && taskHeap[child].getPriority() < taskHeap[child + 1].getPriority())
				child++;
			if (temp.getPriority() >= taskHeap[child].getPriority())
			break;
			taskHeap[parent] = taskHeap[child];
			parent = child;
			child *= 2;
		}
		taskHeap[parent] = temp;
		return item;
	}


}
