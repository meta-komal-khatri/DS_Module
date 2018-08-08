package ds_session_3_question_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyTreeNode<T>{
	private T data = null;
	private List<MyTreeNode<T>> children = new ArrayList<>();
	private MyTreeNode<T> parent = null;
	private Date date;
	/**
	 * creates directory node
	 * @param data
	 */
	public MyTreeNode(T data) {
		this.data = data;
		setDate(new Date());
	}
	/**
	 * add child to current node 
	 * @param child node
	 */
	public void addChild(MyTreeNode<T> child) {
		child.setParent(this);
		this.children.add(child);
	}

	/**
	 * add child to current node by value
	 * @param data
	 */
	public void addChild(T data) {
		MyTreeNode<T> newChild = new MyTreeNode<>(data);
		newChild.setParent(this);
		children.add(newChild);
	}

	/**
	 * add list of children to current node
	 * @param children
	 */
	public void addChildren(List<MyTreeNode<T>> children) {
		for(MyTreeNode<T> t : children) {
			t.setParent(this);
		}
		this.children.addAll(children);
	}

	/**
	 * list of children
	 * @return
	 */
	public List<MyTreeNode<T>> getChildren() {
		return children;
	}
	
	/**
	 * @return data of current node
	 */
	public T getData() {
		return data;
	}
	/**
	 * sets data in current node
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * set parent of current node
	 * @param parent
	 */
	private void setParent(MyTreeNode<T> parent) {
		this.parent = parent;
	}

	/**
	 * return parent of current node
	 * @return
	 */
	public MyTreeNode<T> getParent() {
		return parent;
	}

	/**
	 * return date of creation of node
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public void print() {
		print("", true);
	}
	/**
	 * print tree structure
	 * @param prefix
	 * @param isTail
	 */
	private void print(String prefix, boolean isTail) {
		System.out.println(prefix + (isTail ? "---" : "|---") + data);
		for (int i = 0; i < children.size() - 1; i++) {
			children.get(i).print(prefix + (isTail ? "    " : "|   "), false);
		}
		if (children.size() > 0) {
			children.get(children.size() - 1)
			.print(prefix + (isTail ?"    " : "|   "), true);
		}
	}
}