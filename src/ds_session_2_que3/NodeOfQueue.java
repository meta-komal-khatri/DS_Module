package ds_session_2_que3;

import stack.Node;

public class NodeOfQueue<E> {
		protected E data;
		protected NodeOfQueue<E> link;
		public NodeOfQueue(){
			link=null;
		}
		public NodeOfQueue(E data,NodeOfQueue<E> node){
			this.data=data;
			link=node;
		}
		public void setData(E data){
			this.data=data;
		}
		public void setLink(NodeOfQueue<E> node){
			link=node;
		}
		public E getData(){
			return data;
		}
		public NodeOfQueue<E> getLink(){
			return link;
		}
	}

