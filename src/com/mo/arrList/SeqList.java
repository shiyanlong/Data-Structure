package com.mo.arrList;

import org.junit.Test;

import com.mo.object.List;

/**
 *	这是一个数组实现的链表
 */
public class SeqList implements List {
	
	final int defaultSize = 10;//数组默认创建的长度
	int size;//数组的元素个数
	int maxSize;//数组的长度
	Object[] listArray;
	
	public SeqList() {
		init(defaultSize);
	}

	public SeqList(int maxSize) {
		init(maxSize);
	}

	/**
	 * 初始化数组对象
	 */
	private void init(int arrSize) {
		this.maxSize = arrSize;
		this.size = 0;
		this.listArray = new Object[arrSize];
	}
	
	public void insert(int i, Object obj) throws Exception {
		if(this.size == this.maxSize) {
			throw new Exception("数组已经满了，不能再插进元素了");
		}
		if(i < 0) {
			throw new Exception("输入的参数不能为零或者是负数");
		}
		if(i > this.maxSize) {
			throw new Exception("输出的参数不能大于该数组的长度");
		}
		for(int j = size; j > i; j--) {
			listArray[j] = listArray[j-1];
		}
		listArray[i] = obj;
		size++;
	}

	public Object delete(int i) throws Exception {
		if(size == 0) {
			throw new Exception("顺序表已经空了");
		}
		if(i < 0) {
			throw new Exception("输入的参数不能为负数或者是零");
		}
		if(i > maxSize) {
			throw new Exception("输入的参数不能大于数组的最大值");
		}
		Object obj = listArray[i];
		for(int j = i; j < size - 1; j++) {
			listArray[j] = listArray[j+1];
		}
		size--;
		return obj;
	}

	public Object getData(int i) {
		return listArray[i];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) throws Exception {
		SeqList arrList = new SeqList();
		for (int i = 0; i < 10; i++) {
			arrList.insert(i, "元素" + i);
		}
		System.out.println("size" + arrList.size());
		System.out.println("是否为空" + arrList.isEmpty());
		for(int j = 0; j<10; j++) {
			System.out.print("取出元素" + arrList.getData(j));
		}
		System.out.println();
		for(int i = 0; i < 10; i++) {
			System.out.print("删除元素" + arrList.delete(i));
		}
		System.out.println();
		System.out.println("size" + arrList.size());
		System.out.println("是否为空" + arrList.isEmpty());
		
		System.out.println("----------------------");
		
		SeqList seqList = new SeqList();
		for(int i = 0; i < 10; i++) {
			seqList.insert(i, new Integer(i+1));
		}
		seqList.delete(4);
		for(int i = 0; i < seqList.size(); i++) {
			System.out.print(seqList.getData(i));
		}
	}
	
	
	@Test
	public void testA() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
