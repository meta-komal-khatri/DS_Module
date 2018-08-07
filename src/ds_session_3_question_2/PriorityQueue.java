package ds_session_3_question_2;

public class PriorityQueue {
	private Task[] taskHeap;
	private int capacityOfPriorityQueue,heapSize;
	public PriorityQueue(int capacityOfPriorityQueue) {
		this.capacityOfPriorityQueue = capacityOfPriorityQueue + 1;
		taskHeap = new Task[this.capacityOfPriorityQueue];
		heapSize = 0;
	}
	public Task[] getHeap() {
		return taskHeap;
	}
	public void setHeap(Task[] heap) {
		this.taskHeap = heap;
	}
	public int getCapacityOfPriorityQueue() {
		return capacityOfPriorityQueue;
	}
	public void setCapacityOfPriorityQueue(int capacityOfPriorityQueue) {
		this.capacityOfPriorityQueue = capacityOfPriorityQueue;
	}
	public boolean isEmpty()
	{
		return heapSize == 0;
	}
	public boolean isFull(){
		return heapSize==taskHeap.length-1;
	}
	public void insertIntoPriorityQueue(String job,int capacityOfPriority){
		Task newJob=new Task(job,capacityOfPriority);
		if(isFull()){
			throw new AssertionError("Queue is full");
		}
		taskHeap[++heapSize]=newJob;
		int pos = heapSize;
		while (pos != 1 && newJob.getPriority() > taskHeap[pos/2].getPriority())
		{
			taskHeap[pos] = taskHeap[pos/2];
			pos /=2;
		}
		taskHeap[pos] = newJob;  
	}
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
