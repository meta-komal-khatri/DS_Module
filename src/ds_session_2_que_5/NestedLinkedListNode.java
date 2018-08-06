package ds_session_2_que_5;

import java.util.ArrayList;
import java.util.List;

import ds_session_3_que_1.MyTreeNode;

public class NestedLinkedListNode<T>{
	private T data;
	private List<NestedLinkedListNode<T>> children=new ArrayList<NestedLinkedListNode<T>>();
	private NestedLinkedListNode<T> parent=null;
	private NestedLinkedListNode<T> next=null;
	public NestedLinkedListNode(T data) {
		this.data=data;

	}
	public void addChild(NestedLinkedListNode<T> child) {
		child.setParent(this);
		this.children.add(child);
	}
	public void addChild(T data) {
		NestedLinkedListNode<T> child=new NestedLinkedListNode<T>(data);
		child.setParent(this);
		this.children.add(child);
	}
	public void addChilden(List<NestedLinkedListNode<T>> children) {
		for(NestedLinkedListNode<T> nestedLinkedListNode : children) {
			nestedLinkedListNode.setParent(this);
		}
		this.children.addAll(children);
	}
	public void addNext(T data) {
		NestedLinkedListNode<T> nestedLinkedListNode=new NestedLinkedListNode<T>(data);
		this.next=nestedLinkedListNode;
	}
	private void setParent(NestedLinkedListNode<T> parent) {
		this.parent = parent;
	}
	public List<NestedLinkedListNode<T>> getChildren() {
		return children;
	} 

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	public NestedLinkedListNode<T> getParent() {
		return parent;
	}

}
