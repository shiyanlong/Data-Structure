package com.mo.queue;

/**
 * 	顺序循环队列（数组实现）
 */
public class SeqQueue implements Queue {

	private final static int DEFAULTSIZE = 10;//默认创建的数组大小
	private int front;//队头的下标 
	private int rear;//队尾的下标
	private int count;//队中的元素个数
	private int maxSize;//队中能保存的最大元素个数
	Object[] data;//保持队列元素的数组
	
	public SeqQueue() {
		init(DEFAULTSIZE);
	}
	public SeqQueue(int size) {
		init(size);
	}
	
	private void init(int size) {
		maxSize = size;
		data = new Object[size];
		count = 0;
		front = 0;
		rear = 0;
	}
	
	// 入队 --> 加一个元素在队尾，rear要加一，count要加一
	public void append(Object obj) throws Exception {
		if(count == maxSize) throw new Exception();
		data[rear] = obj;
		rear = (rear + 1) % maxSize;
		count++;
	}

	// 出队 --> 从队头删除一个元素，front要减一，count减一
	public Object delete() throws Exception {
		if(count == 0) throw new Exception();
		Object obj = data[front];
		front = (front + 1) % maxSize;
		count--;
		return obj;
	}

	public Object getFront() throws Exception {
		if(count == 0) throw new Exception();
		return data[front];
	}

	public boolean isEmpty() {
		return count == 0;
	}
	
	public static void main(String[] args) throws Exception {
		SeqQueue seqQueue = new SeqQueue();
		for(int i = 0;i < 10; i++) {
			//入队
			seqQueue.append(i + 1);
		}
		while(!seqQueue.isEmpty()) {
			//出队
			System.out.print(seqQueue.delete());
		}
	}

}
