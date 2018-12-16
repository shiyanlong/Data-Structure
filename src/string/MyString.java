package string;

/**
 *	根据串的抽象数据类型，应该有两种功能的串:
 *		一种要求是:任何对串的连接，插入子串和删除子串操作 都是 不改变原来串的值的
 *		另一种要求是: 任何对串的连接，插入子串和删除子串操作 都是 改变原来串的值
 *
 *	java中，String类是第一种功能的类，StringBuffer类是第二中功能的类
 *
 *	JDK的串类
 *		String类和StringBuffer类都是基于字符数组实现的，
 *		不同的是，String类的串一经创建，串的数值是无法改变的，即是一种状态不可变的对象
 *			而StringBuffer类的串创建后，串的值是可以改变的，因而StringBuffer类的对象的长度是可以改变的
 */
public class MyString {
	
	private char[] value;//字符数组
	private int count;//字符个数

	public MyString() {
		value = new char[0];
	}

	//对传进来的value字符数组分隔，取  value[offset] 到   value[offset+count]
	public MyString(char[] value,int offset,int count) {
		if(offset < 0) throw new StringIndexOutOfBoundsException();
		if(count > value.length - offset) throw new StringIndexOutOfBoundsException();
		if(count < 0) throw new StringIndexOutOfBoundsException();
		//创建一个空的字符数组
		this.value = new char[count];
		this.count = count;
		//将空的字符数组填满
		arrayCopy(value, offset, this.value, 0, count);
	}
	
	public MyString(char[] arr) {
		this.count = arr.length;
		//创建一个空的字符数组
		this.value = new char[count];
		//将参数传进来的arr，放到this.value中，因为这时候this.value还是空的
		arrayCopy(arr, 0, this.value, 0, count);
	}
	
	public MyString(String str) {
		char[] charArray = str.toCharArray();
		this.value = charArray;
		count = this.value.length;
	}
	
	/**
	 * 复制数组 
	 * @param src 原数组
	 * @param srcPos 从原数组的srcPos下标开始复制，复制length个长度
	 * @param dst 目标数组
	 * @param dstPos 从目标数组的dstPos下标开始接受原数组的元素，接受length个长度
	 * @param length 要复制原数组的长度
	 */
	static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int length) {
		//这里是防止数组越界
		if(src.length - srcPos < length && dst.length - dstPos < length) throw new StringIndexOutOfBoundsException();
		for(int i = 0;i < length;i++) { 
			dst[dstPos] = src[srcPos];
			srcPos++;
			dstPos++;
		}
	}
	
	//取字符
	public char charAt(int index) {
		if(index < 0 || index > this.value.length) throw new StringIndexOutOfBoundsException();
		return this.value[index];
	}
	
	//取串的长度
	public int length() {
		return count;
	}
	
	//取子串
	public MyString subString(int begin, int end) {
		if(begin < 0 || end < 0 || end < begin || end > this.value.length) throw new StringIndexOutOfBoundsException();
		return new MyString(value,begin,end - begin);
	}
	
	//取子串，从begin一直到结束
	public MyString subString(int begin) {
		return subString(begin, count);
	}
	
	//并接字符串
	public MyString concat(MyString str) {
		int length = str.length();
		char[] array = str.toArray();
		//创建一个空的字符数组
		char[] newchar = new char[(length+count)];
		//将字符数组填满
		arrayCopy(this.value, 0, newchar, 0, count);
		arrayCopy(array, 0, newchar, count, length);
		return new MyString(newchar);
	}

	//插进子串，新增加的字符串str从原来的字符串pos位置添加
	public MyString insert(MyString str, int pos) {
		if(pos < 0 || pos > count) throw new StringIndexOutOfBoundsException();
		if(pos != 0) {
			MyString s1 = this.subString(0, pos);
			MyString s2 = this.subString(pos);
			MyString c1 = s1.concat(str);
			MyString c2 = c1.concat(s2);
			return c2;
		}else {
			return this.concat(str);
		}
	}

	//删除子串
	public MyString delete(int begin, int end) {
		if(end < begin || begin < 0 || end > count ) throw new StringIndexOutOfBoundsException();
		if(begin == 0 && end == 0) {
			return new MyString();
		}else {
			MyString s1 = this.subString(0, begin);
			MyString s2 = this.subString(end);
			return s1.concat(s2);
		}
	}
	
	//打印字符串
	public void myPrint() {
		for(int i = 0; i < count; i++) {
			System.out.print(value[i]);
		}
		System.out.println();
	}
	
	public char[] toArray() {
		//创建一个空的字符数组
		char[] buf = new char[count];
		//经过这一步就把新建的字符数组填满了
		arrayCopy(this.value, 0,buf ,0, count);
		return buf;
	}
	
	public static void main(String[] args) {
		char[] s1 = {'a','b','c','d','e','g'};
		char[] s2 = {'a','b','c','d','e','g','a','b','c','d','g','a','b','g','a','b'};
		
		MyString m1 = new MyString();
		m1.myPrint();

		MyString m2 = new MyString(s1);
		m2.myPrint();
		
		System.out.println("-------------");
	
		MyString m3 = new MyString(s2, 2, 7);
		m3.myPrint();
		System.out.println(m3.charAt(2));
		System.out.println(m3.length());
		System.out.println("end");

		System.out.println("-------------");
		
		MyString m4 = new MyString(s2);
		m4.myPrint();
		m4.subString((m4.length() - 3)).myPrint();
		
		m4.subString(0, 3).myPrint();
		
		System.out.println("------------------");
		
		MyString m5 = m4.subString(m4.length() - 3);
		MyString m6 = m4.subString(m4.length() - 4);
		m5.myPrint();
		m6.myPrint();
		MyString m7 = m5.insert(m6, 1);
		m7.delete(1, 3).myPrint();
	}
	
}
