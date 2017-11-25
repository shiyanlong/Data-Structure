package com.mo.string;

/**
 *	连接，插进子串和删除子串的成员函数都改变原来对象的串值
 */
public class MyStringBuffer {
	
	private char[] value;
	private int count;
	
	public MyStringBuffer(String str) {
		char[] charArray = str.toCharArray();
		this.value = charArray;
		this.count = charArray.length;
	}

	//申请更大的数组内存空间
	private void expandCapacity(int newCapacity) {
		char[] newValue = new char[newCapacity];
		arrayCopy(this.value, 0, newValue, 0, this.count);
		value = newValue;
	}
	
	//复制数组元素
	public static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int length) {
		for(int i = 0; i < length; i++) {
			dst[dstPos] = src[srcPos];
			dstPos++;
			srcPos++;
		}
	}
	
	public MyStringBuffer concat(MyStringBuffer str) {
		int length = str.length();
		char[] array = str.toArray();
		expandCapacity(this.count + length);
		arrayCopy(array, 0, this.value, count, length);
		count = count + length;
		return this;
	}
	
	public char[] toArray() {
		return value;
	}
	
	public int length() {
		return count;
	}
	
	public void myPrint() {
		for(int i = 0; i < count; i++) {
			System.out.print(value[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyStringBuffer m1 = new MyStringBuffer("abcde");
		MyStringBuffer m2 = new MyStringBuffer("fdhij");
		MyStringBuffer m3 = m1.concat(m2);
		m3.myPrint();
		m1.myPrint();
		m2.myPrint();      
	}
	
}
