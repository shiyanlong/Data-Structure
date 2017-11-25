package com.mo.queue;

import com.mo.linList.Node;

/**
 * 队列，列表实现 
 */
public class LinQueue implements Queue {

	private Node front;//队头
	private Node rear;//队尾
	private int count;//计算器
	
	public LinQueue() {
		front = rear = null;
		count = 0;
	}
	
	public void append(Object obj) throws Exception {
		Node newNode = new Node(obj,null);
		if(rear != null) {
			//在本来的队尾连接新的队尾
			rear.setNext(newNode);
		}
		//队中还没有元素
		if(front == null) {
			front = newNode;
		}
		//设置当前队尾
		rear = newNode;
		count++;
	}
	public Object delete() throws Exception {
		if(count == 0) throw new Exception();
		Object obj = front.getData();
		front = (Node)front.getNext();
		count--;
		return obj;
	}
	
	public Object getFront() throws Exception {
		return front.getData();
	}
	public boolean isEmpty() {
		return count == 0;
	}
	
	public static void main(String[] args) throws Exception {
		LinQueue linQueue = new LinQueue();
		for(int i = 0; i < 10; i++) {
			//入队
			linQueue.append(i + 1);
		}
		System.out.println("从队中取元素" + linQueue.getFront());
		System.out.println("从队中取元素" + linQueue.getFront());
		while(!linQueue.isEmpty()) {
			//出队
			System.out.print(linQueue.delete());
		}
	}
	
}
