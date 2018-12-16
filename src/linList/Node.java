package linList;

public class Node {
	
	Object data;
	com.mo.linList.Node next;
	
	/**
	 *	用于头节点 ，头节点是没有数据的
	 */
	public Node(com.mo.linList.Node nextval) {
		this.next = nextval; 
	}
	/**
	 * 用于其他的节点
	 */
	public Node(Object data, com.mo.linList.Node next) {
		this.data = data;
		this.next = next;
	}
	/**
	 * 获取该节点的下一个
	 */
	public Object getNext() {
		return next;
	}
	/**
	 * 设置该节点的下一个Node
	 */
	public void setNext(com.mo.linList.Node node) {
		this.next = node;
	}
	/**
	 * 取出该节点的数据
	 */
	public Object getData() {
		return data;
	}
	/**
	 *	设置该节点的数据
	 */
	public void setData(Object data) {
		this.data = data; 
	}
	public String toString() {
		return data.toString();
	}
}
