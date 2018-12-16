package vector;

/**
 * @author 文龙
 * @version 2017-11-25 下午8:00:59
 * 
 * 未完
 * 
 */
public class MyVector {

	private Object[] elementData;//数据元素
	private int elementCount;//元素个数
	
	//构造函数
	public MyVector() {
		this(10);
	}
	
	public MyVector(int size) {
		elementData = new Object[size];
		elementCount = 0; 
	}
	
	//扩大数组
	public void ensureCapacity() throws Exception {
		Object[] newarr = new Object[elementData.length*2];
		arrayCopy(elementData, 0, newarr, 0, elementCount);
		this.elementData = newarr;
	}
	
	//复制数组
	private static void arrayCopy(Object[] src,int srcPos,Object[] dst,int dstPos,int length) throws Exception {
		if(srcPos < 0 || dstPos < 0 || dst.length - dstPos < length) throw new Exception(); 
		for(int i = 0; i < length; i++) {
			dst[dstPos++] = src[srcPos++];
		}
	}
	
	public void add(int index,Object obj) throws Exception {
		if(elementCount >= elementData.length) {
			ensureCapacity();
		}
		for(int i = 0; i < elementCount - index; i++) {
			elementData[elementCount] = elementData[elementCount - 1];
		}
		elementData[elementCount] = obj;
		elementData[elementCount] = obj;
		elementCount++;
	}
	
	public void add(Object obj) throws Exception {
		add(elementCount, obj);
	}
	
	//重置，返回被重置的元素
	public Object set(int index,Object obj) {
		Object oldobj = elementData[index];
		elementData[index] = obj;
		return oldobj;
	}
	
	public Object get(int index) {
		return elementData[index];
	}
	
	public int getSize() {
		return elementCount;
	}
	
	public void myPrint() {
		for(int i = 0; i < elementCount; i++) {
			System.out.print(elementData[i].toString() + " ");
		}
		System.out.println();
	}
	
	
	/*----------------------以下方法是为了构造  集合  才新增的方法-----------------------------------*/

	//查找
	public int indexOf(Object obj) {
		if(elementCount == 0) {
			return -1;
		}else {
			for(int i = 0; i < elementCount; i++) {
				if(elementData[i].equals(obj)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	//是否存在
	public boolean contain(Object obj) {
		for(int i = 0; i < elementCount; i++) {
			if(elementData[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	//删除元素
	public Object remove(Object obj) {
		for(int i = 0; i < elementCount; i++) {
			if(elementData[i].equals(obj)) {
				Object oldObj = elementData[i];
				int k = elementCount - i;
				//将后面的元素移动到前面
				for(int j = 0; j < k; j++) {
					elementData[i] = elementData[i + 1];
					i++;
				}
				elementCount--;//元素的个数减一
				return oldObj;
			}
		}
		return null;
	}
	
	//删除第index个元素
	public Object remove(int index) throws Exception {
		if(index < 0 || index >= elementCount) throw new Exception();
		Object oldObj = elementData[index];
		int removeCount = elementCount - index;
		for(int i = 0; i < removeCount ; i++) {
			//将后面的元素移到前面
			elementData[index] = elementData[(index + 1)];
			index++;
		}
		elementData[elementCount - 1] = null;
		elementCount--;
		return oldObj;
	}
 	
	
	public static void main(String[] args) throws Exception {
		MyVector myVector = new MyVector();
		for(int i = 0; i < 8; i++) {
			myVector.add(new Integer(i + 1));
		}
		System.out.println("个数" + myVector.getSize());
		myVector.myPrint();
		System.out.println("被删除的元素为" + myVector.remove(new Integer(3)));
		myVector.myPrint();
		System.out.println("个数" + myVector.getSize());
		System.out.println("被删除的元素为" + myVector.remove(1));
		myVector.myPrint();
		System.out.println("个数" + myVector.getSize());
		
		System.out.println("end");
		myVector.set(0, new Integer(9));
		System.out.println(myVector.get(0));
		//测试查找指定元素的下标 和 查找是不是包含元素
		System.out.println(myVector.indexOf(new Integer(3)));
		System.out.println(myVector.contain(new Integer(18)));
		
		System.out.println(myVector.getSize());
		//测试删除元素
		System.out.println(myVector.remove(new Integer(3)));
		System.out.println(myVector.getSize());
		myVector.myPrint();
	}
	
}
