package ds_session_2_que_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestdeLinkedListImplementation {
	
	static NestedLinkedList nestedLinkedList1=new NestedLinkedList();
	static NestedLinkedList nestedLinkedList2=new NestedLinkedList();
	static NestedLinkedList nestedLinkedList3=new NestedLinkedList();
	/**
	 * nestedLinkedList1 is basic linked list 
	 * nestedlikedlist2 and nestedLinkedList3 are branches of nestedLinkedList1
	 */
	static{
		nestedLinkedList1.addValue(4);
		nestedLinkedList1.addValue(5);
		nestedLinkedList1.addValue(7);
		nestedLinkedList1.addList(new ArrayList<>(Arrays.asList(2,3,6)));
		nestedLinkedList2.addValue(8);
		nestedLinkedList2.addValue(9);
		nestedLinkedList2.addList(new ArrayList<>(Arrays.asList(1,11,32)));
		nestedLinkedList1.addList(nestedLinkedList2.getNestedList());
	}
	/**
	 * If element of list is an Integer than it directly adds it to sum
	 * else it recursively call sum method for nested list
	 * @param nestedList higher level nested list
	 * @return sum of all elemnts in nested list
	 */
	@SuppressWarnings("unchecked")
	public int sum(List<Object> nestedList){
		int sum=0;

		for(Object nested:nestedList){
			if(nested instanceof Integer){
				sum=sum + (int)nested;
			}
			else if(nested instanceof List){
				sum=sum+sum((List<Object>) nested);
			}
		}
		return sum;
	}
	/**
	 * If list element is an Integer 
	 * @param nestedList
	 * @param max
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int largestValue(List<Object> nestedList,int max){
		int maxValue=max;
		for(Object nested:nestedList){
			if(nested instanceof Integer){
				if(maxValue<(int) nested){
					maxValue=(int) nested;
				}
			}
			else if(nested instanceof List){
				maxValue=largestValue(((List<Object>) nested),maxValue);
			}
		}
		return maxValue;
	}
	public List<Integer> findValue(List<Object> nestedList,int value){
		List<Integer> foundIndex=new ArrayList<Integer>();
		int find=0;
		for(Object nested:nestedList){

			if(nested instanceof Integer){

				if(value==(int) nested){

					foundIndex.add(find);
					return foundIndex;
				}
			}
			else if(nested instanceof List){
				foundIndex.add(find);

				List<Integer> indexList=findValue((List<Object>) nested,value);
				if(indexList.size()>0){

					for(Integer index:indexList){
						foundIndex.add(index);
					}
					return foundIndex;
				}
				else{
					foundIndex.remove(foundIndex.size()-1);
				}
			}
			find++;
		}
		return foundIndex;
	}
}
