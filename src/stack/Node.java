package stack;

public class Node {
	protected int data;
	protected Node link;
	public Node(){
		link=null;
	}
	public Node(int data,Node node){
		this.data=data;
		link=node;
	}
	public void setData(int data){
		this.data=data;
	}
	public void setLink(Node node){
		link=node;
	}
	public int getData(){
		return data;
	}
	public Node getLink(){
		return link;
	}
}
