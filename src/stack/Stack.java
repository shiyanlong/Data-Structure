package stack;

/**
 * 	这是栈的接口，抽象数据类型
 */
public interface Stack {
	/**
	 *	入栈 
	 */
	void push(Object obj) throws Exception;
	/**
	 * 出栈 
	 */
	Object pop() throws Exception;
	/**
	 *	取出栈的元素 
	 */
	Object getTop() throws Exception;
	/**
	 *	栈是不是为空 
	 */
	boolean isEmpty();
}
