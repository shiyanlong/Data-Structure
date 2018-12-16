package stack;

import com.mo.linList.Node;
import com.mo.stack.Stack;

//链表实现的堆栈
public class LinStack implements Stack{

	private Node head;//栈顶
	private int size;//栈中的元素个数
	
	public LinStack() {
		head = null;
		size = 0;
	}
	
	public void push(Object obj) throws Exception {
		Node node = new Node(obj,head);//把首节点放在新增的obj后面
		head = node;//设为当前节点
		size++;
	}

	public Object pop() throws Exception {
		if(size == 0) throw new Exception();
		Object oldHead = head.getData();//获取首节点的元素数据
		head = (Node)head.getNext();//把链表的下一个Node设为当前节点
		size--;
		return oldHead;
	}

	public Object getTop() throws Exception {
		if(size == 0) throw new Exception();
		return head.getData();
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) throws Exception {
		com.mo.stack.LinStack linStack = new com.mo.stack.LinStack();
		for(int i = 0; i < 10; i++) {
			linStack.push(i+1);
		}
		while(!linStack.isEmpty()) {
			System.out.print(linStack.pop());
		}
	}
	

}
