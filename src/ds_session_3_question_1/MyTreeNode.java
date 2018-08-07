package ds_session_3_question_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyTreeNode<T>{
    private T data = null;
    private List<MyTreeNode<T>> children = new ArrayList<>();
    private MyTreeNode<T> parent = null;
    private Date date;

    public MyTreeNode(T data) {
        this.data = data;
        setDate(new Date());
    }

    public void addChild(MyTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        MyTreeNode<T> newChild = new MyTreeNode<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<MyTreeNode<T>> children) {
        for(MyTreeNode<T> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<MyTreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}