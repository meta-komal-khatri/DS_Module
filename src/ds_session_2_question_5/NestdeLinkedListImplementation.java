package ds_session_2_question_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestdeLinkedListImplementation implements NestedList {

	public static NestedLinkedList nestedLinkedList1=new NestedLinkedList();
	//static NestedLinkedList nestedLinkedList2=new NestedLinkedList();
	//static NestedLinkedList nestedLinkedList3=new NestedLinkedList();
	/**
	 * nestedLinkedList1 is basic linked list 
	 * nestedlikedlist2 and nestedLinkedList3 are branches of nestedLinkedList1
	 */
	/*static{
		nestedLinkedList1.addValue(4);
		nestedLinkedList1.addValue(5);
		nestedLinkedList1.addValue(7);
		nestedLinkedList1.addList(new ArrayList<>(Arrays.asList(2,3,6)));
		nestedLinkedList2.addValue(8);
		nestedLinkedList2.addValue(9);
		nestedLinkedList2.addList(new ArrayList<>(Arrays.asList(1,11,32)));
		nestedLinkedList1.addList(nestedLinkedList2.getNestedList());
	}*/
	/**
	 * If element of list is an Integer than it directly adds it to sum
	 * else it recursively call sum method for nested list
	 * @param nestedList first level nested list
	 * @return sum of all elements in nested list
	 */
	@SuppressWarnings("unchecked")
	public int sum(List<Object> nestedList){
		if(nestedList.size()==0) {
			throw new AssertionError("List is empty");
		}
		int sum=0;

		for(Object nested:nestedList){
			//if object is an Integer ,add directly to sum
			if(nested instanceof Integer){
				sum=sum + (int)nested;
			}
			//if object is also a list ,it recursively calls sum method
			else if(nested instanceof List){
				sum=sum+sum((List<Object>) nested);
			}
		}
		return sum;
	}
	public int largestValue(List<Object> nestedList) {
		return largestValue(nestedList,0);
	}
	/**
	 * If list element is an Integer than it checks for max value 
	 * else recursively find maximum element
	 * @param nestedList first level of nested list
	 * @param max 
	 * @return maximum value integer from nested List
	 */
	@SuppressWarnings("unchecked")
	private int largestValue(List<Object> nestedList,int max){
		if(nestedList.size()==0) {
			throw new AssertionError("List is empty");
		}
		int maxValue=max;
		for(Object nested:nestedList){
			//if object is an Integer ,compare directly with max
			if(nested instanceof Integer){
				if(maxValue<(int) nested){
					maxValue=(int) nested;
				}
			}
			//if object is a list it recursively calls largestValue method
			else if(nested instanceof List){
				maxValue=largestValue(((List<Object>) nested),maxValue);
			}
		}
		return maxValue;
	}
	/**
	 * recursively finds element in nested list 
	 * @param nestedList first level of nested list
	 * @param value that is to be found
	 * @return list of integer such that first value of list shows index in first level list 
	 * 		   second value shows index in second level so on.
	 */
	public List<Integer> findValue(List<Object> nestedList,int value){
		if(nestedList.size()==0) {
			throw new AssertionError("List is empty");
		}
		List<Integer> foundIndex=new ArrayList<Integer>();
		int index=0;
		for(Object nested:nestedList){
			//object is an integer it directly checks value
			if(nested instanceof Integer){
				if(value==(int) nested){
					foundIndex.add(index);
					return foundIndex;
				}
			}
			//object is a list it recursively call findValue method
			else if(nested instanceof List){
				foundIndex.add(index);
				List<Integer> indexList=findValue((List<Object>) nested,value);
				//if value is found in nested list then it will return a list of index
				if(indexList.size()>0){
					for(Integer indexfromList:indexList){
						foundIndex.add(indexfromList);
					}
					return foundIndex;
				}
				//value was not found in list at current index, so remove index from found index 
				else{
					foundIndex.remove(foundIndex.size()-1);
				}
			}
			index++;
		}
		return foundIndex;
	}
}
